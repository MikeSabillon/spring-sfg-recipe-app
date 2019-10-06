package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;
import sabillon.springframework5.recipe.app.data.models.Category;
import sabillon.springframework5.recipe.app.data.models.Ingredient;
import sabillon.springframework5.recipe.app.data.models.Notes;
import sabillon.springframework5.recipe.app.data.models.Recipe;

/**
 * The Class RecipeToRecipeCommandTest.
 */
public class RecipeToRecipeCommandTest {

	/** The Constant RECIPE_ID. */
	public static final Long RECIPE_ID = 1L;

	/** The Constant COOK_TIME. */
	public static final Integer COOK_TIME = Integer.valueOf("5");

	/** The Constant PREP_TIME. */
	public static final Integer PREP_TIME = Integer.valueOf("7");

	/** The Constant DESCRIPTION. */
	public static final String DESCRIPTION = "My Recipe";

	/** The Constant DIRECTIONS. */
	public static final String DIRECTIONS = "Directions";

	/** The Constant DIFFICULTY. */
	public static final Difficulty DIFFICULTY = Difficulty.EASY;

	/** The Constant SERVINGS. */
	public static final Integer SERVINGS = Integer.valueOf("3");

	/** The Constant SOURCE. */
	public static final String SOURCE = "Source";

	/** The Constant URL. */
	public static final String URL = "Some URL";

	/** The Constant CAT_ID_1. */
	public static final Long CAT_ID_1 = 1L;

	/** The Constant CAT_ID2. */
	public static final Long CAT_ID2 = 2L;

	/** The Constant INGRED_ID_1. */
	public static final Long INGRED_ID_1 = 3L;

	/** The Constant INGRED_ID_2. */
	public static final Long INGRED_ID_2 = 4L;

	/** The Constant NOTES_ID. */
	public static final Long NOTES_ID = 9L;

	/** The converter. */
	RecipeToRecipeCommand converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),
				new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
				new NotesToNotesCommand());
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
		assertNotNull(converter.convert(new Recipe()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(RECIPE_ID);
		recipe.setCookTime(COOK_TIME);
		recipe.setPrepTime(PREP_TIME);
		recipe.setDescription(DESCRIPTION);
		recipe.setDifficulty(DIFFICULTY);
		recipe.setDirections(DIRECTIONS);
		recipe.setServings(SERVINGS);
		recipe.setSource(SOURCE);
		recipe.setUrl(URL);

		Notes notes = new Notes();
		notes.setId(NOTES_ID);

		recipe.setNotes(notes);

		Category category = new Category();
		category.setId(CAT_ID_1);

		Category category2 = new Category();
		category2.setId(CAT_ID2);

		recipe.getCategories().add(category);
		recipe.getCategories().add(category2);

		Ingredient ingredient = new Ingredient();
		ingredient.setId(INGRED_ID_1);

		Ingredient ingredient2 = new Ingredient();
		ingredient2.setId(INGRED_ID_2);

		recipe.getIngredients().add(ingredient);
		recipe.getIngredients().add(ingredient2);

		RecipeCommand command = converter.convert(recipe);

		assertNotNull(command);
		assertEquals(RECIPE_ID, command.getId());
		assertEquals(COOK_TIME, command.getCookTime());
		assertEquals(PREP_TIME, command.getPrepTime());
		assertEquals(DESCRIPTION, command.getDescription());
		assertEquals(DIFFICULTY, command.getDifficulty());
		assertEquals(DIRECTIONS, command.getDirections());
		assertEquals(SERVINGS, command.getServings());
		assertEquals(SOURCE, command.getSource());
		assertEquals(URL, command.getUrl());
		assertEquals(NOTES_ID, command.getNotes().getId());
		assertEquals(2, command.getCategories().size());
		assertEquals(2, command.getIngredients().size());
	}

}
