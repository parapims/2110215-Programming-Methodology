package item.consumption;

import item.base.BaseConsumption;
import item.usage.Healable;

import javax.swing.plaf.PanelUI;

public class Pill extends BaseConsumption implements Healable {
    private final int RECOVER_PT;
    public Pill(){
        super("Pill");
        RECOVER_PT = 2;
    }

    @Override
    public String toString() {
        return "Pill (+" + getRecoverPoint() + " HP)";
    }

    @Override
    public int getRecoverPoint() {
        return RECOVER_PT;
    }
}
