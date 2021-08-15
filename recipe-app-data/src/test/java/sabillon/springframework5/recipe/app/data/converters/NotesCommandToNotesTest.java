package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

import static org.junit.Assert.*;

/**
 * The type Notes command to notes test.
 */
public class NotesCommandToNotesTest {

    /**
     * The constant ID_VALUE.
     */
    public static final Long ID_VALUE = 1L;

    /**
     * The constant RECIPE_NOTES.
     */
    public static final String RECIPE_NOTES = "Notes";

    private NotesCommandToNotes notesCommandToNotes;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        notesCommandToNotes = new NotesCommandToNotes();
    }

    /**
     * Test null parameter.
     */
    @Test
    public void testNullParameter() {
        assertNull(notesCommandToNotes.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(notesCommandToNotes.convert(NotesCommand.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        NotesCommand notesCommand = NotesCommand
                .builder()
                .id(ID_VALUE)
                .recipeNotes(RECIPE_NOTES)
                .build();

        Notes notes = notesCommandToNotes.convert(notesCommand);

        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }

}
