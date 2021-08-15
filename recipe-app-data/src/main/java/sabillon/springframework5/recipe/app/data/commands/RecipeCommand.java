/*
 *
 */
package sabillon.springframework5.recipe.app.data.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
public class RecipeCommand {

    /**
     * The id.
     */
    private Long id;

    /**
     * The description.
     */
    private String description;

    /**
     * The prep time.
     */
    private Integer prepTime;

    /**
     * The cook time.
     */
    private Integer cookTime;

    /**
     * The servings.
     */
    private Integer servings;

    /**
     * The source.
     */
    private String source;

    /**
     * The url.
     */
    private String url;

    /**
     * The directions.
     */
    private String directions;

    /**
     * The ingredients.
     */
    @Builder.Default
    private Set<IngredientCommand> ingredients = new HashSet<>();

    /**
     * The difficulty.
     */
    private Difficulty difficulty;

    /**
     * The notes.
     */
    private NotesCommand notes;

    /**
     * The categories.
     */
    @Builder.Default
    private Set<CategoryCommand> categories = new HashSet<>();

}
