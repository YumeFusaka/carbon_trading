package com.carbon_trading.pojo.Entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Carbon_trading {
    String account;

    String type_id;

    String map_id;

    String consume;
}
