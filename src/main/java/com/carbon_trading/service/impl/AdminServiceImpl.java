package com.carbon_trading.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.carbon_trading.common.context.BaseContext;
import com.carbon_trading.component.SoildityComponent;
import com.carbon_trading.mapper.AdminMapper;
import com.carbon_trading.mapper.ElectricGridMapper;
import com.carbon_trading.mapper.EnterpriseMapper;
import com.carbon_trading.mapper.GenerateElectricityMapper;
import com.carbon_trading.pojo.DTO.AuditDTO;
import com.carbon_trading.pojo.DTO.LoginDTO;
import com.carbon_trading.pojo.Entity.Admin;
import com.carbon_trading.pojo.Entity.ElectricGrid;
import com.carbon_trading.pojo.Entity.Enterprise;
import com.carbon_trading.pojo.Entity.GenerateElectricity;
import com.carbon_trading.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.transaction.model.exception.TransactionBaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private GenerateElectricityMapper generateElectricityMapper;

    @Autowired
    private ElectricGridMapper electricGridMapper;

    @Autowired
    private SoildityComponent soildityComponent;

    @Autowired
    private EnterpriseMapper enterpriseMapper;

    @Override
    public Admin login(LoginDTO adminLoginDTO) {
        Admin admin = adminMapper.selectOne(new QueryWrapper<Admin>().eq("account", adminLoginDTO.getAccount())
                .eq("password", adminLoginDTO.getPassword()));
        if (admin == null) {
            throw new RuntimeException("账号或者密码错误");
        }
        return admin;
    }

    @Override
    public void auditGenerateElectric(AuditDTO auditDTO) {
        BaseContext.removeCurrentInfo();
        generateElectricityMapper.update(new UpdateWrapper<GenerateElectricity>().eq("id", auditDTO.getId()).set("status", auditDTO.getStatus() == 1 ? "已通过" : "未通过"));
        GenerateElectricity generateElectricity = generateElectricityMapper.selectOne(new QueryWrapper<GenerateElectricity>().eq("id", auditDTO.getId()));
        if (auditDTO.getStatus() == 1) {
            try {
                String map_id = soildityComponent.addRecord(generateElectricity.getAccount(), "1", generateElectricity.getConsumption().toString(), auditDTO.getId());
                generateElectricityMapper.update(new UpdateWrapper<GenerateElectricity>().eq("id", auditDTO.getId()).set("map_id", map_id));
                Enterprise enterprise = enterpriseMapper.selectOne(new QueryWrapper<Enterprise>().eq("account", generateElectricity.getAccount()));
                enterpriseMapper.update(new UpdateWrapper<Enterprise>()
                        .set("carbon_coin", enterprise.getCarbon_coin() - generateElectricity.getConsumption()).eq("account", generateElectricity.getAccount()));
            } catch (ABICodecException | TransactionBaseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void auditElectricGrid(AuditDTO auditDTO) {
        BaseContext.removeCurrentInfo();
        electricGridMapper.update(new UpdateWrapper<ElectricGrid>().eq("id", auditDTO.getId()).set("status", auditDTO.getStatus() == 1 ? "已通过" : "未通过"));
        ElectricGrid electricGrid = electricGridMapper.selectOne(new QueryWrapper<ElectricGrid>().eq("id", auditDTO.getId()));
        if (auditDTO.getStatus() == 1) {
            try {
                String map_id = soildityComponent.addRecord(electricGrid.getAccount(), "2", electricGrid.getConsumption().toString(), auditDTO.getId());
                electricGridMapper.update(new UpdateWrapper<ElectricGrid>().eq("id", auditDTO.getId()).set("map_id", map_id));
                Enterprise enterprise = enterpriseMapper.selectOne(new QueryWrapper<Enterprise>().eq("account", electricGrid.getAccount()));
                enterpriseMapper.update(new UpdateWrapper<Enterprise>()
                        .set("carbon_coin", enterprise.getCarbon_coin() - electricGrid.getConsumption()).eq("account", electricGrid.getAccount()));
            } catch (ABICodecException | TransactionBaseException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
