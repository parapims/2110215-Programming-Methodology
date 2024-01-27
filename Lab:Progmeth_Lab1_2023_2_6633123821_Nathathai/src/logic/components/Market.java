package logic.components;

import java.util.ArrayList;

public class Market {
    private String name;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;

    //----------Method----------
    public Market(String name){
        setName(name);
        setFoods(new ArrayList<>());
        setPotions(new ArrayList<>());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }
}
