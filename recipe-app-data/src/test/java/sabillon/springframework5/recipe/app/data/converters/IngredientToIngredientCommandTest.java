package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;
import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * The type Ingredient to ingredient command test.
 */
public class IngredientToIngredientCommandTest {

    private static final BigDecimal AMOUNT = new BigDecimal("1");

    private static final String DESCRIPTION = "Cheeseburger";

    private static final Long UOM_ID = 2L;

    private static final Long ID_VALUE = 1L;

    private IngredientToIngredientCommand converter;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
    }

    /**
     * Test null convert.
     */
    @Test
    public void testNullConvert() {
        assertNull(converter.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNull(converter.convert(Ingredient.builder().build()));
    }

    /**
     * Test convert null uom.
     */
    @Test
    public void testConvertNullUOM() {
        Ingredient ingredient = Ingredient
                .builder()
                .id(ID_VALUE)
                .recipe(Recipe.builder().build())
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .uom(null)
                .build();

        IngredientCommand ingredientCommand = converter.convert(ingredient);

        assertNotNull(ingredientCommand);
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

        UnitOfMeasure uom = UnitOfMeasure
                .builder()
                .id(UOM_ID)
                .build();

        Ingredient ingredient = Ingredient
                .builder()
                .id(ID_VALUE)
                .recipe(Recipe.builder().build())
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .uom(uom)
                .build();

        IngredientCommand ingredientCommand = converter.convert(ingredient);

        assertNotNull(ingredientCommand);
        assertEquals(ID_VALUE, ingredientCommand.getId());
        assertNotNull(ingredientCommand.getUnitOfMeasure());
        assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId());
        assertEquals(AMOUNT, ingredientCommand.getAmount());
        assertEquals(DESCRIPTION, ingredientCommand.getDescription());
    }

}
