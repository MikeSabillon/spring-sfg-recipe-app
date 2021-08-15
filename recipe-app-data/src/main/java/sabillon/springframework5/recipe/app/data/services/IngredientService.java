package sabillon.springframework5.recipe.app.data.services;

import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;

/**
 * The interface Ingredient service.
 */
public interface IngredientService {

    /**
     * Find by recipe id and ingredient id ingredient command.
     *
     * @param recipeId     the recipe id
     * @param ingredientId the ingredient id
     * @return the ingredient command
     */
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

}
