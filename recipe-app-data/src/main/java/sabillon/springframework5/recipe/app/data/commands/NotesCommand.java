package sabillon.springframework5.recipe.app.data.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {

	/** The id. */
	private Long id;

	/** The recipe notes. */
	private String recipeNotes;

}
