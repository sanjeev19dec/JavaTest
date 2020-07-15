package com.javatest.api;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;


@Path("/ktomservice")
public class KtoMService {
	private static final Logger LOGGER = Logger.getLogger(KtoMService.class.getName()); 
	
	@Path("{kilo}")
	@GET
	@Produces("application/json")
	public Response convertKtoMfromInput(@PathParam("kilo") double kilo) throws JSONException {
		
		long startTime = System.currentTimeMillis();
		LOGGER.info("Service ktom called....");
 
		JSONObject jsonObject = new JSONObject();
		double miles;
		miles = kilo * 0.621;
		jsonObject.put("K Value", kilo);
		jsonObject.put("M Value", miles);
 
		String result = "@Produces(\"application/json\") Output: \n\nK to M Converter Output: \n\n" + jsonObject;
		long endTime = System.currentTimeMillis();
		LOGGER.info("It took " + (endTime - startTime) + " milliseconds");
		LOGGER.info("Service ktom returning...." +result);
		return Response.status(200).entity(result).build();
	}

}


