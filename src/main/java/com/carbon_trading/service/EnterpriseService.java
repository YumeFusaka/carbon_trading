package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.EnterpriseRegisterDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.VO.EnterpriseVO;

public interface EnterpriseService extends IService<Enterprise> {
    void register(EnterpriseRegisterDTO enterpriseRegisterDTO);

    Enterprise login(LoginDTO enterpriseLoginDTO);

    EnterpriseVO getInfo();
}
