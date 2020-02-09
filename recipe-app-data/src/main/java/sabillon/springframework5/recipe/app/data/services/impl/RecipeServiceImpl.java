package sabillon.springframework5.recipe.app.data.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.converters.RecipeCommandToRecipe;
import sabillon.springframework5.recipe.app.data.converters.RecipeToRecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.repositories.RecipeRepository;
import sabillon.springframework5.recipe.app.data.services.RecipeService;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * The type Recipe service.
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    /**
     * The Recipe repository.
     */
    private final RecipeRepository recipeRepository;

    /**
     * The Recipe command to recipe.
     */
    private final RecipeCommandToRecipe recipeCommandToRecipe;

    /**
     * The Recipe to recipe command.
     */
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    /**
     * Gets the recipes.
     *
     * @return the recipes
     */
    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Getting recipes");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the recipe
     */
    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipe = this.recipeRepository.findById(id);
        return recipe.isPresent() ? recipe.get() : null;
    }

    /**
     * Save recipe command.
     *
     * @param command the command
     * @return the recipe commandk
     */
    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand command) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(command);
        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId:" + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }

    /**
     * Find command by id recipe command.
     *
     * @param l the l
     * @return the recipe command
     */
    @Override
    @Transactional
    public RecipeCommand findCommandById(Long l) {
        return recipeToRecipeCommand.convert(findById(l));
    }

    /**
     * Delete by id.
     *
     * @param id the id
     */
    @Override
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }
}
