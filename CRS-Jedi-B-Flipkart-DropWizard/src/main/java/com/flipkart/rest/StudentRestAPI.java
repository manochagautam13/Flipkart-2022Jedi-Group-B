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

@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestAPI {
	 StudentInterface studentInterface= new StudentOperations();
	 StudentDaoInterface studentDaoInterface= new StudentDaoImplementation();
	 double fee;
	 int invoiceId;
	 
	 @GET
	 @Path("/viewDetails")
	 @Consumes("application/json")
	 Public Response getStudent(@Valid Student student) throws SQLException {
         StudentDaoInterface sdi = new StudentDaoImplementation();
     if (student != null)
         return Response.ok(student).build();
     else
         return Response.status(Response.Status.NOT_FOUND).build();
 }
	 @GET
	 @Path("/viewCourses")
	 @Produces(MediaType.Application)
	 Public Response viewAvailableCourses() {
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
	 Public Response registerCourses(@Valid Student student) {
		 try {
		 studentInterface.registerCourses(student.getUserId());
		 }
		 catch(Exception E)
		 {
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Successfully Registered for courses!!").build();
	 }
	 
	 @GET
	 @Path("/viewGradeCard")
	 Public Response viewGradeCard(@Valid Student student) {
		 try {
		 studentInterface.registerCourses(student.getUserId());
		 }
		 catch(Exception E)
		 {
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("GradeCard Shown Successfully").build();
	 }
	 
	 @PUT
	 @Path("/payFees")
	 Public Response payFees(@Valid Student student) {
		 try {
			 PaymentServiceInterface psi = new PaymentServiceImplementation();
			 psi.payFees(student);
		 }
		 catch(Exception E)
		 {
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Fees Paid Successfully").build();
	 }
	 
	 @GET
	 @Path("/feeStatus")
	 Public Response getFeeStatus(@Valid Student student) {
		 try {
			 studentDaoInterface.getfeeStatus(student.getUserId());
			 
		 }
		 catch(Exception E){
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Fees is already Paid Successfully").build();
	 }
	 
	 @GET
	 @Path("/getRegisteredCourseList")
	 Public Response getRegisteredCourseList(@Valid Student student) {
		 try {
			 System.out.println("You are registered for following Courses: ");
			 studentInterface.registeredCourseList(student.getUserId());
		 }
		 catch(Exception E){
			 return Response.status(201).entity("Some Exception Occured !! check logs").build();
		 }
		 return Response.status(201).entity("Registered Courses List Successfully Fetched").build();
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
