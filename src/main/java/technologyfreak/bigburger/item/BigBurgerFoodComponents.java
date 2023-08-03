package technologyfreak.bigburger.item;

import net.minecraft.item.FoodComponent;

public class BigBurgerFoodComponents {
    public static final FoodComponent BURGER = new FoodComponent.Builder()
            .meat()
            .hunger(8) // each shank = 2
            .saturationModifier(1.625f) // is multiplier (saturation = hunger * modifier)
            .build();
}
