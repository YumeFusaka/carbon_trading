package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.mapper.EnterpriseTradeMapping;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.Entity.Trade;
import com.carbon_trading.pojo.VO.EnterpriseVO;

import com.carbon_trading.pojo.VO.TradeVO;
import com.carbon_trading.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private EnterpriseTradeMapping enterpriseTradeMapping;

    @Override
    public ArrayList<EnterpriseVO> getEnterprises() {
        BaseContext.removeCurrentInfo();
        List<Enterprise> enterprises = enterpriseMapper.selectList(new QueryWrapper<Enterprise>());
        ArrayList<EnterpriseVO> enterpriseVOS = new ArrayList<>();
        for(Enterprise enterprise : enterprises){
            EnterpriseVO enterpriseVO = new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            enterpriseVOS.add(enterpriseVO);
        }
        return enterpriseVOS;
    }

    @Override
    public ArrayList<TradeVO> getTrades() {
        BaseContext.removeCurrentInfo();
        List<Trade> trades = enterpriseTradeMapping.selectList(new QueryWrapper<Trade>());
        ArrayList<TradeVO> tradeVOS = new ArrayList<>();
        for(Trade trade : trades){
            TradeVO tradeVO = new TradeVO();
            BeanUtils.copyProperties(trade,tradeVO);
            tradeVOS.add(tradeVO);
        }
        return tradeVOS;
    }
}
