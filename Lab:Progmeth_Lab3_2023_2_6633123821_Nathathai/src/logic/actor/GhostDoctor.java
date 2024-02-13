package logic.actor;

import logic.game.GameController;
import logic.ghost.Ghost;
import logic.ghost.HighGhost;
import logic.ghost.LowGhost;
import logic.item.Amulet;
import logic.item.Banana;
import logic.item.Item;
import utils.Config;

public class GhostDoctor extends Actor{
    public GhostDoctor(){}

    @Override
    public int getLevel() {
        return Config.GhostDoctorLevel ;
    }

    @Override
    public void attack() {
        Ghost firstGhost = GameController.getInstance().getGhosts().get(0);
        if(firstGhost instanceof LowGhost){
            firstGhost.setHp(0);
        }
    }

    @Override
    public String toString() {
        return "GhostDoctor";
    }
}