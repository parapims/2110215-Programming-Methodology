package logic.components;

import exception.BadStatusException;
import logic.game.GameController;

public class Monster {
    private String name;
    private Status status;
    private Food food;
    private Potion potion;

    //----------Method----------
    public Monster(String name, Status status){
        setName(name);
        if(status.getHp()<1){
            try {
                status.setHp(1);
            } catch (BadStatusException e) {
                throw new RuntimeException(e);
            }
        }
        setStatus(status);
        setFood(null);
        setPotion(null);
    }
    public void attack(Player player){
        int damage = Math.max(0,status.getAttack()-player.getStatus().getDurability());
        Status newStatus = GameController.createNewStatus(Math.max(0,player.getStatus().getHp() - damage), player.getStatus().getDurability(),player.getStatus().getAttack(),player.getStatus().getMagic());
        player.setStatus(newStatus);
    }
    public void magicAttack (Player player){
        int damage = status.getMagic();
        Status newStatus = GameController.createNewStatus(Math.max(0,player.getStatus().getHp() - damage), player.getStatus().getDurability(),player.getStatus().getAttack(),player.getStatus().getMagic());
        player.setStatus(newStatus);
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Food getFood() {
        return food;
    }

    public Potion getPotion() {
        return potion;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setPotion(Potion potion) {
        this.potion = potion;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
