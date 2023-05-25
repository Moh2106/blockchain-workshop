package ma.enset.blockchain.component;

import lombok.Data;

@Data
public class Transaction {
//    A string representing the sender's address or identifier.
    private String sender;
//    A string representing the recipient's address or identifier.
    private String recipient;
//    A numeric value indicating the amount being transferred in the transaction.
    private Double amount;
//    A string containing the digital signature of the transaction to
//    ensure its authenticity.
    private String signature;

}
