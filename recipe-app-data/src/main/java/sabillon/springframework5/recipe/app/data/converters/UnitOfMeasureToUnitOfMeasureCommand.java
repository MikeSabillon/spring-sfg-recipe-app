/**
 * The $lock.
 */
package sabillon.springframework5.recipe.app.data.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

import java.util.Objects;

/**
 * The type Unit of measure to unit of measure command.
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnitOfMeasureCommand> {

    @Synchronized
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        return !Objects.isNull(unitOfMeasure) ? UnitOfMeasureCommand.builder()
                .id(unitOfMeasure.getId())
                .description(unitOfMeasure.getDescription())
                .build() : null;
    }
}
