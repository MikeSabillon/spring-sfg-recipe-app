package sabillon.springframework5.recipe.app.data.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class Ingredient.
 */
@Data
@EqualsAndHashCode(exclude = { "recipe" })
@NoArgsConstructor
@Entity
public class Ingredient {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The description. */
	private String description;

	/** The amount. */
	private BigDecimal amount;

	/** The uom. */
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;

	/** The recipe. */
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