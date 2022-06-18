package com.flipkart.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.*;
import com.flipkart.dao.*;
import com.flipkart.service.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserRestApi {
    @POST
    @Path("/registerStudent")

    public Response registerStudent(@QueryParam("userId") String userId,@QueryParam("userName") String userName,@QueryParam("emailId")String emailId,@QueryParam("password") String password,@QueryParam("contactNo")String contactNo) {
        try {
            StudentDaoImplementation studentDaoImplementation = new com.flipkart.dao.StudentDaoImplementation();
            if (studentDaoImplementation.addStudent(new Student(userId,userName,emailId,password,contactNo,1,"NA","Not Paid",false))){
                return Response.status(200).entity("Student Added Successfully !!").build();
            }
        }
        catch (Exception e) {
            return Response.status(201).entity("Some Exception Occured !! check logs").build();
        }
        return Response.status(200).entity("Not Added might already exists").build();
    }
}