package com.carbon_trading.pojo.VO;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class ElectricGridVO {

    private Long id;

    private String account;

    private String name;

    private LocalDateTime create_date;

    private String status;

    private Double consumption;

    @JsonProperty(value = "PPGCP")
    private Double PPGCP;

    @JsonProperty(value = "IIE")
    private Double IIE;

    @JsonProperty(value = "IEE")
    private Double IEE;

    private Double electricity_sales;

    private Double transmission_distribution;

    private Double retirement_capacity;

    private Double retirement_recovery;

    private Double fix_capacity;

    private Double fix_recovery;
}
