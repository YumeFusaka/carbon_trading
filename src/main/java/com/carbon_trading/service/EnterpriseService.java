package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.EnterpriseLoginDTO;
import com.carbon_trading.pojo.DTO.EnterpriseRegisterDTO;
import com.carbon_trading.pojo.Entity.Enterprise;

public interface EnterpriseService extends IService<Enterprise> {
    void register(EnterpriseRegisterDTO enterpriseRegisterDTO);

    Enterprise login(EnterpriseLoginDTO enterpriseLoginDTO);
}
