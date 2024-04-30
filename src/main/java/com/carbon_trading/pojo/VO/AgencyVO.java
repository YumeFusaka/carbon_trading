package com.carbon_trading.pojo.VO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgencyVO {
    Long id;

    String account;

    String password;

    String name;

    LocalDateTime create_time;
}
