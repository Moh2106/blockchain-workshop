package ma.enset.blockchain.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Timer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Block {
    private Integer index;
    private Instant timeStamp;
    private String previousHash;
    private String currentHash;
    private String data;

    public Block(Integer index, Instant timeStamp, String previousHash, String currentHash) {
        this.index = index;
        this.timeStamp = timeStamp;
        this.previousHash = previousHash;
        this.currentHash = currentHash;
    }

    public String calculateHash(){
        String toBeHashed = index + previousHash + timeStamp.getEpochSecond() + data;

        return HashUtils.HashUtil.calculateSHA256(toBeHashed);
    }

    public Block generateBlock(Integer index, Instant timeStamp ,String previousHash ,String currentHash){
        return new Block(index, timeStamp ,previousHash ,currentHash);
    }

    public boolean validateBlock(){
        String calculatedNewHash = calculateHash();

        return this.currentHash.equals(calculatedHash);

    }
}
