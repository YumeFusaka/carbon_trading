package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.VO.EnterpriseVO;

import java.util.ArrayList;

public interface  GeneralService extends IService<Enterprise> {
    ArrayList<EnterpriseVO> getEnterprises();
}
