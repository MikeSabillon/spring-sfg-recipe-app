package sabillon.springframework5.recipe.app.data.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * The Class Ingredient.
 */
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
	 */
	public Ingredient() {
	}

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

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * Gets the recipe.
	 *
	 * @return the recipe
	 */
	public Recipe getRecipe() {
		return recipe;
	}

	/**
	 * Sets the recipe.
	 *
	 * @param recipe the new recipe
	 */
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	/**
	 * Gets the uom.
	 *
	 * @return the uom
	 */
	public UnitOfMeasure getUom() {
		return uom;
	}

	/**
	 * Sets the uom.
	 *
	 * @param uom the new uom
	 */
	public void setUom(UnitOfMeasure uom) {
		this.uom = uom;
	}
}