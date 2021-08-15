package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.RecipeCommand;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;
import sabillon.springframework5.recipe.app.data.models.Category;
import sabillon.springframework5.recipe.app.data.models.Ingredient;
import sabillon.springframework5.recipe.app.data.models.Notes;
import sabillon.springframework5.recipe.app.data.models.Recipe;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * The type Recipe to recipe command test.
 */
public class RecipeToRecipeCommandTest {

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

    private RecipeToRecipeCommand recipeToRecipeCommand;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        recipeToRecipeCommand = new RecipeToRecipeCommand(new CategoryToCategoryCommand(),
                new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand()),
                new NotesToNotesCommand());
    }

    /**
     * Test null object.
     */
    @Test
    public void testNullObject() {
        assertNull(recipeToRecipeCommand.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(recipeToRecipeCommand.convert(Recipe.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        Recipe recipe = Recipe
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
                .notes(Notes.builder().id(NOTES_ID).build())
                .categories(Set.of(Category.builder().id(CAT_ID_1).build(),
                        Category.builder().id(CAT_ID_2).build()))
                .ingredients(Set.of(Ingredient.builder()
                                .id(INGRED_ID_1)
                                .recipe(Recipe.builder().id(RECIPE_ID).build())
                                .build(),
                        Ingredient.builder()
                                .id(INGRED_ID_2)
                                .recipe(Recipe.builder().id(RECIPE_ID).build())
                                .build()))
                .build();

        RecipeCommand command = recipeToRecipeCommand.convert(recipe);

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
