/**
 * The $lock.
 */
package sabillon.springframework5.recipe.app.data.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

import java.util.Objects;

/**
 * The type Notes to notes command.
 */
@Component
public class NotesToNotesCommand implements Converter<Notes, NotesCommand> {

    @Synchronized
    @Override
    public NotesCommand convert(Notes source) {
        return !Objects.isNull(source) ? NotesCommand.builder()
                .id(source.getId())
                .recipeNotes(source.getRecipeNotes())
                .build() : null;
    }

}
