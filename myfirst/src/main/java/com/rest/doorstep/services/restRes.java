package com.rest.doorstep.services;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Path("v2")
public class restRes {
	
	private static final ExecutorService es = Executors.newFixedThreadPool(10);
	private static final Map<Long, Future<Void>> map = new HashMap<Long, Future<Void>>();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSample(@Context HttpHeaders headers) {
		ItemEntry ie = new ItemEntry();
		ie.NAME = null;
		ie.Num = "54";
		ObjectMapper om = new ObjectMapper();
		XmlMapper xm = new XmlMapper();

		Writer sw = new StringWriter();

		try {
			om.writeValue(sw, ie);
			// xm.writeValue(sw, ie);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (headers != null) {
			for (String header : headers.getRequestHeaders().keySet()) {
				System.out.println("Header:" + header + "Value:"
						+ headers.getRequestHeader(header));
			}
		}

		return Response.ok().entity(sw.toString()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response postSample(String incommingData) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			ItemEntry ie = mapper.readValue(incommingData, ItemEntry.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return Response.status(500).build();
		}
		return Response.ok().entity("Sample").build();
	}

	@GET
	@Path("new")
	public Response getSamp() {
		return Response.ok().entity("hello").build();
	}
	
	@GET
	@Path("/submit")
	public Response submitTask() {
	    long id = System.currentTimeMillis();
	    Future<Void> future = es.submit(new Callable<Void>() {
	        public Void call() throws Exception {
	            // long task
	            // you must throw exception for bad task
	            return null;
	        }
	    });
	    map.put(id, future);
	    return Response.ok(id, MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/status/{id}")
	public Response submitTask(@PathParam("id") long id) {
	    Future<Void> future = map.get(id);
	    System.out.println(future.getClass());
	    if (future.isDone()) {
	        try {
	            future.get();
	            return Response.ok("Successful!", MediaType.TEXT_PLAIN).build();
	        } catch (Exception e) {
	            // log
	            return Response.ok("Bad task!", MediaType.TEXT_PLAIN).build();
	        }
	    }
	    return Response.ok("Wait a few seconds.", MediaType.TEXT_PLAIN).build();

	}

}

class ItemEntry {
	public String NAME;
	public String Num;

}
