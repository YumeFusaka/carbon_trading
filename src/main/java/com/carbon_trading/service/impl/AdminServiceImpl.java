package com.carbon_trading.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.AdminMapper;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Admin;
import com.carbon_trading.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(LoginDTO adminLoginDTO) {
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("account", adminLoginDTO.getAccount())
                .eq("password", adminLoginDTO.getPassword()));
        if (admin == null) {
            throw new RuntimeException("账号或者密码错误");
        }
        return admin;
    }
}
