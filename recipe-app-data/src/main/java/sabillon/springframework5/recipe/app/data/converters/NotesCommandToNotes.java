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
 * The type Notes command to notes.
 */
@Component
public class NotesCommandToNotes implements Converter<NotesCommand, Notes> {

    @Synchronized
    @Override
    public Notes convert(NotesCommand source) {
        return !Objects.isNull(source) ? Notes.builder()
                .id(source.getId())
                .recipeNotes(source.getRecipeNotes())
                .build() : null;
    }
}
