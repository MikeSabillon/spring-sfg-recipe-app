package sabillon.springframework5.recipe.app.web.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The Class IndexControllerTest.
 */
@AutoConfigureMockMvc
public class IndexControllerTest {

	/** The index controller. */
	@InjectMocks
	private IndexController indexController;

	/** The recipe service. */
	@Mock
	private RecipeService recipeService;

	/** The model. */
	@Mock
	private Model model;

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
	 * Test mock MVC.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.indexController).build();
		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	/**
	 * Gets the index page.
	 *
	 * @return the index page
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getIndexPage() {
		Set<Recipe> recipes = new HashSet<>();
		Recipe recipe1 = new Recipe();
		recipe1.setId(1L);
		Recipe recipe2 = new Recipe();
		recipe1.setId(2L);

		recipes.add(recipe1);
		recipes.add(recipe2);

		when(this.recipeService.getRecipes()).thenReturn(recipes);

		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		String response = this.indexController.getIndexPage(this.model);
		assertEquals("index", response);
		verify(this.recipeService, times(1)).getRecipes();
		verify(this.model, times(1)).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
