package sabillon.springframework5.recipe.app.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * The Class Notes.
 */
@Entity
public class Notes {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The recipe. */
	@OneToOne
	private Recipe recipe;

	/** The recipe notes. */
	@Lob
	private String recipeNotes;

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
	 * Gets the recipe notes.
	 *
	 * @return the recipe notes
	 */
	public String getRecipeNotes() {
		return recipeNotes;
	}

	/**
	 * Sets the recipe notes.
	 *
	 * @param recipeNotes the new recipe notes
	 */
	public void setRecipeNotes(String recipeNotes) {
		this.recipeNotes = recipeNotes;
	}
}
