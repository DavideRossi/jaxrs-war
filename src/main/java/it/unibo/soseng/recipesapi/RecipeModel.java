package it.unibo.soseng.recipesapi;

import java.util.List;

public class RecipeModel {
	private String name;
	private List<String> ingredients;
	
	public RecipeModel(String name, List<String> ingredients) {
		super();
		this.name = name;
		this.ingredients = ingredients;
	}
	public RecipeModel() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getIngredients() {
		return ingredients;
	}
	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}
}
