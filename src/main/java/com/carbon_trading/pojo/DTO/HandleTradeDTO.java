package com.carbon_trading.pojo.DTO;

import lombok.Data;

@Data
public class HandleTradeDTO {
    String trade_id;

    Integer status;
    // 1: 接受交易, 2: 拒绝交易
}
