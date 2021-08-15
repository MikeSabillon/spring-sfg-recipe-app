package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.commands.NotesCommand;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;
import sabillon.springframework5.recipe.app.data.models.Recipe;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * The type Recipe command to recipe test.
 */
public class RecipeCommandToRecipeTest {

    private static final Long RECIPE_ID = 1L;

    private static final Integer COOK_TIME = Integer.valueOf("5");

    private static final Integer PREP_TIME = Integer.valueOf("7");

    private static final String DESCRIPTION = "My Recipe";

    private static final String DIRECTIONS = "Directions";

    private static final Difficulty DIFFICULTY = Difficulty.EASY;

    private static final Integer SERVINGS = Integer.valueOf("3");

    private static final String SOURCE = "Source";

    private static final String URL = "Some URL";

    private static final Long CAT_ID_1 = 1L;

    private static final Long CAT_ID_2 = 2L;

    private static final Long INGRED_ID_1 = 3L;

    private static final Long INGRED_ID_2 = 4L;

    private static final Long NOTES_ID = 9L;

    private RecipeCommandToRecipe recipeCommandToRecipe;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        recipeCommandToRecipe = new RecipeCommandToRecipe(new CategoryCommandToCategory(),
                new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
                new NotesCommandToNotes());
    }

    /**
     * Test null object.
     */
    @Test
    public void testNullObject() {
        assertNull(recipeCommandToRecipe.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(recipeCommandToRecipe.convert(RecipeCommand.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        // given
        RecipeCommand recipeCommand = RecipeCommand
                .builder()
                .id(RECIPE_ID)
                .cookTime(COOK_TIME)
                .prepTime(PREP_TIME)
                .description(DESCRIPTION)
                .difficulty(DIFFICULTY)
                .directions(DIRECTIONS)
                .servings(SERVINGS)
                .source(SOURCE)
                .url(URL)
                .notes(NotesCommand.builder().id(NOTES_ID).build())
                .categories(Set.of(CategoryCommand.builder().id(CAT_ID_1).build(),
                        CategoryCommand.builder().id(CAT_ID_2).build()))
                .ingredients(Set.of(IngredientCommand.builder().id(INGRED_ID_1).build(),
                        IngredientCommand.builder().id(INGRED_ID_2).build()))
                .build();

        Recipe recipe = recipeCommandToRecipe.convert(recipeCommand);

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
