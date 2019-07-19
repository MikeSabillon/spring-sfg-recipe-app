package sabillon.springframework5.recipe.app.data.services;

import java.util.Set;

import sabillon.springframework5.recipe.app.data.domain.Recipe;

/**
 * The Interface RecipeService.
 */
public interface RecipeService {

	/**
	 * Gets the recipes.
	 *
	 * @return the recipes
	 */
	Set<Recipe> getRecipes();
}
