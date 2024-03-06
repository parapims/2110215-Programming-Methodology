package table;

import item.base.BaseItem;
import item.usage.CookState;
import item.usage.Cookable;

public class Oven extends BaseTable{

    public Oven() {
        super("Oven");
    }

    @Override
    public String interact(BaseItem item) {
        if(item instanceof Cookable){
            Cookable s = (Cookable) item;
            if(s.getCookState().equals(CookState.RAW)){
                s.setCookState(CookState.COOKED);
                return "Cooking succeed";
            }else if(s.getCookState().equals(CookState.COOKED)){
                s.setCookState(CookState.BURNT);
                return "Your food has been burnt";
            }else{
                return "Your food is already burnt, cannot be cooked anymore";
            }
        }else{
            return "This item cannot be cooked";
        }
    }
}
