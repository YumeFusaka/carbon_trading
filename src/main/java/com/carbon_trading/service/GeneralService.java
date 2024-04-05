package com.carbon_trading.service;

import com.carbon_trading.pojo.VO.EnterpriseVO;
import com.carbon_trading.pojo.VO.TradeVO;

import java.util.ArrayList;

public interface  GeneralService {
    ArrayList<EnterpriseVO> getEnterprises();

    ArrayList<TradeVO> getTrades();
}
