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
 * The type Unit of measure command to unit of measure.
 */
@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand, UnitOfMeasure> {

    @Synchronized
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand source) {
        return !Objects.isNull(source) ? UnitOfMeasure.builder()
                .id(source.getId())
                .description(source.getDescription())
                .build() : null;
    }

}
