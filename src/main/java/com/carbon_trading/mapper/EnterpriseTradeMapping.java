package com.carbon_trading.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.carbon_trading.pojo.Entity.Trade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EnterpriseTradeMapping extends BaseMapper<Trade> {
}
