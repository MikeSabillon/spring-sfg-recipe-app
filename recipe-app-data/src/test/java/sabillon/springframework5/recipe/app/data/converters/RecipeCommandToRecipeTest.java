package sabillon.springframework5.recipe.app.data.converters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;
import sabillon.springframework5.recipe.app.data.models.Recipe;

/**
 * The Class RecipeCommandToRecipeTest.
 */
public class RecipeCommandToRecipeTest {

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
	RecipeCommandToRecipe converter;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		converter = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
				new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
				new NotesCommandToNotes());
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
		assertNotNull(converter.convert(new RecipeCommand()));
	}

	/**
	 * Convert.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void convert() throws Exception {
		// given
		RecipeCommand recipeCommand = new RecipeCommand();
		recipeCommand.setId(RECIPE_ID);
		recipeCommand.setCookTime(COOK_TIME);
		recipeCommand.setPrepTime(PREP_TIME);
		recipeCommand.setDescription(DESCRIPTION);
		recipeCommand.setDifficulty(DIFFICULTY);
		recipeCommand.setDirections(DIRECTIONS);
		recipeCommand.setServings(SERVINGS);
		recipeCommand.setSource(SOURCE);
		recipeCommand.setUrl(URL);

		NotesCommand notes = new NotesCommand();
		notes.setId(NOTES_ID);

		recipeCommand.setNotes(notes);

		CategoryCommand category = new CategoryCommand();
		category.setId(CAT_ID_1);

		CategoryCommand category2 = new CategoryCommand();
		category2.setId(CAT_ID2);

		recipeCommand.getCategories().add(category);
		recipeCommand.getCategories().add(category2);

		IngredientCommand ingredient = new IngredientCommand();
		ingredient.setId(INGRED_ID_1);

		IngredientCommand ingredient2 = new IngredientCommand();
		ingredient2.setId(INGRED_ID_2);

		recipeCommand.getIngredients().add(ingredient);
		recipeCommand.getIngredients().add(ingredient2);

		Recipe recipe = converter.convert(recipeCommand);

		assertNotNull(recipe);
		assertEquals(RECIPE_ID, recipe.getId());
		assertEquals(COOK_TIME, recipe.getCookTime());
		assertEquals(PREP_TIME, recipe.getPrepTime());
		assertEquals(DESCRIPTION, recipe.getDescription());
		assertEquals(DIFFICULTY, recipe.getDifficulty());
		assertEquals(DIRECTIONS, recipe.getDirections());
		assertEquals(SERVINGS, recipe.getServings());
		assertEquals(SOURCE, recipe.getSource());
		assertEquals(URL, recipe.getUrl());
		assertEquals(NOTES_ID, recipe.getNotes().getId());
		assertEquals(2, recipe.getCategories().size());
		assertEquals(2, recipe.getIngredients().size());
	}

}
