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
import java.util.Set;

@Stateless
@Transactional
@Path("/")
public class UserResource {

    UserDAO userDAO = new UserDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        List<User> users = userDAO.getAllUsers();
        return Response.ok(users.toString()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        User createdUser = userDAO.createUser(user);
        return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }

    @Path("{username}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUser(@PathParam("username") String username){
        userDAO.deleteUser(username);
        return Response.ok("Deleted user " + username).build();
    }

    @Path("{username}/food")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addFood(@PathParam("username") String username, Food food) {
        User user = userDAO.addFood(username, food);
        return Response.status(Response.Status.CREATED).entity(food.getFood() + " added to user " + username).build();
    }

    @Path("{username}/{food}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteFood(@PathParam("username") String username, @PathParam("food") String food){
        userDAO.removeFood(username, food);
        return Response.ok("Removed " + food + " from user " + username).build();
    }
}
