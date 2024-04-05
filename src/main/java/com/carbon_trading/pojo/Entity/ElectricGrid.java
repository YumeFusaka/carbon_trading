package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@TableName("electric_grid")
@Data
public class ElectricGrid implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("account")
    private String account;

    @TableField("create_date")
    private LocalDateTime create_date;

    @TableField("status")
    private String status;

    @TableField("consumption")
    private Double consumption;

    @TableField("PPGCP")
    private Double PPGCP;

    @TableField("IIE")
    private Double IIE;

    @TableField("IEE")
    private Double IEE;

    @TableField("electricity_sales")
    private Double electricity_sales;

    @TableField("transmission_distribution")
    private Double transmission_distribution;

    @TableField("retirement_capacity")
    private Double retirement_capacity;

    @TableField("retirement_recovery")
    private Double retirement_recovery;

    @TableField("fix_capacity")
    private Double fix_capacity;

    @TableField("fix_recovery")
    private Double fix_recovery;

}
