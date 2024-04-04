package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Admin;

public interface AdminService extends IService<Admin> {
    Admin login(LoginDTO adminLoginDTO);
}
