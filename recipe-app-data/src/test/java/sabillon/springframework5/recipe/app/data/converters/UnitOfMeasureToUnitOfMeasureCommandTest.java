package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Class UnitOfMeasureToUnitOfMeasureCommandTest.
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "description";

	/** The Constant LONG_VALUE. */
	public static final Long LONG_VALUE = 1L;

	/** The converter. */
	UnitOfMeasureToUnitOfMeasureCommand converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new UnitOfMeasureToUnitOfMeasureCommand();
	}

	/**
	 * Test null object convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullObjectConvert() throws Exception {
		assertNull(converter.convert(null));
	}

	/**
	 * Test empty obj.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObj() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasure()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(LONG_VALUE);
		uom.setDescription(DESCRIPTION);

		UnitOfMeasureCommand uomc = converter.convert(uom);

		assertEquals(LONG_VALUE, uomc.getId());
		assertEquals(DESCRIPTION, uomc.getDescription());
	}

}
