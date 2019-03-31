package dea.liamsean;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@Entity
@XmlRootElement(name = "user")
public class User {

    @Id
    private String username;
    private String password;
    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Pet> pets;

    @ManyToMany(fetch = FetchType.EAGER, cascade = Casca)
    @JoinTable( name = "favourite_food",
                joinColumns = {@JoinColumn(name = "user")},
                inverseJoinColumns = {@JoinColumn(name = "food")}
    )
    private Set<Food> favouriteFoods;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public Set<Food> getFavouriteFoods() {
        return favouriteFoods;
    }

    public void setFavouriteFoods(Set<Food> favouriteFoods) {
        this.favouriteFoods = favouriteFoods;
    }

    public void addFood(Food food){
        favouriteFoods.add(food);
    }

    public void removeFood(Food food){
        favouriteFoods.remove(food);
    }

    public void removeFood(String foodName){
        for(Food food : favouriteFoods){
            if(foodName.equals(food.getFood())){
                favouriteFoods.remove(food);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", pets=" + pets +
                ", favouriteFoods=" + favouriteFoods +
                '}';
    }

    public String petsAsString(){
        String pets = "";
        for(Pet pet : this.pets){
            pets += '\'' + pet.getName() + '\'';
        }
        return pets;
    }
}
