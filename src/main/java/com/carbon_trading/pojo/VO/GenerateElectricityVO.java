package com.carbon_trading.pojo.VO;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
public class GenerateElectricityVO {

    private Long id;

    private String status;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_date;

    private Double consumption;

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
