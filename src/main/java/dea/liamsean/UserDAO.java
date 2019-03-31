package dea.liamsean;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserDAO {

    private EntityManager entityManager;

    public User createUser(User user){
        entityManager = createNewEntityManager();
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    public List<User> getAllUsers(){
        entityManager = createNewEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    private EntityManager createNewEntityManager(){
        return Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    }

    public User addFood(String username, Food food) {
        entityManager = createNewEntityManager();
        User foundUser = entityManager.find(User.class, username);
        foundUser.addFood(food);
        entityManager.merge(foundUser);
        entityManager.flush();
        return foundUser;
    }
}
