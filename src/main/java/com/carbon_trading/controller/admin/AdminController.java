package com.carbon_trading.controller.admin;

import com.carbon_trading.common.result.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/admin")
@Tag(name = "管理相关接口")
public class AdminController {

    @GetMapping("/hello")
    @Operation(summary = "hello")
    public Result<String> hello() {
        return Result.success("hello admin");
    }
}
