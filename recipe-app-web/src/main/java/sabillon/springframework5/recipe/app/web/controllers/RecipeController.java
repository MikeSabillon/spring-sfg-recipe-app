package sabillon.springframework5.recipe.app.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The Class RecipeController.
 */
@Controller
public class RecipeController {

    /**
     * The recipe service.
     */
    private final RecipeService recipeService;
    
    /**
     * Instantiates a new recipe controller.
     *
     * @param recipeService the recipe service
     */
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

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

}
