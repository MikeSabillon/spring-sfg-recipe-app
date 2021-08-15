package sabillon.springframework5.recipe.app.data.converters;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;

import java.util.Objects;

/**
 * The type Ingredient command to ingredient.
 */
@RequiredArgsConstructor
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure uomConverter;

    @Synchronized
    @Override
    public Ingredient convert(IngredientCommand source) {
        return !Objects.isNull(source) ? Ingredient.builder()
                .id(source.getId())
                .amount(source.getAmount())
                .description(source.getDescription())
                .uom(uomConverter.convert(source.getUnitOfMeasure()))
                .build() : null;
    }
}
