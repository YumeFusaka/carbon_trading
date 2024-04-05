package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.GenerateElectricityDTO;
import com.carbon_trading.pojo.Entity.GenerateElectricity;

import java.util.List;

public interface GenerateElectricityService extends IService<GenerateElectricity> {
    void submit(GenerateElectricityDTO generateElectricityDTO);

    List<GenerateElectricity> queryHistory();
}
