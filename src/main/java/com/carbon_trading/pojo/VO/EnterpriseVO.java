package com.carbon_trading.pojo.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.time.LocalDateTime;

@Data
public class EnterpriseVO {

    Long id;

    String name;

    String type;

    Double carbon_coin;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime create_time;

    Integer submit_count;

    Integer trade_count;
}
