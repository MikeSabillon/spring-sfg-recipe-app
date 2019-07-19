package sabillon.springframework5.recipe.app.data.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import sabillon.springframework5.recipe.app.data.domain.Recipe;
import sabillon.springframework5.recipe.app.data.repositories.RecipeRepository;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The Class RecipeServiceImpl.
 */
@Service
public class RecipeServiceImpl implements RecipeService {

	/** The recipe repository. */
	private final RecipeRepository recipeRepository;

	/**
	 * Instantiates a new recipe service impl.
	 *
	 * @param recipeRepository the recipe repository
	 */
	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	/**
	 * Gets the recipes.
	 *
	 * @return the recipes
	 */
	@Override
	public Set<Recipe> getRecipes() {
		Set<Recipe> recipeSet = new HashSet<>();
		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
		return recipeSet;
	}
}
