package ma.enset.blockchain.component;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class BlockChain {
    List<Block> blockChain = new ArrayList<>();

//    transactionPool`: An instance of the Transaction Pool class.
    private TransactionPool transactionPool;
    public void addBlock(Block block){
        blockChain.add(block);
    }

    public Block getBlockByIndex(int index){
        Block block = blockChain.get(index);
        return block;
    }

    public boolean validateChain(){
        for (int i=0;i<blockChain.size();i++){
            Block currentBlock = blockChain.get(i);
            Block previousBlock = blockChain.get(i-1);

            // Check if the current hash of the block is valid
            if (!currentBlock.getCurrentHash().equals(currentBlock.calculateHash())){
                return false;
            }

//            Check if the previous hash is equal to the hash of the previous block
            if (!previousBlock.getPreviousHash().equals(previousBlock.calculateHash())){
                return false;
            }
        }

        return true;
    }

    public Block getLatestBlock(){
        Block latestBlock = blockChain.get(blockChain.size() - 1);
        return latestBlock;
    }

    public void addTransaction(Transaction transaction){
        transactionPool.addTransactions(transaction);
    }

    public void mineBlock(Block block, int difficulty){

    }

    /**
     * 2. Create a new method, `mineBlock(Block block, int difficulty)`, in the
     * Blockchain class:
     * ○ Implement the mining algorithm that finds a nonce value resulting in a
     * block hash that meets the difficulty criteria.
     * ○ The mining algorithm typically involves repeatedly modifying the nonce,
     * calculating the hash, and checking if the hash meets the difficulty criteria.
     * ○ Adjust the difficulty level as necessary to maintain an appropriate mining
     * rate.
     * 3. Integrate the mining process into the block generation:
     * ○ When generating a new block, call the mineBlock method to find the
     * appropriate nonce value.
     * ○ Update the block's nonce and calculate the block hash.
     */


}
