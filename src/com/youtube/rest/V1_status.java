package com.youtube.rest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;

import com.youtube.utility.MySqlConnection;
import com.youtube.utility.ToJSON;


@Path("/v1")
public class V1_status {

	@GET
	@Path("/status")
	@Produces(MediaType.TEXT_HTML)
	public String returnTitle(){
		return "<p>Aditya</p>";
	}
	
	@GET
	@Path("/database")
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabase(){
		Connection con = null;
		con = MySqlConnection.getDBConnection();		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2));			
		} catch (Exception e) {
		}
		return "<p>Database call</p>";
	}
	
	@GET
	@Path("/search")
	@Produces(MediaType.TEXT_HTML)
	public String returnSearchResults(){
		Connection con = null;
		con = MySqlConnection.getDBConnection();
		String resultString = null;
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employee");
			
			ToJSON converter =new ToJSON();
			JSONArray json =new JSONArray();
			
			json = converter.toJSONArray(rs);
			resultString = json.toString();	
			
		} catch (Exception e) {
		}
		return resultString;
	}
	
}
