package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.GenerateElectricityDTO;
import com.carbon_trading.pojo.Entity.GenerateElectricity;

public interface GenerateElectricityService extends IService<GenerateElectricity> {
    void submit(GenerateElectricityDTO generateElectricityDTO);
}
