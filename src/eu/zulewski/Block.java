package eu.zulewski;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public long timestamp;
    int nonce;

    public Block(String previousHash, String data, int nonce) throws NoSuchAlgorithmException {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.nonce = nonce;
        this.hash = Hash.getHash(this);
    }

    public void mineBlock() throws NoSuchAlgorithmException {
        String target = new String(hash);
        nonce = 0;
        hash = "";

        while (!hash.equals(target)) {
            hash = Hash.getHash(this);
            nonce++;
        }

        System.out.println("Mined: " + hash + " Nonce: " + nonce);
    }
}
