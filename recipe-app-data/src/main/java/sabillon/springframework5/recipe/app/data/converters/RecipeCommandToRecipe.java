package sabillon.springframework5.recipe.app.data.converters;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Recipe;

import java.util.Objects;

/**
 * The type Recipe command to recipe.
 */
@RequiredArgsConstructor
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

    private final CategoryCommandToCategory categoryConveter;

    private final IngredientCommandToIngredient ingredientConverter;

    private final NotesCommandToNotes notesConverter;

    @Synchronized
    @Override
    public Recipe convert(RecipeCommand source) {
        if (!Objects.isNull(source)) {
            final Recipe recipe = Recipe.builder()
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
                source.getCategories().forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
            }

            if (!Objects.isNull(source.getIngredients()) && !source.getIngredients().isEmpty()) {
                source.getIngredients()
                        .forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
            }
            return recipe;
        }
        return null;
    }

}
