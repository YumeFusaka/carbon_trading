package com.carbon_trading.pojo.DTO;

import lombok.Data;

@Data
public class GenerateElectricityDTO {

    private Double coal_burning;

    private Double coke_oven_gas;

    private Double crude_oil;

    private Double desulfurizing_agent;

    private Double electricity;

    private Double fuel_oil;

    private Double gasoline;

    private Double natural_gas;

    private Double other_gas;

    private Double other_products;

    private Double refinery_gas;
}
