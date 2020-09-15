package com.lybxxx.blockchain.util;

import com.google.gson.GsonBuilder;
import com.lybxxx.blockchain.model.Block;

import java.util.ArrayList;

/**
 * @author lybxxx
 */
public class BlockChain {
    public  static ArrayList<Block> blocks = new ArrayList<>();
    public static int difficulty = 5;

    public static void main(String[] args){
        Block first = new Block("我是创世纪块","0");
        first.mineBlock(difficulty);


        Block second = new Block("我是老二",first.hash);
        second.mineBlock(difficulty);

        Block three = new Block("我是老三",second.hash);
        three.mineBlock(difficulty);

        blocks.add(first);
        blocks.add(second);
        blocks.add(three);
        System.out.println("\nBlocks is Valid:"+isChainValid());

        String Json = new GsonBuilder().setPrettyPrinting().create().toJson(blocks);
        System.out.println("The block:"+Json);


    }

    public static Boolean isChainValid(){
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




//00000a56f2e0d30932c4f02d98aea1f00e0cc04775cb15e3ccc717d16f7c6698

