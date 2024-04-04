package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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

}
