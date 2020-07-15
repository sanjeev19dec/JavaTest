package com.javatest.api;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


@Path("/ctokservice")
public class CToKService {
	private static final Logger LOGGER = Logger.getLogger(CToKService.class.getName()); 
	
	@Path("{c}")
	@GET
	@Produces("application/json")
	public Response convertCtoKfromInput(@PathParam("c") float cel) throws JSONException {
		
		long startTime = System.currentTimeMillis();
		LOGGER.info("Service ctok called....");
 
		JSONObject jsonObject = new JSONObject();
		float kelvin;
		kelvin = (float)(cel + 273.15); 
		jsonObject.put("C Value", cel);
		jsonObject.put("K Value", kelvin);
 
		String result = "@Produces(\"application/json\") Output: \n\nC to K Converter Output: \n\n" + jsonObject;
		long endTime = System.currentTimeMillis();
		LOGGER.info("It took " + (endTime - startTime) + " milliseconds");
		LOGGER.info("Service ctok returning...." +result);
		return Response.status(200).entity(result).build();
	}

}
