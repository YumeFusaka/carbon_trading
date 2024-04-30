package com.carbon_trading.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class EnterpriseVO {

    Long id;

    String name;

    String type;

    Double carbon_coin;

    LocalDateTime create_time;

    Integer submit_count;

    Integer trade_count;
}
