/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

/**
 * The Class CategoryToCategoryCommand.
 */
@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the category command
	 */
	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {
		if (source == null) {
			return null;
		}
		final CategoryCommand categoryCommand = new CategoryCommand();
		categoryCommand.setId(source.getId());
		categoryCommand.setDescription(source.getDescription());
		return categoryCommand;
	}

}
