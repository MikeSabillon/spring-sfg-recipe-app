package sabillon.springframework5.recipe.app.data.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * The Class Recipe.
 */
@Entity
public class Recipe {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/** The description. */
	private String description;

	/** The prep time. */
	private Integer prepTime;

	/** The cook time. */
	private Integer cookTime;

	/** The servings. */
	private Integer servings;

	/** The source. */
	private String source;

	/** The url. */
	private String url;

	/** The directions. */
	@Lob
	private String directions;

	/** The ingredients. */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();

	/** The image. */
	@Lob
	private Byte[] image;

	/** The difficulty. */
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	/** The notes. */
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;

	/** The categories. */
	@ManyToMany
	@JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

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
	 * Gets the prep time.
	 *
	 * @return the prep time
	 */
	public Integer getPrepTime() {
		return prepTime;
	}

	/**
	 * Sets the prep time.
	 *
	 * @param prepTime the new prep time
	 */
	public void setPrepTime(Integer prepTime) {
		this.prepTime = prepTime;
	}

	/**
	 * Gets the cook time.
	 *
	 * @return the cook time
	 */
	public Integer getCookTime() {
		return cookTime;
	}

	/**
	 * Sets the cook time.
	 *
	 * @param cookTime the new cook time
	 */
	public void setCookTime(Integer cookTime) {
		this.cookTime = cookTime;
	}

	/**
	 * Gets the servings.
	 *
	 * @return the servings
	 */
	public Integer getServings() {
		return servings;
	}

	/**
	 * Sets the servings.
	 *
	 * @param servings the new servings
	 */
	public void setServings(Integer servings) {
		this.servings = servings;
	}

	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Gets the directions.
	 *
	 * @return the directions
	 */
	public String getDirections() {
		return directions;
	}

	/**
	 * Sets the directions.
	 *
	 * @param directions the new directions
	 */
	public void setDirections(String directions) {
		this.directions = directions;
	}

	/**
	 * Gets the image.
	 *
	 * @return the image
	 */
	public Byte[] getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 *
	 * @param image the new image
	 */
	public void setImage(Byte[] image) {
		this.image = image;
	}

	/**
	 * Gets the notes.
	 *
	 * @return the notes
	 */
	public Notes getNotes() {
		return notes;
	}

	/**
	 * Sets the notes.
	 *
	 * @param notes the new notes
	 */
	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
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

	/**
	 * Gets the ingredients.
	 *
	 * @return the ingredients
	 */
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * Sets the ingredients.
	 *
	 * @param ingredients the new ingredients
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * Gets the difficulty.
	 *
	 * @return the difficulty
	 */
	public Difficulty getDifficulty() {
		return difficulty;
	}

	/**
	 * Sets the difficulty.
	 *
	 * @param difficulty the new difficulty
	 */
	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	/**
	 * Gets the categories.
	 *
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}

	/**
	 * Sets the categories.
	 *
	 * @param categories the new categories
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
}
