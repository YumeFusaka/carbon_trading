package com.carbon_trading.common.context;

import lombok.Data;

@Data
public class ThreadInfo {
    String account;

    String identity;

    String type;

    String name;
}
