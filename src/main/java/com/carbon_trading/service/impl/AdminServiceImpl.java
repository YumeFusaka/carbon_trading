package com.carbon_trading.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.AdminMapper;
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
}
