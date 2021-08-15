package sabillon.springframework5.recipe.app.data.models;

import lombok.*;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * The Class Recipe.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"ingredients", "categories"})
public class Recipe {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Lob
    private String directions;

    /**
     * The ingredients.
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    @Builder.Default
    private Set<Ingredient> ingredients = new HashSet<>();

    /**
     * The image.
     */
    @Lob
    private Byte[] image;

    /**
     * The difficulty.
     */
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;

    /**
     * The notes.
     */
    @OneToOne(cascade = CascadeType.ALL)
    private Notes notes;

    /**
     * The categories.
     */
    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @Builder.Default
    private Set<Category> categories = new HashSet<>();

    /**
     * Sets the notes.
     *
     * @param notes the new notes
     */
    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

    /**
     * Adds the ingredient.
     *
     * @param ingredient the ingredient
     * @return the recipe
     */
    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
