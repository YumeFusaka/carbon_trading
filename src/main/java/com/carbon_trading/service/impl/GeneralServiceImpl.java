package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.mapper.ElectricGridMapper;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.mapper.EnterpriseTradeMapping;
import com.carbon_trading.mapper.GenerateElectricityMapper;
import com.carbon_trading.pojo.Entity.ElectricGrid;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.Entity.GenerateElectricity;
import com.carbon_trading.pojo.Entity.Trade;
import com.carbon_trading.pojo.VO.ElectricGridVO;
import com.carbon_trading.pojo.VO.EnterpriseVO;

import com.carbon_trading.pojo.VO.GenerateElectricityVO;
import com.carbon_trading.pojo.VO.TradeVO;
import com.carbon_trading.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GeneralServiceImpl implements GeneralService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Autowired
    private EnterpriseTradeMapping enterpriseTradeMapping;

    @Autowired
    private GenerateElectricityMapper generateElectricityMapper;

    @Autowired
    private ElectricGridMapper electricGridMapper;

    @Override
    public ArrayList<EnterpriseVO> getEnterprises() {
        BaseContext.removeCurrentInfo();
        List<Enterprise> enterprises = enterpriseMapper.selectList(new QueryWrapper<Enterprise>());
        ArrayList<EnterpriseVO> enterpriseVOS = new ArrayList<>();
        for(Enterprise enterprise : enterprises){
            EnterpriseVO enterpriseVO = new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            enterpriseVOS.add(enterpriseVO);
        }
        return enterpriseVOS;
    }

    @Override
    public ArrayList<TradeVO> getTrades() {
        BaseContext.removeCurrentInfo();
        List<Trade> trades = enterpriseTradeMapping.selectList(new QueryWrapper<Trade>());
        ArrayList<TradeVO> tradeVOS = new ArrayList<>();
        for(Trade trade : trades){
            TradeVO tradeVO = new TradeVO();
            BeanUtils.copyProperties(trade,tradeVO);
            tradeVOS.add(tradeVO);
        }
        return tradeVOS;
    }

    @Override
    public ArrayList<GenerateElectricityVO> generateElectricityList() {
        BaseContext.removeCurrentInfo();
        List<GenerateElectricity> generateElectricities = generateElectricityMapper.selectList(new QueryWrapper<GenerateElectricity>());
        ArrayList<GenerateElectricityVO> generateElectricityVOS = new ArrayList<>();
        for(GenerateElectricity generateElectricity : generateElectricities){
            GenerateElectricityVO generateElectricityVO = new GenerateElectricityVO();
            BeanUtils.copyProperties(generateElectricity,generateElectricityVO);
            generateElectricityVOS.add(generateElectricityVO);
        }
        return generateElectricityVOS;
    }

    @Override
    public ArrayList<ElectricGridVO> electricGridList() {
        List<ElectricGrid> electricGrids = electricGridMapper.selectList(new QueryWrapper<ElectricGrid>());
        ArrayList<ElectricGridVO> electricGridVOS = new ArrayList<>();
        for(ElectricGrid electricGrid : electricGrids){
            ElectricGridVO electricGridVO = new ElectricGridVO();
            BeanUtils.copyProperties(electricGrid,electricGridVO);
            electricGridVOS.add(electricGridVO);
        }
        return electricGridVOS;
    }
}
