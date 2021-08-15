package sabillon.springframework5.recipe.app.data.models;

import lombok.*;

import javax.persistence.*;

/**
 * The Class Notes.
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notes {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The recipe.
     */
    @OneToOne
    private Recipe recipe;

    /**
     * The recipe notes.
     */
    @Lob
    private String recipeNotes;

}
