package eu.zulewski;

import java.util.Date;

public class Block {
    public String hash;
    public String previusHash;
    public String data;
    public long timestamp;

    public Block(String previusHash, String data) {
        this.previusHash = previusHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        //this.hash = hash;
    }
}
