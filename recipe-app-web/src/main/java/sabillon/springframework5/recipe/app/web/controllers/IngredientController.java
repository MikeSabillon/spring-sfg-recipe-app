package sabillon.springframework5.recipe.app.web.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sabillon.springframework5.recipe.app.data.services.IngredientService;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

/**
 * The type Ingredient controller.
 */
@Slf4j
@Controller
@RequiredArgsConstructor
public class IngredientController {

    private final RecipeService recipeService;

    private final IngredientService ingredientService;

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

    /**
     * Show recipe ingredient string.
     *
     * @param recipeId the recipe id
     * @param id       the id
     * @param model    the model
     * @return the string
     */
    @GetMapping
    @RequestMapping("recipe/{recipeId}/ingredient/{id}/show")
    public String showRecipeIngredient(@PathVariable String recipeId,
                                       @PathVariable String id, Model model){
        model.addAttribute("ingredient", ingredientService.findByRecipeIdAndIngredientId(Long.valueOf(recipeId), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

}
