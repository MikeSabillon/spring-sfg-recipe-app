package sabillon.springframework5.recipe.app.data.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class Category.
 */
@Data
@EqualsAndHashCode(exclude = { "recipes" })
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

}