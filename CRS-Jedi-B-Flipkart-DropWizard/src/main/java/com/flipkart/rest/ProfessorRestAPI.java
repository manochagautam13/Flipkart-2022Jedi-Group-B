package com.flipkart.rest;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@Path("/professor")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorRestAPI {
    @GET
    @Path("/getCourses")
    @Consumes("application/json")
    public Response viewCourses() throws SQLException {
        try {
            ProfessorService profServ = new ProfessorService();
            ArrayList<Course> courses = profServ.viewAllCourses();
            if (courses == null)
                return Response.status(201).entity("No Courses to Show").build();
            return Response.status(201).entity(courses).build();

        }catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
    }

    @PUT
    @Path("/registerCourses")
    @Consumes("application/json")
    public Response registerCourses(@Valid Professor professor) throws SQLException{
        try{
            ProfessorService profServ = new ProfessorService();
            profServ.registerCourses(professor);
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Unable to Register Courses!!!").build();
    }

    @PUT
    @Path("/assignGrades")
    @Consumes("application/json")
    public Response assignGrades(@Valid Professor professor){
        try{
            ProfessorService profServ = new ProfessorService();
            profServ.assignGrades(professor);
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(201).entity("Unable to Assign Grades!!!").build();
    }

    @GET
    @Path("/availableCourses")
    @Consumes("application/json")
    public Response viewEnrolledStudents(@Valid Professor professor) {
        try{
            ProfessorService profServ = new ProfessorService();
            Map<String,ArrayList<String>> courseWithStudents=profServ.viewEnrolledStudents(professor);
            if (courseWithStudents.size()==0) {
                return Response.status(201).entity("No Students To Show").build();
            }
            return Response.status(201).entity(courseWithStudents).build();
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }

    }
}
