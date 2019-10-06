package sabillon.springframework5.recipe.app.data.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryCommand {

	/** The id. */
	private Long id;

	/** The description. */
	private String description;

}
