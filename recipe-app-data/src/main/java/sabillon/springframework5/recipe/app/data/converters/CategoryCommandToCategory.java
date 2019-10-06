/** The $lock. */
package sabillon.springframework5.recipe.app.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import lombok.Synchronized;
import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

/**
 * The Class CategoryCommandToCategory.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

	/**
	 * Convert.
	 *
	 * @param source the source
	 * @return the category
	 */
	@Synchronized
	@Nullable
	@Override
	public Category convert(CategoryCommand source) {
		if (source == null) {
			return null;
		}
		final Category category = new Category();
		category.setId(source.getId());
		category.setDescription(source.getDescription());
		return category;
	}

}
