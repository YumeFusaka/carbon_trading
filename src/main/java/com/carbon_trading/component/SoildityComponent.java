package com.carbon_trading.component;

import org.fisco.bcos.sdk.BcosSDK;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.fisco.bcos.sdk.transaction.model.exception.TransactionBaseException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SoildityComponent {

    public static final String configFile = "src/main/resources/config-fisco.toml";

    private String contractAddress = "0x4c8456b637d4bfa74b8a45d0a60e106e7a466b54";

    private AssembleTransactionProcessor transactionProcessor;

    public SoildityComponent() throws Exception {
        // 初始化BcosSDK对象
        BcosSDK sdk = BcosSDK.build(configFile);
        // 获取Client对象，此处传入的群组ID为1
        Client client = sdk.getClient(Integer.valueOf(1));
        // 构造AssembleTransactionProcessor对象，需要传入client对象，CryptoKeyPair对象和abi、binary文件存放的路径。abi和binary文件需要在上一步复制到定义的文件夹中。
        CryptoKeyPair keyPair = client.getCryptoSuite().createKeyPair();

        transactionProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor
                (client, keyPair, "src/main/resources/abi/", "");

    }

    public void addRecord(String account,String type_id,String consume,String map_id) throws ABICodecException, TransactionBaseException {
        List<Object> params = new ArrayList<>();
        params.add(account);
        params.add(type_id);
        params.add(consume);
        params.add(map_id);
        TransactionResponse transactionResponse =
                transactionProcessor.sendTransactionAndGetResponseByContractLoader("Carbon_trading", contractAddress, "addRecord", params);
    }



}
