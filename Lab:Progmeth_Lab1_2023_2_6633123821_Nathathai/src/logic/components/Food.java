package logic.components;

import java.util.Objects;

public class Food {
    private String name;
    private int price;
    private int energy;

    //----------Method----------

    public Food(String name,int price,int energy){
        setName(name);
        setPrice(price);
        setEnergy(energy);
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = Math.max(1,price);
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(1,energy);
    }

    public String getName() {
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }

    public int getEnergy() {
        return this.energy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return price == food.price && energy == food.energy && Objects.equals(name, food.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, energy);
    }
}
