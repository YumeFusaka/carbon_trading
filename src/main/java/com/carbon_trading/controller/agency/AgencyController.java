package com.carbon_trading.controller.agency;

import com.carbon_trading.common.properties.JwtProperties;
import com.carbon_trading.common.result.Result;
import com.carbon_trading.pojo.DTO.AgencyRegisterDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Agency;
import com.carbon_trading.pojo.VO.LoginVO;
import com.carbon_trading.service.AgencyService;
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
@RequestMapping("/agency")
@Tag(name="机构相关接口")
public class AgencyController {

    @Autowired
    private AgencyService agencyService;
    
    @Autowired
    private JwtProperties jwtProperties;

    @GetMapping("/hello")
    @Operation(summary = "hello")
    public Result<String> hello() {
        return Result.success("hello agency");
    }

    @PostMapping("/register")
    @Operation(summary = "注册")
    public Result register(@RequestBody AgencyRegisterDTO agencyRegisterDTO){
        log.info("公司注册:{}",agencyRegisterDTO);
        agencyService.register(agencyRegisterDTO);
        return Result.success();
    }

    @PostMapping("/login")
    @Operation(summary = "登录")
    public Result<LoginVO> login(@RequestBody LoginDTO agencyLoginDTO) {
        log.info("公司登录:{}", agencyLoginDTO);
        Agency agency = agencyService.login(agencyLoginDTO);
        Map<String,Object> claims = new HashMap<>();
        claims.put("identity", "agency");
        claims.put("account",agency.getAccount());
        claims.put("name",agency.getName());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        log.info("返回token:{}",token);
        return Result.success(LoginVO.builder()
                .Authorization(token)
                .build());
    }
}
