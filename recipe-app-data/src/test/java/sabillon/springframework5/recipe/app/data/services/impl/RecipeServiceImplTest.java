package sabillon.springframework5.recipe.app.data.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
	 * Test get recipes.
	 */
	@Test
	public void testGetRecipes() {
		Recipe recipe = new Recipe();
		HashSet<Recipe> dbRecipes = new HashSet<>();
		dbRecipes.add(recipe);

		when(this.recipeRepository.findAll()).thenReturn(dbRecipes);

		Set<Recipe> recipes = this.recipeService.getRecipes();
		assertEquals(1, recipes.size());
		verify(this.recipeRepository, times(1)).findAll();
	}

}
