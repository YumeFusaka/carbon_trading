package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.EnterpriseTradeDTO;
import com.carbon_trading.pojo.Entity.Trade;

public interface EnterpriseTradeService extends IService<Trade> {
    void trade(EnterpriseTradeDTO enterpriseTradeDTO);
}
