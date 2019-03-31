package dea.liamsean;

import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Stateless
@Transactional
@Path("pets")
public class PetResource {

    PetDAO petDAO = new PetDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPets(){
        List<Pet> pets = petDAO.getAllPets();
        return Response.ok(pets).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPet(Pet pet){
        Pet createdPet = petDAO.createPet(pet);
        return Response.status(Response.Status.CREATED).entity(createdPet).build();
    }
}
