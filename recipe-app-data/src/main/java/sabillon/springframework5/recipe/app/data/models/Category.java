package sabillon.springframework5.recipe.app.data.models;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * The Class Category.
 */
@Data
@EqualsAndHashCode(exclude = {"recipes"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {

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
     * The recipes.
     */
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;

}