/**
 * The $lock.
 */
package sabillon.springframework5.recipe.app.data.converters;

import lombok.RequiredArgsConstructor;
import lombok.Synchronized;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;

import java.util.Objects;

/**
 * The type Ingredient to ingredient command.
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {

    private final UnitOfMeasureToUnitOfMeasureCommand uomConverter;

    @Synchronized
    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (Objects.isNull(ingredient.getRecipe())) {
            log.info("Ingridient does not have recipe {}", ingredient);
        }
        return !Objects.isNull(ingredient) && !Objects.isNull(ingredient.getId()) ? IngredientCommand.builder()
                .id(ingredient.getId())
                .recipeId(ingredient.getRecipe().getId())
                .amount(ingredient.getAmount())
                .description(ingredient.getDescription())
                .unitOfMeasure(uomConverter.convert(ingredient.getUom()))
                .build() : null;
    }
}
