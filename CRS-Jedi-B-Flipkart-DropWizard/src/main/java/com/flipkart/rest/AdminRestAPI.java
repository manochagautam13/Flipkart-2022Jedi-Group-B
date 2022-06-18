package com.flipkart.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
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

    public Response addCourse(@Valid Course course){
        try {
            AdminInterface admin1 = AdminOperation.getInstance();
            admin1.addCourse(course);
        } catch (Exception e){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Course Added Successfully !!").build();
    }

    @GET
    @Path("/viewCourse")
    public Response viewCourse(){
        try {
            AdminInterface admin2 = AdminOperation.getInstance();
            ArrayList<Course> course = admin2.viewCourses();

            if (course == null)
                return Response.status(201).entity("No Courses To Show").build();
            return Response.status(201).entity(course).build();
        }
        catch (Exception e){
            return Response.status(201).entity(e.getMessage()).build();
        }

    }

    @DELETE
    @Path("/dropCourse")

    public Response dropCourse(@NotNull @QueryParam("course") int cId){
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

    public Response approveStudents(@NotNull @QueryParam("student") String student){
        try {
            AdminInterface admin3 = AdminOperation.getInstance();
            System.out.println("here");
            admin3.approveStudents(student);
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Students were Approved Successfully !!").build();
    }

    @PUT
    @Path("/registerCourse")

    public Response registerCourse(@NotNull @QueryParam("student") String student,@NotNull @QueryParam("course") int course){
        try {
            AdminInterface admin4 = AdminOperation.getInstance();
            admin4.registerCourse(student, course);
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Students were Registered Successfully !!").build();
    }

    @GET
    @Path("/exit")

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
