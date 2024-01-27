package monkey;

public class BaseMonkey {
    private int maxHp;
    private int hp;
    private int atk;
    private int def;

    public BaseMonkey(){
        setMaxHP(30);
        setHp(this.maxHp);
        setAtk(20);
        setDef(5);
    }
    public BaseMonkey(int maxHp, int atk, int def){
        setMaxHP(maxHp);
        setHp(maxHp);
        setAtk(atk);
        setDef(def);
    }
    public  void attack(BaseMonkey m){
        int damage = getAtk()-m.getDef();
        m.setHp(m.getHp()-damage);
    }
    public String getType(){
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return(getType()+" hp="+hp+", atk="+atk+", def="+def);
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public void setMaxHP(int maxHP) {
        this.maxHp = Math.max(0,maxHP);
    }

    public void setHp(int hp) {
        if(hp>getMaxHp()){
            hp = this.maxHp;
        }
        this.hp = Math.max(0,hp);
    }

    public void setAtk(int atk) {
        this.atk = Math.max(0,atk);
    }

    public void setDef(int def) {
        this.def = Math.max(0,def);
    }
}
