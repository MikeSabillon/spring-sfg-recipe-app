/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

/**
 * The Class NotesCommandToNotes.
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the notes
	 */
	@Synchronized
	@Nullable
	@Override
	public Notes convert(NotesCommand source) {
		if (source == null) {
			return null;
		}
		final Notes notes = new Notes();
		notes.setId(source.getId());
		notes.setRecipeNotes(source.getRecipeNotes());
		return notes;
	}

}
