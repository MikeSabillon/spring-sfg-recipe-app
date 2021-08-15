package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * The type Ingredient command to ingredient test.
 */
public class IngredientCommandToIngredientTest {

    private static final BigDecimal AMOUNT = new BigDecimal("1");

    private static final String DESCRIPTION = "Cheeseburger";

    private static final Long ID_VALUE = 1L;

    private static final Long UOM_ID = 2L;

    private IngredientCommandToIngredient converter;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        converter = new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    }

    /**
     * Test null object.
     */
    @Test
    public void testNullObject() {
        assertNull(converter.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(IngredientCommand.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        UnitOfMeasureCommand unitOfMeasureCommand = UnitOfMeasureCommand
                .builder()
                .id(UOM_ID)
                .build();

        IngredientCommand command = IngredientCommand
                .builder()
                .id(ID_VALUE)
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .unitOfMeasure(unitOfMeasureCommand)
                .build();

        Ingredient ingredient = converter.convert(command);

        assertNotNull(ingredient);
        assertNotNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(UOM_ID, ingredient.getUom().getId());
    }

    /**
     * Convert with null uom.
     *
     * @throws Exception the exception
     */
    @Test
    public void convertWithNullUOM() throws Exception {
        IngredientCommand command = IngredientCommand
                .builder()
                .id(ID_VALUE)
                .amount(AMOUNT)
                .description(DESCRIPTION)
                .build();

        Ingredient ingredient = converter.convert(command);

        assertNotNull(ingredient);
        assertNull(ingredient.getUom());
        assertEquals(ID_VALUE, ingredient.getId());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertEquals(DESCRIPTION, ingredient.getDescription());
    }

}
