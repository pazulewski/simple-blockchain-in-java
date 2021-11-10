package eu.zulewski;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        Block firstBlock = new Block("0", "We did it!");
        Block secondBlock = new Block(firstBlock.hash, "My name is Paul");
    }
}
