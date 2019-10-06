package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Class UnitOfMeasureCommandToUnitOfMeasureTest.
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "description";

	/** The Constant LONG_VALUE. */
	public static final Long LONG_VALUE = 1L;

	/** The converter. */
	UnitOfMeasureCommandToUnitOfMeasure converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureCommandToUnitOfMeasure();

	}

	/**
	 * Test null paramter.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullParamter() throws Exception {
		assertNull(converter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasureCommand()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		UnitOfMeasureCommand command = new UnitOfMeasureCommand();
		command.setId(LONG_VALUE);
		command.setDescription(DESCRIPTION);

		UnitOfMeasure uom = converter.convert(command);

		assertNotNull(uom);
		assertEquals(LONG_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());
	}

}
