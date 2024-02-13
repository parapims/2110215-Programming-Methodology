package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import utils.Config;

public class Monk extends Actor{
    public Monk(){}

    @Override
    public int getLevel() {
        return Config.MonkLevel ;
    }

    @Override
    public void attack() {
        Ghost firstGhost = GameController.getInstance().getGhosts().get(0);
        if(firstGhost instanceof HighGhost){
            firstGhost.decreaseHp(getLevel());
        }
    }

    @Override
    public String toString() {
        return "Monk";
    }
}