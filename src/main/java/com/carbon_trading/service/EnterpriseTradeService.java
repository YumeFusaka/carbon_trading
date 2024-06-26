package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.EnterpriseTradeDTO;
import com.carbon_trading.pojo.DTO.HandleTradeDTO;
import com.carbon_trading.pojo.Entity.Trade;
import com.carbon_trading.pojo.VO.TradeVO;

import java.util.ArrayList;

public interface EnterpriseTradeService extends IService<Trade> {
    void trade(EnterpriseTradeDTO enterpriseTradeDTO);

    ArrayList<TradeVO> historyTrade();

    void handleTrade(HandleTradeDTO handleTradeDTO);
}
