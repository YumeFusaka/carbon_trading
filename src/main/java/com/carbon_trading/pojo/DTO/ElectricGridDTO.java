package com.carbon_trading.pojo.DTO;

import lombok.Data;

@Data
public class ElectricGridDTO {

    private Double PPGCP;

    private Double IEE;

    private Double IIE;

    private Double electricity_sales;

    private Double fix_capacity;

    private Double fix_recovery;

    private Double retirement_capacity;

    private Double retirement_recovery;

    private Double transmission_distribution;

}
