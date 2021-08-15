package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

import static org.junit.Assert.*;

/**
 * The type Notes to notes command test.
 */
public class NotesToNotesCommandTest {

    private static final Long ID_VALUE = 1L;

    private static final String RECIPE_NOTES = "Notes";

    private NotesToNotesCommand notesToNotesCommand;

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        notesToNotesCommand = new NotesToNotesCommand();
    }

    /**
     * Convert.
     *
     * @throws Exception the exception
     */
    @Test
    public void convert() throws Exception {
        Notes notes = Notes
                .builder()
                .id(ID_VALUE)
                .recipeNotes(RECIPE_NOTES)
                .build();

        NotesCommand notesCommand = notesToNotesCommand.convert(notes);

        assertNotNull(notesCommand);
        assertEquals(ID_VALUE, notesCommand.getId());
        assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
    }

    /**
     * Test null.
     */
    @Test
    public void testNull() {
        assertNull(notesToNotesCommand.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(notesToNotesCommand.convert(Notes.builder().build()));
    }

}
