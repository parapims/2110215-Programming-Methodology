package monkey;

import logic.game.GameSystem;

import java.util.ArrayList;

public class Ape extends BaseMonkey{
    public Ape(int maxHp, int atk, int def){
        super(maxHp,atk,def);
    }
    public void attack(BaseMonkey m){
        super.attack(m);
    }
    public void attackAOE(){
        ArrayList <BaseMonkey> allmonkeys = GameSystem.getInstance().getMonkeyContainer();
        for(BaseMonkey monkey : allmonkeys){
            attack(monkey);
        }
    }
}
