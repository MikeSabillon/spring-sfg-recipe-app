package sabillon.springframework5.recipe.app.data.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.repositories.RecipeRepository;

/**
 * The Class RecipeServiceImplTest.
 */
public class RecipeServiceImplTest {

	/** The recipe service. */
	@InjectMocks
	private RecipeServiceImpl recipeService;

	/** The recipe repository. */
	@Mock
	private RecipeRepository recipeRepository;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	/**
	 * Gets the recipe by id test.
	 *
	 * @return the recipe by id test
	 * @throws Exception the exception
	 */
	@Test
	public void getRecipeByIdTest() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(Mockito.anyLong())).thenReturn(recipeOptional);

		Recipe recipeReturned = recipeService.findById(1L);

		assertNotNull("Null recipe returned", recipeReturned);
		verify(recipeRepository, times(1)).findById(Mockito.anyLong());
		verify(recipeRepository, never()).findAll();
	}

	/**
	 * Gets the recipes test.
	 *
	 * @return the recipes test
	 * @throws Exception the exception
	 */
	@Test
	public void getRecipesTest() throws Exception {
		Recipe recipe = new Recipe();
		HashSet<Recipe> receipesData = new HashSet<>();
		receipesData.add(recipe);

		when(recipeService.getRecipes()).thenReturn(receipesData);

		Set<Recipe> recipes = recipeService.getRecipes();

		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
		verify(recipeRepository, never()).findById(Mockito.anyLong());
	}

}
