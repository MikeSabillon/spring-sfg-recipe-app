package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

import static org.junit.Assert.*;

/**
 * The type Unit of measure command to unit of measure test.
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

    private static final String DESCRIPTION = "description";

    private static final Long LONG_VALUE = 1L;

    private UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureCommandToUnitOfMeasure;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        unitOfMeasureCommandToUnitOfMeasure = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    /**
     * Test null parameter.
     */
    @Test
    public void testNullParameter() {
        assertNull(unitOfMeasureCommandToUnitOfMeasure.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(unitOfMeasureCommandToUnitOfMeasure.convert(UnitOfMeasureCommand.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        UnitOfMeasureCommand command = UnitOfMeasureCommand
                .builder()
                .id(LONG_VALUE)
                .description(DESCRIPTION)
                .build();

        UnitOfMeasure uom = unitOfMeasureCommandToUnitOfMeasure.convert(command);

        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }

}
