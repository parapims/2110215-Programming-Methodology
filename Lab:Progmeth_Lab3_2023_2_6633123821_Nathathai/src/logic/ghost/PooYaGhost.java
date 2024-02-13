package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PooYaGhost extends HighGhost{
	private int power;
    public PooYaGhost(int power){
        this.power = power;
    }

    @Override
    public int getLevel() {
        return Config.PooYaGhostLevel;
    }

    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp()-power);
        GameController.getInstance().setScore(GameController.getInstance().getScore()-power);
    }

    @Override
    public void damage() {
        for(Ghost ghost:GameController.getInstance().getGhosts()){
            ghost.decreaseHp(-power);
        }
    }

    @Override
    public String toString() {
        return "PooYaGhost [HP: " +getHp()+
                " , Power: " + power +
                ']';
    }
}
