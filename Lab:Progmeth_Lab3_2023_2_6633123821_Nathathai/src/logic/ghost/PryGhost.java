package logic.ghost;

import logic.game.GameController;
import utils.Config;

public class PryGhost extends LowGhost{
	private int power;
	private int ppt;
	public PryGhost(){
		this.power = Config.PryGhostPower;
		setPpt(0);
	}
	public PryGhost(int power){
		this.power = power;
		setPpt(0);
	}
	public PryGhost(int power,int ppt){
		this.power = power;
		setPpt(ppt);
	}

	@Override
	public String toString() {
		return "PryGhost [HP: " + getHp()+
				" , Power: " + power +
				" , PPT: " + ppt +
				']';
	}

	@Override
	public void attack() {
		GameController.getInstance().setHp(GameController.getInstance().getHp()-(power-getPpt()));
	}

	public int getPpt() {
		return ppt;
	}

	public void setPpt(int ppt) {
		this.ppt = ppt;
	}
}
