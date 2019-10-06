/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Class UnitOfMeasureToUnitOfMeasureCommand.
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

	/**
	 * Convert.
	 *
	 * @param unitOfMeasure the unit of measure
	 * @return the unit of measure command
	 */
	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
		if (unitOfMeasure != null) {
			final UnitOfMeasureCommand uomc = new UnitOfMeasureCommand();
			uomc.setId(unitOfMeasure.getId());
			uomc.setDescription(unitOfMeasure.getDescription());
			return uomc;
		}
		return null;
	}

}
