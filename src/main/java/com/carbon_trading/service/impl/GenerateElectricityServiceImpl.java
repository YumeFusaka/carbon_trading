package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.GenerateElectricityMapper;
import com.carbon_trading.pojo.Entity.GenerateElectricity;
import com.carbon_trading.service.GenerateElectricityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class GenerateElectricityServiceImpl extends ServiceImpl<GenerateElectricityMapper, GenerateElectricity> implements GenerateElectricityService {

    @Autowired
    private GenerateElectricityMapper generateElectricityMapper;
}
