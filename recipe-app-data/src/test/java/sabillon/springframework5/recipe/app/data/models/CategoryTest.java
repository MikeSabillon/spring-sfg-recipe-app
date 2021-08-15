package sabillon.springframework5.recipe.app.data.models;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * The type Category test.
 */
public class CategoryTest {

    private Category category;

    /**
     * Sets up.
     */
    @Before
    public void setUp() {
        this.category = Category.builder().build();
    }

    /**
     * Test get id.
     */
    @Test
    public void testGetId() {
        Long id = 1L;
        this.category.setId(id);
        assertEquals(id, this.category.getId());
    }

    /**
     * Test get description.
     */
    @Test
    public void testGetDescription() {
        String someDesc = "someDesc";
        this.category.setDescription(someDesc);
        assertEquals(someDesc, this.category.getDescription());
    }

    /**
     * Test get recipes.
     */
    @Test
    public void testGetRecipes() {
        this.category.setRecipes(new HashSet<>());
        assertNotNull(this.category.getRecipes());
    }

}
