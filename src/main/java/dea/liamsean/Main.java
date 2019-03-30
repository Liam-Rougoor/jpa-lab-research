package dea.liamsean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "persistenceUnit";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();
        System.out.println("Results: ");
        for(User user : users){
            System.out.println(user);
        }
        System.out.println("End of results");
    }
}
