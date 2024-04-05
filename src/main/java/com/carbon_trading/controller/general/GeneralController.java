package com.carbon_trading.controller.general;

import com.carbon_trading.common.result.Result;
import com.carbon_trading.pojo.VO.EnterpriseVO;
import com.carbon_trading.service.GeneralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@Slf4j
@RequestMapping("/general")
@Tag(name = "通用相关接口")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @GetMapping("/enterprises")
    @Operation(summary = "获取所有公司信息")
    public Result<ArrayList<EnterpriseVO>> getEnterprises() {
        return Result.success(generalService.getEnterprises());
    }
}
