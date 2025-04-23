package blockchain;

import java.util.Date;
public class Block {
    public String hash;
    public String previousHash;
    private String data; // A simple string
    private final long timeStamp; // As number of milliseconds since 1/1/1970

    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
    }

    public String calculateHash() {
        return Hasher.applySha256(
                previousHash + timeStamp + data
        );
    }
}
