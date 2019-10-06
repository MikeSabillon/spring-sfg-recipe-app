package sabillon.springframework5.recipe.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The Class RecipeController.
 */
@RequiredArgsConstructor
@Controller
public class RecipeController {

	/**
	 * The recipe service.
	 */
	private final RecipeService recipeService;

	/**
	 * Show by id.
	 *
	 * @param id    the id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/recipe/show/{id}")
	public String showById(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
		return "recipe/show";
	}

	/**
	 * New recipe.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("recipe/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());
		return "recipe/recipeform";
	}

	/**
	 * Save or update.
	 *
	 * @param command the command
	 * @return the string
	 */
	@PostMapping("recipe")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);
		return "redirect:/recipe/show/" + savedCommand.getId();
	}

}
