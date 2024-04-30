package com.carbon_trading.pojo.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class TradeVO {
    private Long id;

    private String initiator_account;

    private String receiver_account;

    private String initiator_name;

    private String receiver_name;

    private String content;

    private Double pay_coin;

    private String status;

    private LocalDateTime create_date;
}
