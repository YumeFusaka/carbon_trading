package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.service.EnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;
}
