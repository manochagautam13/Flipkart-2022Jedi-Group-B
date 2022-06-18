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

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestAPI {
	 StudentInterface studentInterface= new StudentOperations();
	 StudentDaoInterface studentDaoInterface= new StudentDaoImplementation();
	 

	 @GET
	 @Path("/viewCourses")
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response viewAvailableCourses() {
		 ArrayList<Course> availableCourses = null;
	        try {
	            availableCourses = studentDaoInterface.viewCourses();
	        }catch(SQLException se) {
	            se.printStackTrace();
	            return Response.status(201).entity("Some Exception Occured !! check logs").build();
	        }
	        return Response.ok(availableCourses).build();
	 }

	 @POST
	 @Path("/registerCourses")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response registerCourses(@QueryParam("student")@NotNull String student,@QueryParam("course")@NotNull int course) {
		 try {
		 studentInterface.registerCourses(student,course);
		 }
		 catch(Exception E)
		 {
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Successfully Registered for courses!!").build();
	 }
	 
	 @GET
	 @Path("/viewGradeCard")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response viewGradeCard(@QueryParam("student")@NotNull String student) {
		 try {
		 studentInterface.viewGradeCard(student);
		 }
		 catch(Exception E)
		 {
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("GradeCard Shown Successfully").build();
	 }
	 
	 @PUT
	 @Path("/payFees")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response payFees(@QueryParam("student")@NotNull String student, @QueryParam("semester")@NotNull int semester) {
		 try {
			 PaymentServiceInterface psi = new PaymentServiceImplementation();
			 psi.payFees(student, semester);
		 }
		 catch(Exception E)
		 {
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Fees Paid Successfully").build();
	 }
	 
	 @GET
	 @Path("/feeStatus")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response getFeeStatus(@QueryParam("student")@NotNull String student) {
		 try {
			 studentDaoInterface.getfeeStatus(student);
			 
		 }
		 catch(Exception E){
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Fees is already Paid Successfully").build();
	 }
	 
	 @GET
	 @Path("/getRegisteredCourseList")
	 @Consumes(MediaType.APPLICATION_JSON)
	 public Response getRegisteredCourseList(@QueryParam("student")@NotNull String student) {
		 try {
			 System.out.println("You are registered for following Courses: ");
			 studentInterface.registeredCourseList(student);
		 }
		 catch(Exception E){
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Registered Courses List Successfully Fetched").build();
	 }
	 
	 @Path("/exit")
	 @Consumes(MediaType.APPLICATION_JSON)
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
