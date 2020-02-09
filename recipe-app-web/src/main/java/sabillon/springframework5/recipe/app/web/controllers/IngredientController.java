package sabillon.springframework5.recipe.app.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The type Ingredient controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class IngredientController {

    /**
     * The Recipe service.
     */
    private final RecipeService recipeService;

    /**
     * List ingredients string.
     *
     * @param recipeId the recipe id
     * @param model    the model
     * @return the string
     */
    @GetMapping("recipe/{recipeId}/ingredients")
    public String listIngredients(@PathVariable String recipeId, Model model) {
        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(recipeId)));
        return "recipe/ingredient/list";
    }

}
