package item.armor;

import item.base.BaseArmor;
import item.usage.Upgradable;

import java.util.ArrayList;
import java.util.Arrays;

public class Suit extends BaseArmor implements Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] DEF;
    public Suit(){
         super("Suit",10);
         setLevel(0);
         MAX_LEVEL = 3;
         DEF = new int[]{1, 2, 3, 5};
    }
    public int getDef(){
        return DEF[getLevel()];
    }
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level<0||level>MAX_LEVEL) level = 0;
        this.level = level;
    }

    @Override
    public int getMaxLevel() {
        return MAX_LEVEL;
    }

    public int getMAX_LEVEL() {
        return MAX_LEVEL;
    }

    @Override
    public String toString() {
        return "Suit" +
                " (Def: " + getDef() +
                ", Level: " + getLevel() +
                ")";
    }
}
