pragma solidity ^0.4.25;

import "./Table.sol";

contract Carbon_trading {

    event addRecordResult(int256 count);
    event GetRecordResult(string account, string type_id, string consume, string map_id);

    uint256 public cnt = 0;

    constructor() public {
        createTable();
    }

    function uint2str(uint256 i) internal returns (string memory c) {
        if (i == 0) return "0";
        uint j = i;
        uint length;
        while (j != 0) {
            length++;
            j /= 10;
        }
        bytes memory bstr = new bytes(length);
        uint k = length - 1;
        while (i != 0) {
            bstr[k--] = byte(48 + i % 10);
            i /= 10;
        }
        c = string(bstr);
    }

    function createTable() private {
        TableFactory tf = TableFactory(0x1001);
        tf.createTable("carbon_trading", "id", "account,type_id,consume,map_id");
    }

    function openTable() private returns (Table) {
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("carbon_trading");
        return table;
    }

    function getRecord(string memory id) public returns (string memory, string memory, string memory, string memory) {
        Table table = openTable();
        Condition condition = table.newCondition();
        condition.EQ("id", id);
        Entries entries = table.select(id, condition);
        Entry entry = entries.get(0);

        string memory account = entry.getString("account");
        string memory type_id = entry.getString("type_id");
        string memory consume = entry.getString("consume");
        string memory map_id = entry.getString("map_id");

        emit GetRecordResult(account, type_id, consume, map_id);
        return (account, type_id, consume, map_id);
    }

    function addRecord(string memory account, string memory type_id, string memory consume, string memory map_id) public returns (int256, string memory){
        Table table = openTable();
        Entry entry = table.newEntry();
        ++cnt;
        string memory id = uint2str(cnt);
        entry.set("id", id);
        entry.set("account", account);
        entry.set("type_id", type_id);
        entry.set("consume", consume);
        entry.set("map_id", map_id);
        int256 count = table.insert(id, entry);
        emit addRecordResult(count);
        return (count, id);
    }

}