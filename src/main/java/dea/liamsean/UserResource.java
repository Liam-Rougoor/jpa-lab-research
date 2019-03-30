package dea.liamsean;

import javax.inject.Inject;
import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/")
public class UserResource {

    @PersistenceContext(unitName = "persistenceUnit")
    private EntityManager entityManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
        Query query = entityManager.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();
        return Response.ok(users).build();
    }
}
