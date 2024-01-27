package monkey;

public class MuscleMonkey extends BaseMonkey{
    private final int POWER_UP = 4;

    public MuscleMonkey(int maxHp,int atk , int def){
        super(maxHp,atk,def);
    }
    public void attack(BaseMonkey m){
        int damage = getAtk()-m.getDef();
        m.setHp(m.getHp()-(2*damage));
    }
    public void buff(){
        setAtk(getAtk()+POWER_UP);
        setDef(getDef()+POWER_UP);
    }

}
