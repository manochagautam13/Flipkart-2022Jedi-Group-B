package com.flipkart;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class ApplicationResources {

    @GET
    @Path("/ok")
    public String getMessage() {
        return "Ashutosh";
    }
}