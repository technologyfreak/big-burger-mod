package technologyfreak.bigburger.item;

import net.minecraft.item.FoodComponent;

public class BigBurgerFoodComponents {
    public static final FoodComponent BURGER = new FoodComponent.Builder()
            .meat()
            .hunger(12)
            .saturationModifier(18.8f)
            .build();
}
