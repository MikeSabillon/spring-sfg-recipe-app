package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;
import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

/**
 * The Class IngredientToIngredientCommandTest.
 */
public class IngredientToIngredientCommandTest {

	/** The Constant RECIPE. */
	public static final Recipe RECIPE = new Recipe();

	/** The Constant AMOUNT. */
	public static final BigDecimal AMOUNT = new BigDecimal("1");

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "Cheeseburger";

	/** The Constant UOM_ID. */
	public static final Long UOM_ID = 2L;

	/** The Constant ID_VALUE. */
	public static final Long ID_VALUE = 1L;

	/** The converter. */
	IngredientToIngredientCommand converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
	}

	/**
	 * Test null convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testNullConvert() throws Exception {
		assertNull(converter.convert(null));
	}

	/**
	 * Test empty object.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Ingredient()));
	}

	/**
	 * Test convert null UOM.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testConvertNullUOM() throws Exception {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);
		ingredient.setUom(null);

		IngredientCommand ingredientCommand = converter.convert(ingredient);

		assertNull(ingredientCommand.getUnitOfMeasure());
		assertEquals(ID_VALUE, ingredientCommand.getId());
		assertEquals(AMOUNT, ingredientCommand.getAmount());
		assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}

	/**
	 * Test convert with uom.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void testConvertWithUom() throws Exception {
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);

		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(UOM_ID);
		ingredient.setUom(uom);

		IngredientCommand ingredientCommand = converter.convert(ingredient);

		assertEquals(ID_VALUE, ingredientCommand.getId());
		assertNotNull(ingredientCommand.getUnitOfMeasure());
		assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId());
		assertEquals(AMOUNT, ingredientCommand.getAmount());
		assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}

}
