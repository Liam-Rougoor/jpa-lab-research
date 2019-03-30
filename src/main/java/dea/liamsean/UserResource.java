package dea.liamsean;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Transactional
@Path("/")
public class UserResource {

    UserDAO userDAO = new UserDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(){
        List<User> users = userDAO.getAllUsers();
        return Response.ok(users).build();
    }

    @GET
    @Path("POSTING")
    @Produces(MediaType.APPLICATION_JSON)
    public Response postRandomUser(){
        User user = new User();
        user.setUsername("tienepien");
        user.setPassword("tienePass");
        user.setName("Jantiene");
        EntityManager entityManager = Persistence.createEntityManagerFactory("persistenceUnit").createEntityManager();
        entityManager.joinTransaction();
        entityManager.persist(user);
        entityManager.flush();
        return Response.status(Response.Status.CREATED).entity(user).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user){
        User createdUser = userDAO.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }
}
