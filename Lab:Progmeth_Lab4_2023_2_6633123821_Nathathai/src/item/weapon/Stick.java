package item.weapon;

import item.base.BaseWeapon;

public class Stick extends BaseWeapon {
    private final int ATT;
    public Stick(){
        super("Stick",3,0);
        ATT = 1;
    }
    @Override
    public int getAtt() {
        return ATT;
    }
}
