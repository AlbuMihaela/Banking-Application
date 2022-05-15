package altimate.bankingApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    private Long clientId;
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Account> accounts;

    public User() {
    }

}
