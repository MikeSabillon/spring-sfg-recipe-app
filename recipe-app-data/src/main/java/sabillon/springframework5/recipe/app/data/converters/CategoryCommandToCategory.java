/**
 * The $lock.
 */
package sabillon.springframework5.recipe.app.data.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sabillon.springframework5.recipe.app.data.commands.CategoryCommand;
import sabillon.springframework5.recipe.app.data.models.Category;

import java.util.Objects;

/**
 * The Class CategoryCommandToCategory.
 */
@Component
public class CategoryCommandToCategory implements Converter<CategoryCommand, Category> {

    @Synchronized
    @Override
    public Category convert(CategoryCommand source) {
        return !Objects.isNull(source) ? Category.builder()
                .id(source.getId())
                .description(source.getDescription())
                .build() : null;
    }
}
