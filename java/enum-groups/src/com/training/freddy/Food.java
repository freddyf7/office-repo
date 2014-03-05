package com.training.freddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public enum Food {

    CARROT(FoodGroup.VEGETABLE), BROCCOLI(FoodGroup.VEGETABLE), APPLE(FoodGroup.FRUIT), ORANGE(FoodGroup.FRUIT), FISH(FoodGroup.MEAT), CHICKEN(
        FoodGroup.MEAT);

    private final FoodGroup group;

    public enum FoodGroup {
        VEGETABLE, FRUIT, MEAT;
    }

    /**
     * Gets all the Food elements that don't belong to the specified FoodGroup parameter.
     * @param group
     * @return Set of Food
     */
    public static EnumSet<Food> notOfGroup(FoodGroup group) {
        EnumSet<Food> result = EnumSet.allOf(Food.class);
        for (Food food : Food.values()) {
            if (food.group == group) {
                result.remove(food);
            }
        }
        return result;
    }

    /**
     * Gets all the Food elements that belong to the specified FoodGroup parameter.
     * @param group
     * @return Set of Food
     */
    public static EnumSet<Food> ofGroup(FoodGroup group) {
        EnumSet<Food> result = EnumSet.noneOf(Food.class);
        for (Food food : Food.values()) {
            if (food.group == group) {
                result.add(food);
            }
        }
        return result;
    }

    /**
     * Gets all the Food elements that don't belong to the specified FoodGroup parameter.
     * @param group
     * @return Array of Food
     */
    public static Food[] notOfGroupAsArray(FoodGroup group) {
        List<Food> foodItems = new ArrayList<Food>(Arrays.asList(Food.values()));
        for (Food food : Food.values()) {
            if (food.group == group) {
                foodItems.remove(food);
            }
        }

        return foodItems.toArray(new Food[foodItems.size()]);
    }

    /**
     * Gets all the Food elements that belong to the specified FoodGroup parameter.
     * @param group
     * @return Array of Food
     */
    public static Food[] ofGroupAsArray(FoodGroup group) {
        List<Food> foodItems = new ArrayList<Food>();
        for (Food food : Food.values()) {
            if (food.group == group) {
                foodItems.add(food);
            }
        }

        return foodItems.toArray(new Food[foodItems.size()]);
    }

    /*-----------Constructors-----------*/

    Food(FoodGroup groupParam) {
        this.group = groupParam;
    }

    Food() {
        this(null);
    }

}
