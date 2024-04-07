package com.carbon_trading;

import com.baomidou.mybatisplus.annotation.TableField;
import com.carbon_trading.component.SoildityComponent;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.transaction.model.exception.TransactionBaseException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarbonTradingApplicationTests {

    @Autowired
    private SoildityComponent soildityComponent;

    @Test
    void addRecord() throws ABICodecException, TransactionBaseException {
        soildityComponent.addRecord("2022117316","1","50","0");
    }

    @Test
    void getRecord() throws ABICodecException, TransactionBaseException {
        soildityComponent.getRecord("1");
    }
}
