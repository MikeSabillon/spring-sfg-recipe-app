package sabillon.springframework5.recipe.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The type Index controller.
 *
 * @author Miguel Sabillon on 12/13/2018
 */
@RequiredArgsConstructor
@Slf4j
@Controller
public class IndexController {

	/** The recipe service. */
	private final RecipeService recipeService;

	/**
	 * Gets the index page.
	 *
	 * @param model the model
	 * @return the index page
	 */
	@GetMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		log.debug("Loading index page");
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}

}
