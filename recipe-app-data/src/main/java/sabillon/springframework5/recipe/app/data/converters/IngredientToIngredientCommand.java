/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;

/**
 * Instantiates a new ingredient to ingredient command.
 *
 * @param uomConverter the uom converter
 */
@RequiredArgsConstructor
@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

	/** The uom converter. */
	private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

	/**
	 * Convert.
	 *
	 * @param ingredient the ingredient
	 * @return the ingredient command
	 */
	@Synchronized
	@Nullable
	@Override
	public IngredientCommand convert(Ingredient ingredient) {
		if (ingredient == null) {
			return null;
		}

		IngredientCommand ingredientCommand = new IngredientCommand();
		ingredientCommand.setId(ingredient.getId());
		ingredientCommand.setAmount(ingredient.getAmount());
		ingredientCommand.setDescription(ingredient.getDescription());
		ingredientCommand.setUnitOfMeasure(uomConverter.convert(ingredient.getUom()));
		return ingredientCommand;
	}

}
