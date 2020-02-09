package sabillon.springframework5.recipe.app.data.services;

import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Recipe;

import java.util.Set;

/**
 * The interface Recipe service.
 */
public interface RecipeService {

    /**
     * Gets recipes.
     *
     * @return the recipes
     */
    Set<Recipe> getRecipes();

    /**
     * Find by id recipe.
     *
     * @param id the id
     * @return the recipe
     */
    Recipe findById(Long id);

    /**
     * Save recipe command recipe command.
     *
     * @param command the command
     * @return the recipe command
     */
    RecipeCommand saveRecipeCommand(RecipeCommand command);


    /**
     * Find command by id recipe command.
     *
     * @param id the id
     * @return the recipe command
     */
    RecipeCommand findCommandById(Long id);

    /**
     * Delete by id.
     *
     * @param id the id
     */
    void deleteById(Long id);

}
