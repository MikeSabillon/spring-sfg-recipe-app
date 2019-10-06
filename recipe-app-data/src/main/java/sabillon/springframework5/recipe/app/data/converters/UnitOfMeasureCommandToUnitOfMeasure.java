/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Class UnitOfMeasureCommandToUnitOfMeasure.
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the unit of measure
	 */
	@Synchronized
	@Nullable
	@Override
	public UnitOfMeasure convert(UnitOfMeasureCommand source) {
		if (source == null) {
			return null;
		}
		final UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(source.getId());
		uom.setDescription(source.getDescription());
		return uom;
	}

}
