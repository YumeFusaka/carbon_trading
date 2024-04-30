package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@TableName("enterprise")
@Data
public class Enterprise {

    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    @TableField("account")
    String account;

    @TableField("password")
    String password;

    @TableField("type")
    String type;

    @TableField("name")
    String name;

    @TableField("carbon_coin")
    Double carbon_coin;

    @TableField("trade_count")
    Integer trade_count;

    @TableField("submit_count")
    Integer submit_count;

    @TableField("create_time")
    LocalDateTime create_time;

}
