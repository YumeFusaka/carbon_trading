package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.AgencyMapper;
import com.carbon_trading.pojo.DTO.AgencyRegisterDTO;
import com.carbon_trading.pojo.DTO.AgencyRegisterDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Agency;
import com.carbon_trading.pojo.Entity.Agency;
import com.carbon_trading.service.AgencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AgencyServiceImpl extends ServiceImpl<AgencyMapper, Agency> implements AgencyService {

    @Autowired
    private AgencyMapper agencyMapper;

    @Override
    public void register(AgencyRegisterDTO agencyRegisterDTO) {
        Agency agency = agencyMapper.selectOne(new QueryWrapper<Agency>().eq("account", agencyRegisterDTO.getAccount())
                .eq("password", agencyRegisterDTO.getPassword()));
        if(agency != null){
            throw new RuntimeException("该账号已被注册");
        }
        agency = new Agency();
        BeanUtils.copyProperties(agencyRegisterDTO, agency);
        agencyMapper.insert(agency);
    }

    @Override
    public Agency login(LoginDTO agencyLoginDTO) {
        Agency agency = agencyMapper.selectOne(new QueryWrapper<Agency>().eq("account", agencyLoginDTO.getAccount()));
        if (agency == null) {
            throw new RuntimeException("账号或者密码错误");
        }
        return agency;
    }
}
