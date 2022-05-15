package altimate.bankingApp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Table
@Entity(name = "accounts")
public class Account {
    @Id
    private String IBAN;
    private Integer balance;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private User user;

    @OneToMany(mappedBy = "currentAccount")
    List<Transaction> transactions;
}
