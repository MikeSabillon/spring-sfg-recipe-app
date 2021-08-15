package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

import static org.junit.Assert.*;

/**
 * The type Category to category command test.
 */
public class CategoryToCategoryCommandTest {

    private static final Long ID_VALUE = 1L;

    private static final String DESCRIPTION = "descript";

    private CategoryToCategoryCommand categoryToCategoryCommand;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        categoryToCategoryCommand = new CategoryToCategoryCommand();
    }

    /**
     * Test null object.
     */
    @Test
    public void testNullObject() {
        assertNull(categoryToCategoryCommand.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(categoryToCategoryCommand.convert(Category.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        CategoryCommand categoryCommand = categoryToCategoryCommand.convert(Category
                .builder()
                .id(ID_VALUE)
                .description(DESCRIPTION)
                .build());

        assertNotNull(categoryCommand);
        assertEquals(ID_VALUE, categoryCommand.getId());
        assertEquals(DESCRIPTION, categoryCommand.getDescription());
    }

}
