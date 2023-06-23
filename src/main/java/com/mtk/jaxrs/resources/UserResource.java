package com.mtk.jaxrs.resources;

import java.util.List;

import com.mtk.jaxrs.model.User;
import com.mtk.jaxrs.repositories.UserRepository;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("users")
public class UserResource {

	UserRepository userRepository = new UserRepository();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public User findById(@PathParam("id") Long id) {
		return userRepository.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		userRepository.save(user);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response update(@PathParam("id") Long id, User user) {
		user.setId(id);
		userRepository.update(user);
		return Response.status(Response.Status.OK).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id")	Long id) {
		userRepository.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}
