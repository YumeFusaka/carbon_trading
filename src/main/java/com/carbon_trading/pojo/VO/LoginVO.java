package com.carbon_trading.pojo.VO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginVO {
    String Authorization;

    String type;
}
