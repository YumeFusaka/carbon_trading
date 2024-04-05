package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.common.context.ThreadInfo;
import com.carbon_trading.mapper.ElectricGridMapper;
import com.carbon_trading.pojo.DTO.ElectricGridDTO;
import com.carbon_trading.pojo.Entity.ElectricGrid;
import com.carbon_trading.pojo.Entity.ElectricGrid;
import com.carbon_trading.pojo.Entity.GenerateElectricity;
import com.carbon_trading.service.ElectricGridService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ElectricGridServiceImpl extends ServiceImpl<ElectricGridMapper, ElectricGrid> implements ElectricGridService {

    @Autowired
    private ElectricGridMapper electricGridMapper;

    @Override
    public void submit(ElectricGridDTO electricGridDTO) {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        ElectricGrid electricGrid = new ElectricGrid();
        BeanUtils.copyProperties(electricGridDTO, electricGrid);
        electricGrid.setAccount(currentInfo.getAccount());
        electricGrid.setCreate_date(LocalDateTime.now());
        electricGrid.setName(currentInfo.getName());
        electricGrid.setStatus("待审核");
        electricGrid.setConsumption(0.0);  // 调试参数,计算算法后续完成
        electricGridMapper.insert(electricGrid);
    }

    @Override
    public List<ElectricGrid> queryHistory() {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        QueryWrapper<ElectricGrid> wrapper = new QueryWrapper<>();
        wrapper.eq("account", currentInfo.getAccount());
        return electricGridMapper.selectList(wrapper);
    }
}
