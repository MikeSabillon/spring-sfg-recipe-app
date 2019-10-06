package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.models.Recipe;

/**
 * The Class RecipeCommandToRecipe.
 */
@RequiredArgsConstructor
@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {

	/** The category conveter. */
	private final CategoryCommandToCategory categoryConveter;

	/** The ingredient converter. */
	private final IngredientCommandToIngredient ingredientConverter;

	/** The notes converter. */
	private final NotesCommandToNotes notesConverter;

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the recipe
	 */
	@Synchronized
	@Nullable
	@Override
	public Recipe convert(RecipeCommand source) {
		if (source == null) {
			return null;
		}

		final Recipe recipe = new Recipe();
		recipe.setId(source.getId());
		recipe.setCookTime(source.getCookTime());
		recipe.setPrepTime(source.getPrepTime());
		recipe.setDescription(source.getDescription());
		recipe.setDifficulty(source.getDifficulty());
		recipe.setDirections(source.getDirections());
		recipe.setServings(source.getServings());
		recipe.setSource(source.getSource());
		recipe.setUrl(source.getUrl());
		recipe.setNotes(notesConverter.convert(source.getNotes()));

		if (source.getCategories() != null && source.getCategories().size() > 0) {
			source.getCategories().forEach(category -> recipe.getCategories().add(categoryConveter.convert(category)));
		}

		if (source.getIngredients() != null && source.getIngredients().size() > 0) {
			source.getIngredients()
					.forEach(ingredient -> recipe.getIngredients().add(ingredientConverter.convert(ingredient)));
		}
		return recipe;
	}

}
