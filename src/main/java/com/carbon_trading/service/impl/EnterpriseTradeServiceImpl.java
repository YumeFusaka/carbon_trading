package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.common.context.ThreadInfo;
import com.carbon_trading.component.SoildityComponent;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.mapper.EnterpriseTradeMapping;
import com.carbon_trading.pojo.DTO.EnterpriseTradeDTO;
import com.carbon_trading.pojo.DTO.HandleTradeDTO;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.Entity.Trade;
import com.carbon_trading.pojo.VO.TradeVO;
import com.carbon_trading.service.EnterpriseTradeService;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.transaction.model.exception.TransactionBaseException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class EnterpriseTradeServiceImpl extends ServiceImpl<EnterpriseTradeMapping, Trade> implements EnterpriseTradeService {

    @Autowired
    private EnterpriseTradeMapping enterpriseTradeMapping;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private SoildityComponent soildityComponent;

    @Override
    public void trade(EnterpriseTradeDTO enterpriseTradeDTO) {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        Enterprise enterprise = enterpriseMapper.selectOne(new QueryWrapper<Enterprise>().eq("id", enterpriseTradeDTO.getReceiver_id()));
        String receiverAccount = enterprise.getAccount();
        String receiverName = enterprise.getName();
        Trade trade = new Trade();
        trade.setInitiator_account(currentInfo.getAccount());
        trade.setReceiver_account(receiverAccount);
        trade.setInitiator_name(currentInfo.getName());
        trade.setReceiver_name(receiverName);
        trade.setContent(enterpriseTradeDTO.getContent());
        trade.setPay_coin(enterpriseTradeDTO.getPay_coin());
        trade.setStatus("待接受");
        trade.setCreate_date(LocalDateTime.now());
        enterpriseTradeMapping.insert(trade);
    }

    @Override
    public ArrayList<TradeVO> historyTrade() {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        QueryWrapper<Trade> wrapper = new QueryWrapper<Trade>();
        wrapper.eq("initiator_account", currentInfo.getAccount()).or()
                .eq("receiver_account", currentInfo.getAccount());
        List<Trade> trades = enterpriseTradeMapping.selectList(wrapper);
        ArrayList<TradeVO> tradeVOS = new ArrayList<>();
        for (Trade trade : trades) {
            TradeVO tradeVO = new TradeVO();
            BeanUtils.copyProperties(trade, tradeVO);
            tradeVOS.add(tradeVO);
        }
        return tradeVOS;
    }

    @Override
    public void handleTrade(HandleTradeDTO handleTradeDTO) {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        Trade trade = enterpriseTradeMapping.selectOne(new QueryWrapper<Trade>().eq("id", handleTradeDTO.getTrade_id()));
        UpdateWrapper<Trade> wrapper = new UpdateWrapper<>();
        wrapper.eq("id", handleTradeDTO.getTrade_id())
                .eq("receiver_account", currentInfo.getAccount())
                .set("status", handleTradeDTO.getStatus() == 1 ? "已接受" : "已拒绝");
        if (handleTradeDTO.getStatus() == 1) {
            try {
                String map_id = soildityComponent.addRecord(trade.getInitiator_account(), "0", trade.getPay_coin().toString(), handleTradeDTO.getTrade_id());
                wrapper.set("map_id", map_id);
            } catch (ABICodecException | TransactionBaseException e) {
                throw new RuntimeException(e);
            }
        }
        enterpriseTradeMapping.update(wrapper);
    }
}
