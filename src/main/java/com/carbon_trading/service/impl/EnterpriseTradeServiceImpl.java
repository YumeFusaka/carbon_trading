package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.common.context.ThreadInfo;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.mapper.EnterpriseTradeMapping;
import com.carbon_trading.pojo.DTO.EnterpriseTradeDTO;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.Entity.Trade;
import com.carbon_trading.service.EnterpriseTradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EnterpriseTradeServiceImpl extends ServiceImpl<EnterpriseTradeMapping, Trade> implements EnterpriseTradeService {

    @Autowired
    private EnterpriseTradeMapping enterpriseTradeMapping;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public void trade(EnterpriseTradeDTO enterpriseTradeDTO) {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        String receiverAccount = enterpriseMapper.selectOne(new QueryWrapper<Enterprise>().eq("id", enterpriseTradeDTO.getId())).getAccount();
        Trade trade = new Trade();
        trade.setInitiatorAccount(currentInfo.getAccount());
        trade.setReceiverAccount(receiverAccount);
        trade.setContent(enterpriseTradeDTO.getContent());
        trade.setPayCoin(enterpriseTradeDTO.getPay_coin());
        trade.setStatus("待接受");
        trade.setCreateDate(LocalDateTime.now());
        enterpriseTradeMapping.insert(trade);
    }
}
