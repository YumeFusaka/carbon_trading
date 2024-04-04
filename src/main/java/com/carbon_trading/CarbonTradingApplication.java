package com.carbon_trading;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("com.carbon_trading.mapper")
public class CarbonTradingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarbonTradingApplication.class, args);
        log.info("springboot start");
    }

}
