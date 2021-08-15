package sabillon.springframework5.recipe.app.data.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The Class Ingredient.
 */
@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString(exclude = {"recipe"})
public class Ingredient {

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
     * The amount.
     */
    private BigDecimal amount;

    /**
     * The uom.
     */
    @OneToOne(fetch = FetchType.EAGER)
    private UnitOfMeasure uom;

    /**
     * The recipe.
     */
    @ManyToOne
    private Recipe recipe;

    /**
     * Instantiates a new ingredient.
     *
     * @param description the description
     * @param amount      the amount
     * @param uom         the uom
     */
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    /**
     * Instantiates a new ingredient.
     *
     * @param description the description
     * @param amount      the amount
     * @param uom         the uom
     * @param recipe      the recipe
     */
    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }

}