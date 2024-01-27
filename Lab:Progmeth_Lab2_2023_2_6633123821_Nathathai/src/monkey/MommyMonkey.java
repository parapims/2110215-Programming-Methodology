package monkey;

import logic.game.GameSystem;

public class MommyMonkey extends BaseMonkey{
    public MommyMonkey(int hp, int atk, int def){
        super(hp,atk,def);
    }
    public void attack(BaseMonkey m){
        return;
    }
    public void birth(){
        BaseMonkey newMonkey = new BaseMonkey();
        GameSystem.getInstance().getMonkeyContainer().add(newMonkey);
    }
}
