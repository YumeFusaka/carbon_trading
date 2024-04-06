package com.carbon_trading.controller.admin;

import com.carbon_trading.common.properties.JwtProperties;
import com.carbon_trading.common.result.Result;
import com.carbon_trading.pojo.DTO.AuditDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Admin;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.VO.LoginVO;
import com.carbon_trading.service.AdminService;
import com.carbon_trading.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/admin")
@Tag(name = "管理相关接口")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JwtProperties jwtProperties;

    @GetMapping("/hello")
    @Operation(summary = "hello")
    public Result<String> hello() {
        return Result.success("hello admin");
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result<LoginVO> login(@RequestBody LoginDTO adminLoginDTO) {
        log.info("公司登录:{}", adminLoginDTO);
        Admin admin = adminService.login(adminLoginDTO);
        Map<String,Object> claims = new HashMap<>();
        claims.put("identity", "admin");
        claims.put("account",admin.getAccount());
        claims.put("name",admin.getName());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        log.info("返回token:{}",token);
        return Result.success(LoginVO.builder()
                .Authorization(token)
                .build());
    }

    @PostMapping("/audit/generateElectric")
    @Operation(summary = "审核发电")
    public Result auditGenerateElectric(@RequestBody AuditDTO auditDTO) {
        log.info("审核发电:{}", auditDTO);
        adminService.auditGenerateElectric(auditDTO);
        return Result.success();
    }

    @PostMapping("/audit/electricGrid")
    @Operation(summary = "审核电网")
    public Result auditElectricGrid(@RequestBody AuditDTO auditDTO) {
        log.info("审核电网:{}", auditDTO);
        adminService.auditElectricGrid(auditDTO);
        return Result.success();
    }
}
