package com.carbon_trading.controller.enterprise;

import com.alibaba.fastjson.JSON;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.common.properties.JwtProperties;
import com.carbon_trading.common.result.Result;
import com.carbon_trading.pojo.DTO.ElectricGridDTO;
import com.carbon_trading.pojo.DTO.GenerateElectricityDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.DTO.EnterpriseRegisterDTO;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.VO.LoginVO;
import com.carbon_trading.service.ElectricGridService;
import com.carbon_trading.service.EnterpriseService;
import com.carbon_trading.service.GenerateElectricityService;
import com.carbon_trading.utils.JwtUtils;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/enterprise")
@Tag(name = "企业相关接口")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private JwtProperties jwtProperties;

    @Autowired
    private GenerateElectricityService generateElectricityService;

    @Autowired
    private ElectricGridService electricGridService;

    @GetMapping("/hello")
    @Operation(summary = "hello")
    public Result<String> hello() {
        return Result.success("hello enterprise");
    }


    @PostMapping("/register")
    @Operation(summary = "注册")
    public Result register(@RequestBody EnterpriseRegisterDTO enterpriseRegisterDTO){
        log.info("公司注册:{}",enterpriseRegisterDTO);
        enterpriseService.register(enterpriseRegisterDTO);
        return Result.success();
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result<LoginVO> login(@RequestBody LoginDTO enterpriseLoginDTO) {
        log.info("公司登录:{}", enterpriseLoginDTO);
        Enterprise enterprise = enterpriseService.login(enterpriseLoginDTO);
        Map<String,Object> claims = new HashMap<>();
        claims.put("identity", "enterprise");
        claims.put("type",enterprise.getType());
        claims.put("account",enterprise.getAccount());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        log.info("返回token:{}",token);
        return Result.success(LoginVO.builder()
                .Authorization(token)
                .build());
    }

    @PostMapping("/submit/generateElectricity")
    @Operation(summary = "提交发电企业数据")
    public Result generateElectricitySubmit(@RequestBody GenerateElectricityDTO generateElectricityDTO) {
        log.info("提交发电企业数据:{}", generateElectricityDTO);
        generateElectricityService.submit(generateElectricityDTO);
        return Result.success();
    }

    @PostMapping("/submit/electricGrid")
    @Operation(summary = "提交电网企业数据")
    public Result electricGridSubmit(@RequestBody ElectricGridDTO electricGridDTO) {
        log.info("提交电网企业数据:{}", electricGridDTO);
        electricGridService.submit(electricGridDTO);
        return Result.success();
    }
}
