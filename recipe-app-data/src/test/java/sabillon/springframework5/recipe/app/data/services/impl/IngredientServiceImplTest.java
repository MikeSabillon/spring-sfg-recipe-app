package sabillon.springframework5.recipe.app.data.services.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sabillon.springframework5.recipe.app.data.commands.IngredientCommand;
import sabillon.springframework5.recipe.app.data.converters.IngredientToIngredientCommand;
import sabillon.springframework5.recipe.app.data.models.Ingredient;
import sabillon.springframework5.recipe.app.data.models.Recipe;
import sabillon.springframework5.recipe.app.data.repositories.RecipeRepository;

import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class IngredientServiceImplTest {

    @Mock
    private IngredientToIngredientCommand ingredientToIngredientCommand;

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private IngredientServiceImpl ingredientService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByRecipeIdAndReceipeIdHappyPath() throws Exception {
        //given
        Recipe recipe = Recipe
                .builder()
                .id(1L)
                .ingredients(Set.of(Ingredient.builder().id(1L).build(), Ingredient.builder().id(2L).build(),
                        Ingredient.builder().id(3L).build()))
                .build();

        Optional<Recipe> recipeOptional = Optional.of(recipe);

        IngredientCommand returnedIngredientCommand = IngredientCommand.builder()
                .id(3L)
                .recipeId(recipe.getId())
                .build();

        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        when(ingredientToIngredientCommand.convert(any(Ingredient.class))).thenReturn(returnedIngredientCommand);

        //then
        IngredientCommand ingredientCommand = ingredientService.findByRecipeIdAndIngredientId(1L, 3L);

        //when
        assertEquals(Long.valueOf(3L), ingredientCommand.getId());
        assertEquals(Long.valueOf(1L), ingredientCommand.getRecipeId());
        verify(recipeRepository, times(1)).findById(anyLong());
    }

}
