package sabillon.springframework5.recipe.app.data.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The type Ingredient command.
 */
@Getter
@Setter
@Builder
public class IngredientCommand {

    private Long id;

    private Long recipeId;

    private String description;

    private BigDecimal amount;

    private UnitOfMeasureCommand unitOfMeasure;

}
