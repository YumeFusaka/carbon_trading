package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("admin")
@Data
public class Admin {

    @TableId(value = "id", type = IdType.AUTO)
    Long id;

    @TableField("account")
    String account;

    @TableField("password")
    String password;

    @TableField("name")
    String name;
}
