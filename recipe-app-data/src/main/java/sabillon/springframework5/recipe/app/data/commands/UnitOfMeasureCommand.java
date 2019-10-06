package sabillon.springframework5.recipe.app.data.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UnitOfMeasureCommand {

	/** The id. */
	private Long id;

	/** The description. */
	private String description;

}
