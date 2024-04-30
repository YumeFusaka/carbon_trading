package com.carbon_trading.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.carbon_trading.pojo.DTO.AuditDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Admin;
import com.carbon_trading.pojo.VO.AdminVO;

public interface AdminService extends IService<Admin> {
    Admin login(LoginDTO adminLoginDTO);

    void auditGenerateElectric(AuditDTO auditDTO);

    void auditElectricGrid(AuditDTO auditDTO);

    AdminVO getInfo();
}
