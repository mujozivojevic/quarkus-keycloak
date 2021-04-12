package org.rest.resource;

import io.quarkus.security.Authenticated;
import io.quarkus.security.identity.SecurityIdentity;
import org.rest.entity.User;
import org.rest.resource.utilis.ResourceError;
import org.rest.services.FruitService;
import org.rest.entity.dto.FruitDto;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("/fruit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FruitResource {

    @Inject
    FruitService fruitService;



    @GET
    @RolesAllowed("user")
    public Response getFruits(){
        List<FruitDto> fruitDtos = fruitService.getFruits();
        return Response.ok(fruitDtos).build();
    }

    @POST
    @RolesAllowed("user")
    public Response createFruit(FruitDto fruit, @Context UriInfo uriInfo){
        FruitDto fruitDto = fruitService.addFruit(fruit);
        if(fruitDto != null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(fruitDto.getId()));
            return Response.created(uriBuilder.build()).entity(fruitDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new ResourceError("VD-0001", "Invalid request in validation. >>")).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("user")
    public Response removeFruit(@PathParam("id") Integer id){
        String message = fruitService.removeFruit(id);
        return Response.ok(message).build();
    }

}