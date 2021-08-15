package sabillon.springframework5.recipe.app.data.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The Class UnitOfMeasure.
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnitOfMeasure {

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

}