package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.VO.EnterpriseVO;
import com.carbon_trading.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class GeneralServiceImpl extends ServiceImpl<EnterpriseMapper, Enterprise> implements GeneralService {

    @Autowired
    private EnterpriseMapper enterpriseMapper;


    @Override
    public ArrayList<EnterpriseVO> getEnterprises() {
        List<Enterprise> enterprises = enterpriseMapper.selectList(new QueryWrapper<Enterprise>());
        ArrayList<EnterpriseVO> enterpriseVOS = new ArrayList<>();
        for(Enterprise enterprise : enterprises){
            EnterpriseVO enterpriseVO = new EnterpriseVO();
            BeanUtils.copyProperties(enterprise,enterpriseVO);
            enterpriseVOS.add(enterpriseVO);
        }
        return enterpriseVOS;
    }
}
