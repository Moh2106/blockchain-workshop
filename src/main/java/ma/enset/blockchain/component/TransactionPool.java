package ma.enset.blockchain.component;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TransactionPool {
//    A list to store the pending transactions in the pool.
    private List<Transaction> pendingTransactions = new ArrayList<>();

//    Add a new transaction to the transaction pool.
    public void addTransactions(Transaction transaction) {
        pendingTransactions.add(transaction);
    }

//    Retrieve all pending transactions from the pool.
    public List<Transaction> getPendingTransactions() {
        return pendingTransactions;
    }

//    Remove a confirmed transaction from the pool.
    public void removeTransaction(Transaction transaction){
        pendingTransactions.remove(transaction);
    }

}
