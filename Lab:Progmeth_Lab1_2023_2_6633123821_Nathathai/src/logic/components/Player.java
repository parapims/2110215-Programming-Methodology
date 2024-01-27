package logic.components;

import exception.BadStatusException;
import logic.game.GameController;

import java.util.ArrayList;

public class Player {
    private String name;
    private Status status;
    private int energy;
    private int money;
    private ArrayList<Food> foods;
    private ArrayList<Potion> potions;
    private ArrayList<Ore> ores;

    //----------Method----------

    public void setName(String name) {

        this.name = name;
    }

    public void setStatus(Status status) {

        this.status = status;
    }

    public void setEnergy(int energy) {
        energy = Math.max(0,energy);
        this.energy = energy;
    }

    public void setMoney(int money) {
        money = Math.max(0,money);
        this.money = money;
    }

    public void setFoods(ArrayList<Food> foods) {

        this.foods = foods;
    }

    public void setPotions(ArrayList<Potion> potions) {
        this.potions = potions;
    }

    public void setOres(ArrayList<Ore> ores) {
        this.ores = ores;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMoney() {
        return money;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public ArrayList<Ore> getOres() {
        return ores;
    }
    public Player(String name, Status status){
        setName(name);
        if(status.getHp() < 1){
            Status newStatus = GameController.createNewStatus(1, status.getDurability(),status.getAttack(),status.getMagic());
            setStatus(newStatus);
        }else {
            setStatus(status);
        }
        setEnergy(10);
        setMoney(100);
        setFoods(new ArrayList<>());
        setPotions(new ArrayList<>());
        setOres(new ArrayList<>());
    }
    public Player(String name, Status status, int energy, int money){
        setName(name);
        if(status.getHp() <= 0){
            Status newStatus = GameController.createNewStatus(1, status.getDurability(),status.getAttack(),status.getMagic());
            setStatus(newStatus);
        }else {
            setStatus(status);
        }
        setEnergy(energy);
        setMoney(money);
        setFoods(new ArrayList<>());
        setPotions(new ArrayList<>());
        setOres(new ArrayList<>());
    }
    public boolean buyOre(Ore ore){
        if(getMoney()>=ore.getCost()){
            setMoney(getMoney()-ore.getCost());
            ores.add(ore);
            return true;
        }
        return false;
    }
    public void drinkPotion(int index){
        if (index >= 0 && index < getPotions().size()) {
            Potion potion = potions.get(index);

            try {
                status.addStatus(potion.getIncreasingStatus());
            }catch (BadStatusException e){
                return;
            }
            potions.remove(index);
        }
    }
    public void eatFood(int index){
        if(index>=0 && index< getFoods().size()){
            Food food = foods.get(index);

            setEnergy(getEnergy()+food.getEnergy());

            foods.remove(index);
        }
    }
    public void sellPotion(int index){
        if (index >= 0 && index < getPotions().size()) {
            Potion potion = potions.get(index);

            setMoney(getMoney()+ potion.getPrice());

            potions.remove(index);
        }
    }
    public void sellFood(int index){
        if(index>=0 && index< getFoods().size()){
            Food food = foods.get(index);

            setMoney(getMoney()+food.getPrice());

            foods.remove(index);
        }
    }
    public void attack(Monster monster){
        int damage = Math.max(0,status.getAttack()-monster.getStatus().getDurability());

        Status newStatus = GameController.createNewStatus(Math.max(0,monster.getStatus().getHp() - damage), monster.getStatus().getDurability(),monster.getStatus().getAttack(),monster.getStatus().getMagic());
        monster.setStatus(newStatus);
    }
    public void magicAttack(Monster monster){
        int damage = status.getMagic();

        Status newStatus = GameController.createNewStatus(Math.max(0,monster.getStatus().getHp() - damage), monster.getStatus().getDurability(),monster.getStatus().getAttack(),monster.getStatus().getMagic());
        monster.setStatus(newStatus);
    }
}
