package dea.liamsean;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PetDAO {

    private EntityManager entityManager;

    public Pet createPet(Pet pet){
        entityManager = createNewEntityManager();
        entityManager.persist(pet);
        entityManager.flush();
        return pet;
    }

    public List<Pet> getAllPets(){
        entityManager = createNewEntityManager();
        Query query = entityManager.createQuery("SELECT p.name, p.owner from Pet p");
        return query.getResultList();
    }

    private EntityManager createNewEntityManager(){
        return Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
    }
}
