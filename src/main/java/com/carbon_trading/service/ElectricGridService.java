package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.ElectricGridDTO;
import com.carbon_trading.pojo.Entity.ElectricGrid;

public interface ElectricGridService extends IService<ElectricGrid> {
    void submit(ElectricGridDTO electricGridDTO);
}
