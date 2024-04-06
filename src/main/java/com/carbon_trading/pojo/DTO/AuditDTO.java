package com.carbon_trading.pojo.DTO;

import lombok.Data;

@Data
public class AuditDTO {
    String id;

    Integer status; // 1: 审核通过，2: 审核不通过
}
