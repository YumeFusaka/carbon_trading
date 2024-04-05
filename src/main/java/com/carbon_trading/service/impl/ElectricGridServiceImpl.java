package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.ElectricGridMapper;
import com.carbon_trading.pojo.Entity.ElectricGrid;
import com.carbon_trading.service.ElectricGridService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ElectricGridServiceImpl extends ServiceImpl<ElectricGridMapper, ElectricGrid> implements ElectricGridService {

    @Autowired
    private ElectricGridMapper electricGridMapper;
}
