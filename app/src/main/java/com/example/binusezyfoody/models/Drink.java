package com.example.binusezyfoody.models;

public class Drink {

    private String drinkName;
    private int drinkPrice;
    private int drinkQuantity;

    public Drink(String drinkName, int drinkPrice, int drinkQuantity) {
        this.drinkName = drinkName;
        this.drinkPrice = drinkPrice;
        this.drinkQuantity = drinkQuantity;
    }

    public Drink() {
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public int getDrinkPrice() {
        return drinkPrice;
    }

    public void setDrinkPrice(int drinkPrice) {
        this.drinkPrice = drinkPrice;
    }

    public int getDrinkQuantity() {
        return drinkQuantity;
    }

    public void setDrinkQuantity(int drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }
}
