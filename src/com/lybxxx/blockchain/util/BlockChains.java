package com.lybxxx.blockchain.util;

import com.google.gson.GsonBuilder;
import com.lybxxx.blockchain.model.Block;


import java.util.LinkedList;


/**
 * @author lybxxx
 * @date 6/16
 */
public class BlockChains {
    private static LinkedList<Block> blocks = new LinkedList<>();
    private static int difficulty = 5;
    public BlockChains(){

    }

    public void addBlockData(String data){
        Block newBlock = new Block();
        newBlock.initBlock(data);
        newBlock.previousHash = blocks.size()<=0?"0":blocks.getLast().hash;
        newBlock.hash = newBlock.calculateHash();
        newBlock.mineBlock(difficulty);
        blocks.add(newBlock);

    }

    public void printBlock(){
        String Json = new GsonBuilder().setPrettyPrinting().create().toJson(blocks);
        System.out.println("The block:"+Json);
    }

    public  Boolean isChainValid(){
        Block currentBlock;
        Block previousBlock;
        for(int i = 1;i < blocks.size();i++){
            currentBlock = blocks.get(i);
            previousBlock = blocks.get(i-1);
            if(!currentBlock.hash.equals(currentBlock.calculateHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }
            if(!previousBlock.hash.equals(currentBlock.previousHash)){
                System.out.println("Previous Hashes not equal");
                return false;
            }

        }
        return true;
    }
}
