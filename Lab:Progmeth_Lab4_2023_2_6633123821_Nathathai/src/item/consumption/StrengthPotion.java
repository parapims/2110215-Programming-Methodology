package item.consumption;

import item.base.BaseConsumption;
import item.usage.AttBuffable;
import item.usage.Upgradable;

public class StrengthPotion extends BaseConsumption implements AttBuffable, Upgradable {
    private int level;
    private final int MAX_LEVEL;
    private final int[] ATT_BUFF;
    private final int BUFF_TURN;

    public StrengthPotion(){
        super( "StrengthPotion");
        setLevel(0);
        MAX_LEVEL = 3;
        BUFF_TURN =3;
        ATT_BUFF = new int[]{3,5,7,10};
    }


    @Override
    public int getAttBuff() {
        return ATT_BUFF[getLevel()];
    }

    @Override
    public int getBuffTurn() {
        return BUFF_TURN;
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
        return "StrengthPotion (+" + getAttBuff()+
                " Att for next "+ getBuffTurn()+ " turns, Level: "
                +getLevel()+')';
    }
}
