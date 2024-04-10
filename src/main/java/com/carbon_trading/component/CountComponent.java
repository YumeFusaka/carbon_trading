package com.carbon_trading.component;

import com.carbon_trading.pojo.DTO.ElectricGridDTO;
import com.carbon_trading.pojo.DTO.GenerateElectricityDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CountComponent {

    public double generateGElectricityCount(GenerateElectricityDTO generateElectricityDTO) {
        double countAll = 0.0;

        // 燃烧化石燃料
        countAll += generateElectricityDTO.getCoal_burning() * 43000 * 1e-6 * 22 * 0.98 * 22 / 14;
        countAll += generateElectricityDTO.getCrude_oil() * 41816 * 1e-6 * 22.08 * 0.98 * 22 / 14;
        countAll += generateElectricityDTO.getFuel_oil() * 41816 * 1e-6 * 21.1 * 0.98 * 22 / 14;
        countAll += generateElectricityDTO.getGasoline() * 43070 * 1e-6 * 18.9 * 0.98 * 22 / 14;
        countAll += generateElectricityDTO.getRefinery_gas() * 45998 * 1e-6 * 18.2 * 0.98 * 22 / 14;
        countAll += generateElectricityDTO.getOther_products() * 42652 * 1e-6 * 20.2 * 0.98 * 22 / 14;
        countAll += generateElectricityDTO.getNatural_gas() * 38931 * 1e-6 * 15.32 * 0.99 * 22 / 14;
        countAll += generateElectricityDTO.getCoke_oven_gas() * 17981 * 1e-6 * 13.58 * 0.99 * 22 / 14;
        countAll += generateElectricityDTO.getOther_gas() * 52270 * 1e-6 * 12.2 * 0.99 * 22 / 14;

        // 脱硫过程排放
        countAll += generateElectricityDTO.getDesulfurizing_agent() * 0.440 * 0.9;

        return countAll;
    }

    public double electricGridCount(ElectricGridDTO electricGridDTO) {
        double countAll = 0.0;

        // 使用六氟化硫设备修理与退役过程产生的排放
        countAll += (electricGridDTO.getFix_capacity() + electricGridDTO.getRetirement_capacity()
                - electricGridDTO.getFix_recovery() - electricGridDTO.getRetirement_recovery()) * 1e-3 * 23900;

        // 输配电引起的二氧化碳排放
        countAll += (electricGridDTO.getPPGCP() + electricGridDTO.getIIE()
                - electricGridDTO.getIEE() - electricGridDTO.getElectricity_sales()) * 0.608 * 1000;
        return countAll;
    }
}
