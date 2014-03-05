package com.training.freddy;

import com.training.freddy.Food.FoodGroup;

public class Enums {

    /**
     * @param args
     */
    public static void main(String[] args) {

        FoodPrinter printer = new FoodPrinter();

        Food[] fruits = Food.ofGroupAsArray(FoodGroup.FRUIT);
        System.out.println("----------Fruits-----------");
        printer.printFood(fruits);

        Food[] vegetables = Food.ofGroupAsArray(FoodGroup.VEGETABLE);
        System.out.println("---------Vegetables--------");
        printer.printFood(vegetables);

        Food[] meat = Food.ofGroupAsArray(FoodGroup.MEAT);
        System.out.println("-----------Meat------------");
        printer.printFood(meat);

        Food[] notFruits = Food.notOfGroupAsArray(FoodGroup.FRUIT);
        System.out.println("----------Not Fruits-----------");
        printer.printFood(notFruits);

        Food[] notVegetables = Food.notOfGroupAsArray(FoodGroup.VEGETABLE);
        System.out.println("----------Not Vegetables-----------");
        printer.printFood(notVegetables);

        Food[] notMeat = Food.notOfGroupAsArray(FoodGroup.MEAT);
        System.out.println("-------------Not Meat------------");
        printer.printFood(notMeat);

        System.out.println("Fin");

    }

}
