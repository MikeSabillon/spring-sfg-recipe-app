package sabillon.springframework5.recipe.app.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Class Notes.
 */
@Data
@EqualsAndHashCode(exclude = { "recipe" })
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

}
