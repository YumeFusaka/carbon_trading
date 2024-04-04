package com.carbon_trading.common.context;

import lombok.Builder;
import lombok.Data;

@Data
public class ThreadInfo {
    String id;

    String identity;

    String type;
}
