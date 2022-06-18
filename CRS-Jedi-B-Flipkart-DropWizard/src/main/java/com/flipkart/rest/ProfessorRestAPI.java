package com.flipkart.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewCourses() throws SQLException {
        try {
            ProfessorService profServ = new ProfessorService();
            ArrayList<Course> courses = profServ.viewAllCourses();
            if (courses == null)
                return Response.status(200).entity("No Courses to Show").build();
            return Response.status(200).entity(courses).build();

        }catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
    }

    @PUT
    @Path("/registerCourses")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerCourses(@NotNull@QueryParam("professor") String professor,@NotNull@QueryParam("course") int course) throws SQLException{
        try{
            ProfessorService profServ = new ProfessorService();
            if (profServ.registerCourses(professor,course)){
                return Response.status(200).entity("Done!!!").build();
            }
            else{
                return Response.status(200).entity("Course Either Does not exist or already registered").build();
            }
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
    }

    @PUT
    @Path("/assignGrades")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response assignGrades(@NotNull @QueryParam("professor") String professor,
                                 @NotNull @QueryParam("course") int course,
                                 @NotNull @QueryParam("student") String student,
                                 @NotNull @QueryParam("grade") String grade


                                 ){
        try{
            ProfessorService profServ = new ProfessorService();
            if (profServ.assignGrades(professor,course,student,grade)){
                return Response.status(200).entity("Grade Assigned!!!").build();
            }
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(200).entity("Unable to Assign Grades!!!").build();
    }

    @GET
    @Path("/viewEnrolledStudents")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response viewEnrolledStudents(@NotNull@QueryParam("professor") String professor) {
        try{
            ProfessorService profServ = new ProfessorService();
            Map<String,ArrayList<String>> courseWithStudents=profServ.viewEnrolledStudents(professor);
            if (courseWithStudents.size()==0) {
                return Response.status(200).entity("No Students To Show").build();
            }
            return Response.status(200).entity(courseWithStudents).build();
        }
        catch(Exception E){
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }

    }
    
    
}
