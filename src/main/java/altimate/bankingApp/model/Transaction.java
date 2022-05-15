package altimate.bankingApp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    private Integer transactionId;
    private String foreignAccount;
    private Integer amount;


    @ManyToOne
    @JoinColumn(name = "iban")
    private Account currentAccount;


    public Transaction() {
    }

    public Transaction(Integer idTransaction, String foreignAccount, Integer amount) {
        this.transactionId = idTransaction;
        this.foreignAccount = foreignAccount;
        this.amount = amount;

    }


}
