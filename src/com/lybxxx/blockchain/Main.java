package com.lybxxx.blockchain;

import com.lybxxx.blockchain.util.BlockChains;

/**
 * @author lybxxx
 * @date/17
 */
public class Main {

    public static void main(String[] args) {
        BlockChains block = new BlockChains();
        long startTime = System.currentTimeMillis();
        block.addBlockData("lyb");
        block.addBlockData("wyx");
        block.addBlockData("xxx");
        long endTime = System.currentTimeMillis();
        boolean check = block.isChainValid();
        System.out.println("区块链完整性："+check);

        System.out.println("创建区块链时间"+(endTime-startTime)/3000+"秒/块");

        block.printBlock();
    }
}
