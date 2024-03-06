package item.consumption;

import item.base.BaseArmor;
import item.base.BaseConsumption;
import item.usage.CookState;
import item.usage.Cookable;
import item.usage.Healable;

import java.util.HashMap;

public class Pork extends BaseConsumption implements Cookable, Healable {
    private CookState cookState;
    private HashMap<CookState, Integer> RECOVER_PT;

    public Pork(){
        super("Pork");
        setCookState(CookState.RAW);
        RECOVER_PT = new HashMap<>();
        RECOVER_PT.put(CookState.RAW, 1);
        RECOVER_PT.put(CookState.COOKED, 2);
        RECOVER_PT.put(CookState.BURNT, 0);
    }
    public int getRecoverPoint(){
        return RECOVER_PT.get(getCookState());
    }
    @Override
    public CookState getCookState() {
        return cookState;
    }

    @Override
    public void setCookState(CookState cookState) {
        this.cookState = cookState;
    }

    @Override
    public String toString() {
        String s;
        if(getCookState().equals(CookState.RAW)) s = "Raw";
        else if(getCookState().equals(CookState.COOKED)) s = "Cooked";
        else s = "Burnt";
        return s+" Pork (+"+getRecoverPoint()+" HP)";
    }
}
