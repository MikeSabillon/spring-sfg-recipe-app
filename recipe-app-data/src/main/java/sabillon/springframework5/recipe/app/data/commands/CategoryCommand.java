package sabillon.springframework5.recipe.app.data.commands;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class CategoryCommand {

    /**
     * The id.
     */
    private Long id;

    /**
     * The description.
     */
    private String description;

}
