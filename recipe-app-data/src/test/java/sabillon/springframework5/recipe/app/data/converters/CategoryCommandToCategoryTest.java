package sabillon.springframework5.recipe.app.data.converters;

import org.junit.Before;
import org.junit.Test;
import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

import static org.junit.Assert.*;

/**
 * The type Category command to category test.
 */
public class CategoryCommandToCategoryTest {

    private static final Long ID_VALUE = 1L;

    private static final String DESCRIPTION = "description";

    private CategoryCommandToCategory categoryCommandToCategory;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        categoryCommandToCategory = new CategoryCommandToCategory();
    }

    /**
     * Test null object.
     */
    @Test
    public void testNullObject() {
        assertNull(categoryCommandToCategory.convert(null));
    }

    /**
     * Test empty object.
     */
    @Test
    public void testEmptyObject() {
        assertNotNull(categoryCommandToCategory.convert(CategoryCommand.builder().build()));
    }

    /**
     * Convert.
     */
    @Test
    public void convert() {
        Category category = categoryCommandToCategory.convert(CategoryCommand
                .builder()
                .id(ID_VALUE)
                .description(DESCRIPTION)
                .build());

        assertNotNull(category);
        assertEquals(ID_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }

}
