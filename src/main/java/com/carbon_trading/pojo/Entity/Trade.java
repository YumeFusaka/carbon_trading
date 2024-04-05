package com.carbon_trading.pojo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@TableName("trade")
public class Trade {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("initiator_account")
    private String initiatorAccount;

    @TableField("receiver_account")
    private String receiverAccount;

    @TableField("content")
    private String content;

    @TableField("pay_coin")
    private Double payCoin;

    @TableField("status")
    private String status;

    @TableField("create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

}