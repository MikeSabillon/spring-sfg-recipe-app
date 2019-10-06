package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.models.Notes;

/**
 * The Class NotesToNotesCommandTest.
 */
public class NotesToNotesCommandTest {

	/** The Constant ID_VALUE. */
	public static final Long ID_VALUE = 1L;

	/** The Constant RECIPE_NOTES. */
	public static final String RECIPE_NOTES = "Notes";

	/** The converter. */
	NotesToNotesCommand converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new NotesToNotesCommand();
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		Notes notes = new Notes();
		notes.setId(ID_VALUE);
		notes.setRecipeNotes(RECIPE_NOTES);

		NotesCommand notesCommand = converter.convert(notes);

		assertEquals(ID_VALUE, notesCommand.getId());
		assertEquals(RECIPE_NOTES, notesCommand.getRecipeNotes());
	}

	/**
	 * Test null.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNull() throws Exception {
		assertNull(converter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Notes()));
	}

}
