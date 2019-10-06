package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

/**
 * The Class NotesCommandToNotesTest.
 */
public class NotesCommandToNotesTest {

	/** The Constant ID_VALUE. */
	public static final Long ID_VALUE = 1L;

	/** The Constant RECIPE_NOTES. */
	public static final String RECIPE_NOTES = "Notes";

	/** The converter. */
	NotesCommandToNotes converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new NotesCommandToNotes();
	}

	/**
	 * Test null parameter.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullParameter() throws Exception {
		assertNull(converter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new NotesCommand()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		NotesCommand notesCommand = new NotesCommand();
		notesCommand.setId(ID_VALUE);
		notesCommand.setRecipeNotes(RECIPE_NOTES);

		Notes notes = converter.convert(notesCommand);

		assertNotNull(notes);
		assertEquals(ID_VALUE, notes.getId());
		assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
	}

}
