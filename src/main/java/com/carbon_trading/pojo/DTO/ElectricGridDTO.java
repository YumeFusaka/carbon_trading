package com.carbon_trading.pojo.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ElectricGridDTO {

    @JsonProperty(value = "PPGCP")
    private Double PPGCP;

    @JsonProperty(value = "IEE")
    private Double IEE;

    @JsonProperty(value = "IIE")
    private Double IIE;

    private Double electricity_sales;

    private Double fix_capacity;

    private Double fix_recovery;

    private Double retirement_capacity;

    private Double retirement_recovery;

    private Double transmission_distribution;

}
