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
public class KtoCService {
	private static final Logger LOGGER = Logger.getLogger(KtoCService.class.getName()); 
	
	@Path("{c}")
	@GET
	@Produces("application/json")
	public Response convertFtoCfromInput(@PathParam("c") float kel) throws JSONException {
		
		long startTime = System.currentTimeMillis();
		LOGGER.info("Service ktoc called....");
 
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius = kel - 273.15F;
		jsonObject.put("K Value", kel);
		jsonObject.put("C Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nK to C Converter Output: \n\n" + jsonObject;
		long endTime = System.currentTimeMillis();
		LOGGER.info("It took " + (endTime - startTime) + " milliseconds");
		LOGGER.info("Service ktoc returning...." +result);
		return Response.status(200).entity(result).build();
	}

}

