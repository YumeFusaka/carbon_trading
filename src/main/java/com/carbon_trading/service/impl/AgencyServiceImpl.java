package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.AgencyMapper;
import com.carbon_trading.pojo.Entity.Agency;
import com.carbon_trading.service.AgencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AgencyServiceImpl extends ServiceImpl<AgencyMapper, Agency> implements AgencyService {

    @Autowired
    private AgencyMapper agencyMapper;
}
