package sabillon.springframework5.recipe.app.data.services;

import java.util.Set;

import sabillon.springframework5.recipe.app.data.models.Recipe;

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

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the recipe
	 */
	Recipe findById(Long id);
}
