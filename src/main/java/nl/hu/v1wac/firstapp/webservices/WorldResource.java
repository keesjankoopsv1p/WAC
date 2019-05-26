package nl.hu.v1wac.firstapp.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;


@Path("countries")
public class WorldResource {
	private JsonObject convertToJson(Country country) {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("code", country.getCode());
		job.add("name", country.getName());
		job.add("capital", country.getCapital());
		job.add("surface", country.getSurface());
		job.add("government", country.getGovernment());
		job.add("lat", country.getLatitude());
		job.add("iso3", country.getIso3());
		job.add("continent", country.getContinent());
		job.add("region", country.getRegion());
		job.add("population", country.getPopulation());
		job.add("lng", country.getLongitude());
		return job.build();
	}
	
	@GET
	//@Produces("application/json")
	public String getCountries() {
		WorldService worldService = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (Country c : worldService.getAllCountries()) {
			JsonObject countryJson = convertToJson(c);
			jab.add(countryJson);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/{code}")
	//@Produces("application/json")
	public String getCountryCode(@PathParam("code") String code) {
		
		WorldService worldService = ServiceProvider.getWorldService();
		Country land = worldService.getCountryByCode(code);
		JsonArrayBuilder jab = Json.createArrayBuilder();
		JsonObject countryJson = convertToJson(land);
		jab.add(countryJson);
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/largestsurfaces")
	public String getLargestSurface() {
		
		WorldService worldService = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Country> grootsteOp = worldService.get10LargestSurfaces();
		for (Country i : grootsteOp) {
			JsonObject countryJson = convertToJson(i);
			jab.add(countryJson);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
	
	@GET
	@Path("/largestpopulations")
	public String getLargestPopulations() {

		WorldService worldService = ServiceProvider.getWorldService();
		JsonArrayBuilder jab = Json.createArrayBuilder();
		List<Country> grootsteOp = worldService.get10LargestPopulations();
		for (Country i : grootsteOp) {
			JsonObject countryJson = convertToJson(i);
			jab.add(countryJson);
		}
		JsonArray array = jab.build();
		return array.toString();
	}
}

