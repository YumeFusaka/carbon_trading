package com.carbon_trading.component;

import com.carbon_trading.pojo.Entity.Carbon_trading;
import lombok.extern.slf4j.Slf4j;
import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.fisco.bcos.sdk.transaction.model.exception.TransactionBaseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class SoildityComponent {

    public String configFile;

    public String abiFile;

    private String contractAddress = "0xe70de9329c8a42b844f23da1f65654ff3437f22b";

    private AssembleTransactionProcessor transactionProcessor;

    public SoildityComponent() throws Exception {
        configFile = "/root/carbon_trading/config-fisco.toml";
        abiFile = "/root/carbon_trading/abi/";

        // 初始化BcosSDK对象
        BcosSDK sdk = BcosSDK.build(configFile);
        // 获取Client对象，此处传入的群组ID为1
        Client client = sdk.getClient(Integer.valueOf(1));
        // 构造AssembleTransactionProcessor对象，需要传入client对象，CryptoKeyPair对象和abi、binary文件存放的路径。abi和binary文件需要在上一步复制到定义的文件夹中。
        CryptoKeyPair keyPair = client.getCryptoSuite().createKeyPair();

        transactionProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor
                (client, keyPair, abiFile, "");
    }

    public String addRecord(String account, String type_id, String consume, String id) throws ABICodecException, TransactionBaseException {
        List<Object> params = new ArrayList<>();
        params.add(account);
        params.add(type_id);
        params.add(consume);
        params.add(id);
        TransactionResponse transactionResponse =
                transactionProcessor.sendTransactionAndGetResponseByContractLoader("Carbon_trading", contractAddress, "addRecord", params);
        List<Object> valuesList = transactionResponse.getValuesList();
        log.info("区块链发起交易成功返回map_id为:{}", valuesList.get(1).toString());
        return valuesList.get(1).toString();
    }

    public Carbon_trading getRecord(String map_id) throws ABICodecException, TransactionBaseException {
        List<Object> params = new ArrayList<>();
        params.add(map_id);
        CallResponse callResponse =
                transactionProcessor.sendCallByContractLoader("Carbon_trading", contractAddress, "getRecord", params);
        List<Object> valuesList = callResponse.getReturnObject();
        log.info("返回交易信息为:{}", valuesList);
        Carbon_trading carbon_trading = Carbon_trading.builder()
                .account(valuesList.get(0).toString())
                .type_id(valuesList.get(1).toString())
                .consume(valuesList.get(2).toString())
                .map_id(valuesList.get(3).toString())
                .build();
        return carbon_trading;
    }


}
