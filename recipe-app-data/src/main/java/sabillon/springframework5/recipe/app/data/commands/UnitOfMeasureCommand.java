package sabillon.springframework5.recipe.app.data.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UnitOfMeasureCommand {

    /**
     * The id.
     */
    private Long id;

    /**
     * The description.
     */
    private String description;

}
