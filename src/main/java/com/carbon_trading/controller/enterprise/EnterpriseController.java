package com.carbon_trading.controller.enterprise;

import com.carbon_trading.common.properties.JwtProperties;
import com.carbon_trading.common.result.Result;
import com.carbon_trading.pojo.DTO.*;
import com.carbon_trading.pojo.Entity.ElectricGrid;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.Entity.GenerateElectricity;
import com.carbon_trading.pojo.VO.ElectricGridVO;
import com.carbon_trading.pojo.VO.GenerateElectricityVO;
import com.carbon_trading.pojo.VO.LoginVO;
import com.carbon_trading.pojo.VO.TradeVO;
import com.carbon_trading.service.ElectricGridService;
import com.carbon_trading.service.EnterpriseService;
import com.carbon_trading.service.EnterpriseTradeService;
import com.carbon_trading.service.GenerateElectricityService;
import com.carbon_trading.utils.JwtUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private EnterpriseTradeService enterpriseTradeService;

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
        claims.put("name",enterprise.getName());
        String token = JwtUtils.createToken(jwtProperties.getSecretKey(),jwtProperties.getTtl(),claims);
        log.info("返回token:{}",token);
        return Result.success(LoginVO.builder()
                .Authorization(token)
                .type(enterprise.getType())
                .build());
    }

    @PostMapping("/submit/generateElectricity")
    @Operation(summary = "提交发电数据")
    public Result generateElectricitySubmit(@RequestBody GenerateElectricityDTO generateElectricityDTO) {
        log.info("提交发电企业数据:{}", generateElectricityDTO);
        generateElectricityService.submit(generateElectricityDTO);
        return Result.success();
    }

    @PostMapping("/submit/electricGrid")
    @Operation(summary = "提交电网数据")
    public Result electricGridSubmit(@RequestBody ElectricGridDTO electricGridDTO) {
        log.info("提交电网企业数据:{}", electricGridDTO);
        electricGridService.submit(electricGridDTO);
        return Result.success();
    }

    @GetMapping("/history/generateElectricity")
    @Operation(summary = "发电历史数据")
    public Result<ArrayList<GenerateElectricityVO>> getGenerateElectricityHistory() {
        List<GenerateElectricity> generateElectricities = generateElectricityService.queryHistory();
        ArrayList<GenerateElectricityVO> generateElectricityVOS = new ArrayList<>();
        for (GenerateElectricity generateElectricity : generateElectricities){
            GenerateElectricityVO generateElectricityVO = new GenerateElectricityVO();
            BeanUtils.copyProperties(generateElectricity, generateElectricityVO);
            generateElectricityVOS.add(generateElectricityVO);
        }
        return Result.success(generateElectricityVOS);
    }

    @GetMapping("/history/electricityGrid")
    @Operation(summary = "电网历史数据")
    public Result<ArrayList<ElectricGridVO>> getElectricityGridHistory() {
        List<ElectricGrid> electricGrids = electricGridService.queryHistory();
        ArrayList<ElectricGridVO> electricGridVOS = new ArrayList<>();
        for (ElectricGrid electricGrid : electricGrids){
            ElectricGridVO electricGridVO = new ElectricGridVO();
            BeanUtils.copyProperties(electricGrid, electricGridVO);
            electricGridVOS.add(electricGridVO);
        }
        return Result.success(electricGridVOS);
    }

    @PostMapping("/trade")
    @Operation(summary = "交易")
    public Result trade(@RequestBody EnterpriseTradeDTO enterpriseTradeDTO) {
        log.info("发起交易:{}",enterpriseTradeDTO);
        enterpriseTradeService.trade(enterpriseTradeDTO);
        return Result.success();
    }


    @GetMapping("/history/trade")
    @Operation(summary = "历史交易记录")
    public Result<ArrayList<TradeVO>> historyTrade() {
        return Result.success(enterpriseTradeService.historyTrade());
    }

    @PostMapping("/handle/trade")
    @Operation(summary = "处理交易")
    public Result handleTrade(@RequestBody HandleTradeDTO handleTradeDTO) {
        log.info("处理交易:{}", handleTradeDTO);
        enterpriseTradeService.handleTrade(handleTradeDTO);
        return Result.success();
    }
}
