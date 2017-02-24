package com.youtube.rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/v1/status")
public class V1_status {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Aditya</p>";
	}
	
	public String returnTitle1(){
		return "<p>Davale</p>";
	}
	
}
