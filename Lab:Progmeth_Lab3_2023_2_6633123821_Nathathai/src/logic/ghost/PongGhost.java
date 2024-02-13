package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PongGhost extends HighGhost{
	private int power;
    public PongGhost(){
        this.power = Config.PongGhostPower;
    }
    public PongGhost(int power){
        this.power = power;
    }

    @Override
    public int getLevel() {
        return Config.PongGhostLevel;
    }

    @Override
    public String toString() {
        return "PongGhost [HP: " + getHp()+
                " , Power: " + power +
                ']';
    }
    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp()-power);
    }

    @Override
    public void damage() {
        for(Ghost ghost : GameController.getInstance().getGhosts()){
            if(ghost instanceof LowGhost){
                ghost.decreaseHp(-power);
            }
        }
    }
}
