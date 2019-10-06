package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;
import sabillon.springframework5.recipe.app.data.models.Recipe;

/**
 * The Class IngredientCommandToIngredientTest.
 */
public class IngredientCommandToIngredientTest {

	/** The Constant RECIPE. */
	public static final Recipe RECIPE = new Recipe();

	/** The Constant AMOUNT. */
	public static final BigDecimal AMOUNT = new BigDecimal("1");

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "Cheeseburger";

	/** The Constant ID_VALUE. */
	public static final Long ID_VALUE = 1L;

	/** The Constant UOM_ID. */
	public static final Long UOM_ID = 2L;

	/** The converter. */
	IngredientCommandToIngredient converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
	}

	/**
	 * Test null object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullObject() throws Exception {
		assertNull(converter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new IngredientCommand()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);
		UnitOfMeasureCommand unitOfMeasureCommand = new UnitOfMeasureCommand();
		unitOfMeasureCommand.setId(UOM_ID);
		command.setUnitOfMeasure(unitOfMeasureCommand);

		Ingredient ingredient = converter.convert(command);

		assertNotNull(ingredient);
		assertNotNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
		assertEquals(UOM_ID, ingredient.getUom().getId());
	}

	/**
	 * Convert with null UOM.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convertWithNullUOM() throws Exception {
		IngredientCommand command = new IngredientCommand();
		command.setId(ID_VALUE);
		command.setAmount(AMOUNT);
		command.setDescription(DESCRIPTION);

		Ingredient ingredient = converter.convert(command);

		assertNotNull(ingredient);
		assertNull(ingredient.getUom());
		assertEquals(ID_VALUE, ingredient.getId());
		assertEquals(AMOUNT, ingredient.getAmount());
		assertEquals(DESCRIPTION, ingredient.getDescription());
	}

}
