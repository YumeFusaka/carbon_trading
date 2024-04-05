package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@TableName("generate_electricity")
public class GenerateElectricity implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("account")
    private String account;

    @TableField("create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime create_date;

    @TableField("status")
    private String status;

    @TableField("consumption")
    private Double consumption;

    @TableField("coal_burning")
    private Double coal_burning;

    @TableField("crude_oil")
    private Double crude_oil;

    @TableField("fuel_oil")
    private Double fuel_oil;

    @TableField("gasoline")
    private Double gasoline;

    @TableField("refinery_gas")
    private Double refinery_gas;

    @TableField("other_products")
    private Double other_products;

    @TableField("natural_gas")
    private Double natural_gas;

    @TableField("coke_oven_gas")
    private Double cokeOven_gas;

    @TableField("other_gas")
    private Double other_gas;

    @TableField("desulfurizing_agent")
    private Double desulfurizing_agent;

    @TableField("electricity")
    private Double electricity;

}
