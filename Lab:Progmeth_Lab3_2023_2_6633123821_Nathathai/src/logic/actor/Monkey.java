package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class Monkey extends Actor{
    public Monkey(){}

    @Override
    public int getLevel() {
        return Config.MonkeyLevel;
    }

    @Override
    public void attack() {
        Ghost firstGhost = GameController.getInstance().getGhosts().get(0);
        if(firstGhost instanceof LowGhost){
            for(Item item:GameController.getInstance().getItems()){
                if(item instanceof Banana){
                    firstGhost.setHp(0);
                    return;
                }
            }
            firstGhost.decreaseHp(getLevel());
        }
    }

    @Override
    public String toString() {
        return "Monkey";
    }
}