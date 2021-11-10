package eu.zulewski;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
    public String hash;
    public String previousHash;
    public String data;
    public long timestamp;

    public Block(String previousHash, String data) throws NoSuchAlgorithmException {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = Hash.getHash(this);
    }
}
