package com.bug.framework.authentication.impl;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.bug.framework.authentication.bean.User;

@Path("/users")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class UserResource {
	@Autowired
	private UserService userService;

	@Path("/")
	@GET
	public Response getUsersXML() {
		List<User> users = userService.getAll();
		GenericEntity<List<User>> ge = new GenericEntity<List<User>>(users) {
		};
		return Response.ok(ge).build();
	}

	@Path("/{id}")
	@GET
	public Response getUserXMLById(@PathParam("id") Integer id) {
		User user = userService.getById(id);
		return Response.ok(user).build();
	}

	@Path("/")
	@POST
	public Response saveUser(User user) {
		userService.save(user);
		return Response.ok("<status>success</status>").build();
	}

	@Path("/{id}")
	@DELETE
	public Response deleteUser(@PathParam("id") Integer id) {
		userService.delete(id);
		return Response.ok("<status>success</status>").build();
	}
}
