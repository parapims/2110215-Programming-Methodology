package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class MaBongGhost extends LowGhost{
	private int power;
    private int speed;

    public MaBongGhost(){
        this.power = Config.MaBongGhostPower;
        setSpeed(Config.MaBongGhostSpeed);
    }
    public MaBongGhost(int power){
        this.power = power;
        setSpeed(Config.MaBongGhostSpeed);
    }
    public MaBongGhost(int power,int speed){
        this.power = power;
        setSpeed(speed);
    }

    @Override
    public String toString() {
        return ("MaBongGhost [HP: "+getHp()+" , Power: "+power+" , Speed: "+getSpeed()+"]");
    }

    @Override
    public void attack() {
        GameController.getInstance().setHp(GameController.getInstance().getHp()-(power*getSpeed()));
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
