package sabillon.springframework5.recipe.app.data.commands;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class IngredientCommand {

	/** The id. */
	private Long id;

	/** The description. */
	private String description;

	/** The amount. */
	private BigDecimal amount;

	/** The unit of measure. */
	private UnitOfMeasureCommand unitOfMeasure;

}
