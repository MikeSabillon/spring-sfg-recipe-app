package sabillon.springframework5.recipe.app.data.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * The Class Category.
 */
@Entity
public class Category {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The description. */
	private String description;

	/** The recipes. */
	@ManyToMany(mappedBy = "categories")
	private Set<Recipe> recipes;

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
	 * Gets the recipes.
	 *
	 * @return the recipes
	 */
	public Set<Recipe> getRecipes() {
		return recipes;
	}

	/**
	 * Sets the recipes.
	 *
	 * @param recipes the new recipes
	 */
	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

}