package com.carbon_trading.pojo.VO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ElectricGridVO {

    private Long id;

    private String account;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_date;

    private String status;

    private Double consumption;

    private Double PPGCP;

    private Double IIE;

    private Double IEE;

    private Double electricity_sales;

    private Double transmission_distribution;

    private Double retirement_capacity;

    private Double retirement_recovery;

    private Double fix_capacity;

    private Double fix_recovery;
}
