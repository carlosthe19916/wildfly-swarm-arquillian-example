package org.wildfly.swarm.example.rest;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/hello")
public class HelloEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("method doGet invoked").build();
	}
}