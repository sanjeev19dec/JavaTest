package com.javatest.api;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


@Path("/mtokservice")
public class MToKService {
	private static final Logger LOGGER = Logger.getLogger(MToKService.class.getName()); 
	
	@Path("{c}")
	@GET
	@Produces("application/json")
	public Response convertMtoKfromInput(@PathParam("c") double miles) throws JSONException {
		
		long startTime = System.currentTimeMillis();
		LOGGER.info("Service mtok called....");
 
		JSONObject jsonObject = new JSONObject();
		double kilo;
		kilo = miles * 1.6;
		jsonObject.put("M Value", miles);
		jsonObject.put("K Value", kilo);
 
		String result = "@Produces(\"application/json\") Output: \n\nM to K Converter Output: \n\n" + jsonObject;
		long endTime = System.currentTimeMillis();
		LOGGER.info("It took " + (endTime - startTime) + " milliseconds");
		LOGGER.info("Service mtok returning...." +result);
		return Response.status(200).entity(result).build();
	}

}


