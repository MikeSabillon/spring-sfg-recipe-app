/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

/**
 * The Class NotesToNotesCommand.
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the notes command
	 */
	@Synchronized
	@Nullable
	@Override
	public NotesCommand convert(Notes source) {
		if (source == null) {
			return null;
		}
		final NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(source.getId());
		notesCommand.setRecipeNotes(source.getRecipeNotes());
		return notesCommand;
	}

}
