package dea.liamsean;

import javax.persistence.*;

@Entity
public class Pet {

    @Id
    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", owner=" + owner.getName() +
                '}';
    }
}
