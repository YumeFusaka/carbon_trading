package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.pojo.DTO.EnterpriseLoginDTO;
import com.carbon_trading.pojo.DTO.EnterpriseRegisterDTO;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.service.EnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class EnterpriseServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements EnterpriseService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public void register(EnterpriseRegisterDTO enterpriseRegisterDTO) {
        Enterprise enterprise = enterpriseMapper.selectOne(new QueryWrapper<Enterprise>().eq("account", enterpriseRegisterDTO.getAccount()));
        if(enterprise != null){
            throw new RuntimeException("该账号已被注册");
        }
        enterprise = new Enterprise();
        BeanUtils.copyProperties(enterpriseRegisterDTO, enterprise);
        enterpriseMapper.insert(enterprise);
    }

    @Override
    public Enterprise login(EnterpriseLoginDTO enterpriseLoginDTO) {
        Enterprise enterprise = enterpriseMapper.selectOne(new QueryWrapper<Enterprise>().eq("account", enterpriseLoginDTO.getAccount()));
        if (enterprise == null) {
            throw new RuntimeException("账号或者密码错误");
        }
        return enterprise;
    }
}
