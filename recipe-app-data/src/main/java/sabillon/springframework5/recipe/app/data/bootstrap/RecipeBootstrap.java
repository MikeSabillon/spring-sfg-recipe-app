package sabillon.springframework5.recipe.app.data.bootstrap;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import sabillon.springframework5.recipe.app.data.enums.Difficulty;
import sabillon.springframework5.recipe.app.data.models.*;
import sabillon.springframework5.recipe.app.data.repositories.CategoryRepository;
import sabillon.springframework5.recipe.app.data.repositories.RecipeRepository;
import sabillon.springframework5.recipe.app.data.repositories.UnitOfMeasureRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private static final String EXPECTED_UOM_NOT_FOUND_MESSAGE = "Expected UOM Not Found";

    private static final String EXPECTED_CATEGORY_NOT_FOUND_MESSAGE = "Expected Category Not Found";

    private final CategoryRepository categoryRepository;

    private final RecipeRepository recipeRepository;

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Loading bootstrap data");
        recipeRepository.saveAll(getRecipes());
    }

    private List<Recipe> getRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        // get UOMs
        Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescription("Each");

        if (eachUomOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_UOM_NOT_FOUND_MESSAGE);
        }

        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescription("Tablespoon");

        if (tableSpoonUomOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_UOM_NOT_FOUND_MESSAGE);
        }

        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        if (teaSpoonUomOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_UOM_NOT_FOUND_MESSAGE);
        }

        Optional<UnitOfMeasure> dashUomOptional = unitOfMeasureRepository.findByDescription("Dash");

        if (dashUomOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_UOM_NOT_FOUND_MESSAGE);
        }

        Optional<UnitOfMeasure> pintUomOptional = unitOfMeasureRepository.findByDescription("Pint");

        if (pintUomOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_UOM_NOT_FOUND_MESSAGE);
        }

        Optional<UnitOfMeasure> cupsUomOptional = unitOfMeasureRepository.findByDescription("Cup");

        if (cupsUomOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_UOM_NOT_FOUND_MESSAGE);
        }

        // get optionals
        UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teapoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure dashUom = dashUomOptional.get();
        UnitOfMeasure pintUom = dashUomOptional.get();
        UnitOfMeasure cupsUom = cupsUomOptional.get();

        // get Categories
        Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");

        if (americanCategoryOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_CATEGORY_NOT_FOUND_MESSAGE);
        }

        Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");

        if (mexicanCategoryOptional.isEmpty()) {
            throw new RuntimeException(EXPECTED_CATEGORY_NOT_FOUND_MESSAGE);
        }

        Category americanCategory = americanCategoryOptional.get();
        Category mexicanCategory = mexicanCategoryOptional.get();

        // Yummy Guac
        Recipe guacRecipe = Recipe
                .builder()
                .description("Perfect Guacamole")
                .prepTime(10)
                .cookTime(0)
                .difficulty(Difficulty.EASY)
                .directions("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of"
                        + " the avocado with a blunt knife and scoop out the flesh with a spoon"
                        + "\n"
                        + "2 Mash with a fork: Using a fork, roughly mash the avocado."
                        + " (Don't overdo it! The guacamole should be a little chunky.)"
                        + "\n"
                        + "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice."
                        + " The acid in the lime juice will provide some balance to the richness of the avocado"
                        + " and will help delay the avocados from turning brown.\n"
                        + "Add the chopped onion, cilantro, black pepper, and chiles."
                        + " Chili peppers vary individually in their hotness."
                        + " So, start with a half of one chili pepper and add to the guacamole to your desired"
                        + " degree of hotness.\n"
                        + "Remember that much of this is done to taste because of the "
                        + "variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n"
                        + "4 Cover with plastic and chill to store: Place plastic wrap on the surface of"
                        + " the guacamole cover it and to prevent air reaching it."
                        + " (The oxygen in the air causes oxidation which will turn the guacamole brown.)"
                        + " Refrigerate until ready to serve.\n"
                        + "Chilling tomatoes hurts their flavor, so if you want to add"
                        + " chopped tomato to your guacamole, add it just before serving.\n"
                        + "\n" + "\n"
                        + "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvpiV9Sd")
                .notes(Notes.builder()
                        .recipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it"
                                + " in with your mashed avocados.\n"
                                + "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds "
                                + "and chunks of peaches in it (a Diana Kennedy favorite)."
                                + " Try guacamole with added pineapple,"
                                + " mango, or strawberries.\n"
                                + "The simplest version of guacamole is just mashed avocados with salt."
                                + " Don't let the lack of availability of other"
                                + " ingredients stop you from making guacamole.\n"
                                + "To extend a limited supply of avocados, add either sour cream or "
                                + "cottage cheese to your guacamole dip. Purists may be horrified, but so what?"
                                + " It tastes great.\n"
                                + "\n" + "\n"
                                + "Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz4jvoun5ws")
                        .build())
                .build();

        // very redundent - could add helper method, and make this simpler
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("ripe avocados")
                .amount(new BigDecimal(2))
                .uom(eachUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("Kosher salt")
                .amount(new BigDecimal(".5"))
                .uom(teapoonUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("fresh lime juice or lemon juice")
                .amount(new BigDecimal(2))
                .uom(tableSpoonUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("minced red onion or thinly sliced green onion")
                .amount(new BigDecimal(2))
                .uom(tableSpoonUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("serrano chiles, stems and seeds removed, minced")
                .amount(new BigDecimal(2))
                .uom(eachUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("Cilantro")
                .amount(new BigDecimal(2))
                .uom(tableSpoonUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("freshly grated black pepper")
                .amount(new BigDecimal(2))
                .uom(dashUom)
                .build());
        guacRecipe.addIngredient(Ingredient.builder()
                .recipe(guacRecipe)
                .description("ripe tomato, seeds and pulp removed, chopped")
                .amount(new BigDecimal(".5"))
                .uom(eachUom)
                .build());

        guacRecipe.getCategories().addAll(List.of(americanCategory, mexicanCategory));
        guacRecipe.setUrl("http://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setServings(4);
        guacRecipe.setSource("Simply Recipes");
        // Add guacamole recipe to list
        recipes.add(guacRecipe);

        // Yummy Tacos
        Recipe tacosRecipe = Recipe
                .builder()
                .description("Spicy Grilled Chicken Taco")
                .cookTime(9)
                .prepTime(20)
                .difficulty(Difficulty.MODERATE)
                .directions("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n"
                        + "2 Make the marinade and coat the chicken: In a large bowl,"
                        + " stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest."
                        + " Stir in the orange juice and olive oil to make a loose paste."
                        + " Add the chicken to the bowl and toss to coat all over.\n"
                        + "Set aside to marinate while the grill heats and you"
                        + " prepare the rest of the toppings.\n" + "\n"
                        + "\n"
                        + "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side,"
                        + " or until a thermometer inserted into the thickest part of the meat registers 165F."
                        + " Transfer to a plate and rest for 5 minutes.\n"
                        + "4 Warm the tortillas: Place each tortilla on the grill or on a hot,"
                        + " dry skillet over medium-high heat. As soon as you see pockets of the air start"
                        + " to puff up in the tortilla, turn it with tongs and heat"
                        + " for a few seconds on the other side.\n"
                        + "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n"
                        + "5 Assemble the tacos: Slice the chicken into strips. On each tortilla,"
                        + " place a small handful of arugula. Top with chicken slices, sliced avocado, radishes,"
                        + " tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n"
                        + "\n" + "\n"
                        + "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm")
                .notes(Notes.builder()
                        .recipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n"
                                + "Any and every kind of leftover can go inside a warm tortilla, "
                                + "usually with a healthy dose of pickled jalapenos."
                                + " I can always sniff out a late-night "
                                + "snacker when the aroma of tortillas heating in a"
                                + " hot pan on the stove comes wafting "
                                + "through the house.\n"
                                + "Today’s tacos are more purposeful – a deliberate meal instead"
                                + " of a secretive midnight snack!\n"
                                + "First, I marinate the chicken briefly in a spicy paste of"
                                + " ancho chile powder, oregano,"
                                + " cumin, and sweet orange juice while the grill is heating."
                                + " You can also use this time to prepare the taco toppings.\n"
                                + "Grill the chicken, then let it rest while you warm the tortillas."
                                + " Now you are ready to assemble the tacos and dig in."
                                + " The whole meal comes together in about 30 minutes!\n"
                                + "\n" + "\n"
                                + "Read more: http://www.simplyrecipes.com/recipes/"
                                + "spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ")
                        .build())
                .build();

        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Ancho Chili Powder")
                .amount(new BigDecimal(2))
                .uom(tableSpoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Dried Oregano")
                .amount(new BigDecimal(1))
                .uom(teapoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Dried Cumin")
                .amount(new BigDecimal(1))
                .uom(teapoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Sugar")
                .amount(new BigDecimal(1))
                .uom(teapoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Salt")
                .amount(new BigDecimal("0.5"))
                .uom(teapoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Clove of Garlic, Choppedr")
                .amount(new BigDecimal(1))
                .uom(eachUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("finely grated orange zestr")
                .amount(new BigDecimal(1))
                .uom(tableSpoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("fresh-squeezed orange juice")
                .amount(new BigDecimal(3))
                .uom(tableSpoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Olive Oil")
                .amount(new BigDecimal(2))
                .uom(tableSpoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("boneless chicken thighs")
                .amount(new BigDecimal(4))
                .uom(tableSpoonUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("small corn tortillas")
                .amount(new BigDecimal(8))
                .uom(eachUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("packed baby arugula")
                .amount(new BigDecimal(3))
                .uom(cupsUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("medium ripe avocados, slic")
                .amount(new BigDecimal(2))
                .uom(eachUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("radishes, thinly sliced")
                .amount(new BigDecimal(4))
                .uom(eachUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("cherry tomatoes, halved")
                .amount(new BigDecimal("0.5"))
                .uom(pintUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("red onion, thinly sliced")
                .amount(new BigDecimal("0.25"))
                .uom(eachUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("Roughly chopped cilantro")
                .amount(new BigDecimal(4))
                .uom(eachUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("cup sour cream thinned with 1/4 cup milk")
                .amount(new BigDecimal(4))
                .uom(cupsUom)
                .build());
        tacosRecipe.addIngredient(Ingredient.builder()
                .recipe(tacosRecipe)
                .description("lime, cut into wedges")
                .amount(new BigDecimal(4))
                .uom(eachUom)
                .build());

        tacosRecipe.getCategories().addAll(List.of(americanCategory, mexicanCategory));
        tacosRecipe.setUrl("http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setServings(4);
        tacosRecipe.setSource("Simply Recipes");

        recipes.add(tacosRecipe);
        return recipes;
    }

}