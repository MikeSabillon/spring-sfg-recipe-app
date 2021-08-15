package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.UnitOfMeasureCommand;
import sabillon.springframework5.recipe.app.data.models.UnitOfMeasure;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureCommandTest {

    private static final String DESCRIPTION = "description";

    private static final Long LONG_VALUE = 1L;

    private UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    @Before
    public void setUp() {
        unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testNullObjectConvert() {
        assertNull(unitOfMeasureToUnitOfMeasureCommand.convert(null));
    }

    @Test
    public void testEmptyObj() {
        assertNotNull(unitOfMeasureToUnitOfMeasureCommand.convert(UnitOfMeasure.builder().build()));
    }

    @Test
    public void convert() {
        UnitOfMeasure uom = UnitOfMeasure
                .builder()
                .id(LONG_VALUE)
                .description(DESCRIPTION)
                .build();

        UnitOfMeasureCommand uomc = unitOfMeasureToUnitOfMeasureCommand.convert(uom);

        assertNotNull(uomc);
        assertEquals(LONG_VALUE, uomc.getId());
        assertEquals(DESCRIPTION, uomc.getDescription());
    }

}
