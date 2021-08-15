/**
 * The $lock.
 */
package sabillon.springframework5.recipe.app.data.converters;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Category;
import sabillon.springframework5.recipe.app.data.models.Recipe;

import java.util.Objects;

/**
 * The type Recipe to recipe command.
 */
@RequiredArgsConstructor
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

    private final CategoryToCategoryCommand categoryConverter;

    private final IngredientToIngredientCommand ingredientConverter;

    private final NotesToNotesCommand notesConverter;

    @Synchronized
    @Override
    public RecipeCommand convert(Recipe source) {
        if (!Objects.isNull(source)) {
            final RecipeCommand command = RecipeCommand.builder()
                    .id(source.getId())
                    .cookTime(source.getCookTime())
                    .prepTime(source.getPrepTime())
                    .description(source.getDescription())
                    .difficulty(source.getDifficulty())
                    .directions(source.getDirections())
                    .servings(source.getServings())
                    .source(source.getSource())
                    .url(source.getUrl())
                    .notes(notesConverter.convert(source.getNotes()))
                    .build();

            if (!Objects.isNull(source.getCategories()) && !source.getCategories().isEmpty()) {
                source.getCategories()
                        .forEach((Category category) -> command.getCategories().add(categoryConverter.convert(category)));
            }

            if (!Objects.isNull(source.getIngredients()) && !source.getIngredients().isEmpty()) {
                source.getIngredients()
                        .forEach(ingredient -> command.getIngredients().add(ingredientConverter.convert(ingredient)));
            }
            return command;
        }
        return null;
    }

}
