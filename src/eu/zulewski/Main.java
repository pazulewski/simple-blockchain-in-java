package eu.zulewski;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Block> blockchain = new ArrayList<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {
        blockchain.add(new Block("0", "We did it!", 40));
        blockchain.add(new Block(blockchain.get(blockchain.size() - 1).hash, "My name is Paul", 25));
        blockchain.add(new Block(blockchain.get(blockchain.size() - 1).hash, "Third Block", 180));

        for (Block block : blockchain) {
            block.mineBlock();
        }
    }

    private static boolean isChainValid() throws NoSuchAlgorithmException {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            if (!currentBlock.hash.equals(Hash.getHash(currentBlock))) {
                System.out.println("Current hash is different");
                return false;
            }

            if (!previousBlock.hash.equals(currentBlock.previousHash)) {
                System.out.println("Previous hash is different");
                return false;
            }
        }
        return true;
    }
}
