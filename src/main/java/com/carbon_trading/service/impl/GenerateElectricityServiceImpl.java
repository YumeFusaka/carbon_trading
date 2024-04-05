package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.common.context.ThreadInfo;
import com.carbon_trading.mapper.GenerateElectricityMapper;
import com.carbon_trading.pojo.DTO.GenerateElectricityDTO;
import com.carbon_trading.pojo.Entity.GenerateElectricity;
import com.carbon_trading.service.GenerateElectricityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class GenerateElectricityServiceImpl extends ServiceImpl<GenerateElectricityMapper, GenerateElectricity> implements GenerateElectricityService {

    @Autowired
    private GenerateElectricityMapper generateElectricityMapper;

    @Override
    public void submit(GenerateElectricityDTO generateElectricityDTO) {
        GenerateElectricity generateElectricity = new GenerateElectricity();
        BeanUtils.copyProperties(generateElectricityDTO, generateElectricity);
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        generateElectricity.setAccount(currentInfo.getAccount());
        generateElectricity.setCreate_date(LocalDateTime.now());
        generateElectricity.setStatus("待审核");
        generateElectricity.setConsumption(0.0);  // 调试参数,计算算法后续完成
        generateElectricityMapper.insert(generateElectricity);
    }
}
