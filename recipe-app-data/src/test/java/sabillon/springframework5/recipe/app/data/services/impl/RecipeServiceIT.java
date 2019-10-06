package sabillon.springframework5.recipe.app.data.services.impl;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.converters.RecipeCommandToRecipe;
import sabillon.springframework5.recipe.app.data.converters.RecipeToRecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.repositories.RecipeRepository;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The Class RecipeServiceIT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

	/** The Constant NEW_DESCRIPTION. */
	public static final String NEW_DESCRIPTION = "New Description";

	/** The recipe service. */
	@Autowired
	RecipeService recipeService;

	/** The recipe repository. */
	@Autowired
	RecipeRepository recipeRepository;

	/** The recipe command to recipe. */
	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;

	/** The recipe to recipe command. */
	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;

	/**
	 * Test save of description.
	 *
	 * @throws Exception the exception
	 */
	@Transactional
	@Test
	public void testSaveOfDescription() throws Exception {
		Iterable<Recipe> recipes = recipeRepository.findAll();
		Recipe testRecipe = recipes.iterator().next();
		RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

		testRecipeCommand.setDescription(NEW_DESCRIPTION);
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

		assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
		assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
		assertEquals(testRecipe.getCategories().size(), savedRecipeCommand.getCategories().size());
		assertEquals(testRecipe.getIngredients().size(), savedRecipeCommand.getIngredients().size());
	}

}
