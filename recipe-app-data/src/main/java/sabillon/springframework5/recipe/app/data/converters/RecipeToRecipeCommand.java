/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Category;
import sabillon.springframework5.recipe.app.data.models.Recipe;

/**
 * The Class RecipeToRecipeCommand.
 */
@RequiredArgsConstructor
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

	/** The category conveter. */
	private final CategoryToCategoryCommand categoryConveter;

	/** The ingredient converter. */
	private final IngredientToIngredientCommand ingredientConverter;

	/** The notes converter. */
	private final NotesToNotesCommand notesConverter;

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the recipe command
	 */
	@Synchronized
	@Nullable
	@Override
	public RecipeCommand convert(Recipe source) {
		if (source == null) {
			return null;
		}

		final RecipeCommand command = new RecipeCommand();
		command.setId(source.getId());
		command.setCookTime(source.getCookTime());
		command.setPrepTime(source.getPrepTime());
		command.setDescription(source.getDescription());
		command.setDifficulty(source.getDifficulty());
		command.setDirections(source.getDirections());
		command.setServings(source.getServings());
		command.setSource(source.getSource());
		command.setUrl(source.getUrl());
		command.setNotes(notesConverter.convert(source.getNotes()));

		if (source.getCategories() != null && source.getCategories().size() > 0) {
			source.getCategories()
					.forEach((Category category) -> command.getCategories().add(categoryConveter.convert(category)));
		}

		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			source.getIngredients()
					.forEach(ingredient -> command.getIngredients().add(ingredientConverter.convert(ingredient)));
		}
		return command;
	}

}
