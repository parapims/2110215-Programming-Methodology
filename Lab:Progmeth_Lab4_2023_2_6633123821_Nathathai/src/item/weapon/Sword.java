package item.weapon;

import item.base.BaseWeapon;
import item.usage.Upgradable;

import java.util.Arrays;

public class Sword extends BaseWeapon implements Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT;

    public Sword(){
        super("Sword",15,1);
        setLevel(0);
        MAX_LEVEL = 3;
        ATT = new int[]{3,5,8,12};
    }
    @Override
    public int getAtt() {
        return ATT[getLevel()];
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        if(level<0 || level>MAX_LEVEL) level = 0;
        this.level = level;
    }

    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    @Override
    public String toString() {
        return "Sword" +
                " (Att: " + getAtt() +
                ", Range: " + getRange() +
                ", Level: " + getLevel()+
                ", "+getDurability()+" uses left)";
    }
}
