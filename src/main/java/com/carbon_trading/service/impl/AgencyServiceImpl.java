package com.carbon_trading.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.common.context.ThreadInfo;
import com.carbon_trading.mapper.AgencyMapper;
import com.carbon_trading.pojo.DTO.AgencyRegisterDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Agency;
import com.carbon_trading.pojo.Entity.Agency;
import com.carbon_trading.pojo.VO.AgencyVO;
import com.carbon_trading.pojo.VO.AgencyVO;
import com.carbon_trading.service.AgencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class AgencyServiceImpl extends ServiceImpl<AgencyMapper, Agency> implements AgencyService {

    @Autowired
    private AgencyMapper agencyMapper;

    @Override
    public void register(AgencyRegisterDTO agencyRegisterDTO) {
        Agency agency = agencyMapper.selectOne(new QueryWrapper<Agency>().eq("account", agencyRegisterDTO.getAccount())
                .eq("password", agencyRegisterDTO.getPassword()));
        if (agency != null) {
            throw new RuntimeException("该账号已被注册");
        }
        agency = new Agency();
        BeanUtils.copyProperties(agencyRegisterDTO, agency);
        agency.setCreate_time(LocalDateTime.now());
        agencyMapper.insert(agency);
    }

    @Override
    public Agency login(LoginDTO agencyLoginDTO) {
        Agency agency = agencyMapper.selectOne(new QueryWrapper<Agency>()
                .eq("account", agencyLoginDTO.getAccount())
                .eq("password", agencyLoginDTO.getPassword()));
        if (agency == null) {
            throw new RuntimeException("账号或者密码错误");
        }
        return agency;
    }

    @Override
    public AgencyVO getInfo() {
        ThreadInfo currentInfo = BaseContext.getCurrentInfo();
        BaseContext.removeCurrentInfo();
        Agency agency = agencyMapper.selectOne(new QueryWrapper<Agency>().eq("account", currentInfo.getAccount()));
        AgencyVO agencyVO = new AgencyVO();
        BeanUtils.copyProperties(agency, agencyVO);
        return agencyVO;
    }
}
