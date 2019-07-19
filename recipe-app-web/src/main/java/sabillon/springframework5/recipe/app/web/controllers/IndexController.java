package sabillon.springframework5.recipe.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The type Index controller.
 *
 * @author Miguel Sabillon on 12/13/2018
 */
@Controller
public class IndexController {

	/** The recipe service. */
	private final RecipeService recipeService;

	/**
	 * Instantiates a new index controller.
	 *
	 * @param recipeService the recipe service
	 */
	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	/**
	 * Gets the index page.
	 *
	 * @param model the model
	 * @return the index page
	 */
	@GetMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {

		model.addAttribute("recipes", recipeService.getRecipes());

		return "index";
	}

}
