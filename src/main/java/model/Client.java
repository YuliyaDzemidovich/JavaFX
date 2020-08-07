package model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorValue("client")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "type")
public class Client {
    @Id
    @GeneratedValue
    private long id;

    public Client(){

    }

    public Client(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
