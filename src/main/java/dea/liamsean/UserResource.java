package dea.liamsean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Transactional
@Path("/")
public class UserResource {

    UserDAO userDAO = new UserDAO();

    @Path("/testInsertingPetsAndUser")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        User user = new User();
        user.setUsername("petlover");
        user.setPassword("pass");
        user.setName("Karen");
        List<Pet> pets = new ArrayList<>();
        for(int i = 1; i<11;i++){
            Pet pet = new Pet();
            pet.setName("Pet " + i);
            pet.setOwner(user);
            pets.add(pet);
        }
        user.setPets(pets);
        EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
        entityManager.persist(user);
        entityManager.flush();
        return "Worked?";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        List<User> users = userDAO.getAllUsers();
        return Response.ok(users.toString()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user){
        User createdUser = userDAO.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }
}
