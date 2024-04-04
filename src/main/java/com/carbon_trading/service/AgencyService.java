package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.AgencyRegisterDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Agency;

public interface AgencyService extends IService<Agency> {
    void register(AgencyRegisterDTO agencyRegisterDTO);

    Agency login(LoginDTO agencyLoginDTO);
}
