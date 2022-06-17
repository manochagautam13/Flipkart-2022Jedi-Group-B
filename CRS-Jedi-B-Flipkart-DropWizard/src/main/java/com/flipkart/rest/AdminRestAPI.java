package com.flipkart.rest;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.util.ArrayList;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)
public class AdminRestAPI {
    @POST
    @Path("/addProfessor")
    @Consumes("application/json")
    public Response addProfessor(@Valid Professor professor) {
        try {
            AdminInterface adminInterface = com.flipkart.service.AdminOperation.getInstance();
            adminInterface.addProfessor(professor);
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Professor Added Successfully !!").build();
    }

    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    public Response addCourse(@Valid Course course){
        try {
            AdminInterface admin1 = AdminOperation.getInstance();
            admin1.addCourse(course);
        } catch (Exception e){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Professor Added Successfully !!").build();
    }

    @GET
    @Path("/viewCourse")
    @Consumes("application/json")
    public Response viewCourse(){
        try {
            AdminInterface admin2 = AdminOperation.getInstance();
            ArrayList<Course> course = admin2.viewCourses();

            if (course == null)
                return Response.status(201).entity("No Courses To Show").build();
            return Response.status(201).entity(course).build();
        }
        catch (Exception e){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }

    }

    @DELETE
    @Path("/dropCourse")
    @Consumes("application/json")
    public Response dropCourse(@QueryParam("cId") int cId){
        try {
            AdminInterface admin2 = AdminOperation.getInstance();
            admin2.dropCourse(cId);
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Course Drop Successful !!").build();
    }

    @PUT
    @Path("/approvePendingStudents")
    @Consumes("/application/json")
    public Response approveStudents(){
        try {
            AdminInterface admin3 = AdminOperation.getInstance();
            admin3.approveStudents();
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Students were Approved Successfully !!").build();
    }

    @PUT
    @Path("/registerCourse")
    @Consumes("/application/json")
    public Response registerCourse(){
        try {
            AdminInterface admin4 = AdminOperation.getInstance();
            admin4.registerCourse();
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Students were Registered Successfully !!").build();
    }

    @Path("/exit")
    @Consumes("/application/json")
    public Response Exit(){
        try {
            System.out.println("Exit");
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Exit !!").build();
    }
}
