package sabillon.springframework5.recipe.app.web.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The Class RecipeControllerTest.
 */
public class RecipeControllerTest {

	/** The recipe service. */
	@Mock
	private RecipeService recipeService;

	/** The controller. */
	private RecipeController controller;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new RecipeController(recipeService);
	}

	/**
	 * Test get recipe.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testGetRecipe() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);

		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		when(recipeService.findById(Mockito.anyLong())).thenReturn(recipe);
		mockMvc.perform(get("/recipe/show/1")).andExpect(status().isOk()).andExpect(view().name("recipe/show"));
	}

}
