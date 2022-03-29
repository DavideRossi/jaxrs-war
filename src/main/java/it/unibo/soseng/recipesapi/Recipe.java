package it.unibo.soseng.recipesapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
//import org.jboss.logging.Logger;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/recipe")
public class Recipe {
	Logger LOG = Logger.getLogger(Recipe.class.toString());
	
	private static Map<Integer, RecipeModel> recipes = new HashMap<>(Map.of(
			1, new RecipeModel("Zuppa di sasso", List.of("acqua", "sasso")),
			2, new RecipeModel("Pane", List.of("acqua", "farina"))));
			
	private static int firstFreeId = 3;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Set<Integer> getRecipes() {
		LOG.info("Returning keyset");
		return recipes.keySet();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
// simple version with limited response control
//	public RecipeModel getRecipe(@PathParam("id") int id) {
//		LOG.info("Retrieving recipe "+id);
//		return recipes.get(id);
//	}
	public Response getRecipe(@PathParam("id") int id) {
		LOG.info("Retrieving recipe "+id);
		RecipeModel recipeModel = recipes.get(id);
		if(recipeModel == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok().entity(recipes.get(id)).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createRecipe(RecipeModel newRecipeModel) {
		recipes.put(firstFreeId++, newRecipeModel);
	}
}
