package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

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

    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    LocalDateTime create_time;

}
