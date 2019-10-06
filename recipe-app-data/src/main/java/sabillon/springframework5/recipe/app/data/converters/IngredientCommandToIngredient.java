package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;

/**
 * Instantiates a new ingredient command to ingredient.
 *
 * @param uomConverter the uom converter
 */
@RequiredArgsConstructor
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

	/** The uom converter. */
	private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the ingredient
	 */
	@Nullable
	@Override
	public Ingredient convert(IngredientCommand source) {
		if (source == null) {
			return null;
		}
		final Ingredient ingredient = new Ingredient();
		ingredient.setId(source.getId());
		ingredient.setAmount(source.getAmount());
		ingredient.setDescription(source.getDescription());
		ingredient.setUom(uomConverter.convert(source.getUnitOfMeasure()));
		return ingredient;
	}

}
