package dea.liamsean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {

    @Id
    private String food;

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food='" + food + '\'' +
                '}';
    }
}
