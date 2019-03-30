package dea.liamsean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class UserResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getAllUsers(){
        return Response.ok("All users!").build();
    }
}
