package org.rest.resource;


import io.quarkus.security.Authenticated;
import org.rest.entity.dto.UserDto;
import org.rest.resource.utilis.ResourceError;
import org.rest.services.UserService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @GET
    @RolesAllowed("admin")
    public Response getUsers(){
        List<UserDto> userDtos = userService.getUsers();
        return Response.ok(userDtos).build();
    }

    @POST
    @RolesAllowed("admin")
    public Response createUser(UserDto user, @Context UriInfo uriInfo){
        UserDto userDto = userService.addUser(user);
        if(userDto != null){
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Integer.toString(userDto.getId()));
            return Response.created(uriBuilder.build()).entity(userDto).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity(new ResourceError("VD-0001", "Invalid request in validation. >>")).build();
    }

    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    public Response removeFruit(@PathParam("id") Integer id){
        String message = userService.removeUser(id);
        return Response.ok(message).build();
    }

}
