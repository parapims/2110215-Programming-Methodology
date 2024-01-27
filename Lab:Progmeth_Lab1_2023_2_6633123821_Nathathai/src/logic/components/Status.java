package logic.components;
import exception.BadStatusException;

public class Status {
    private int hp;
    private int durability;
    private int attack;
    private int magic;

    //----------Method----------

    public Status(int hp, int durability, int attack, int magic) throws BadStatusException{
        if(hp<0 || durability<0 || attack<0 || magic<0 ) throw new BadStatusException();
        setHp(hp);
        setDurability(durability);
        setAttack(attack);
        setMagic(magic);
    }

    public void setHp(int hp) throws BadStatusException{
            if (hp < 0) {
                throw new BadStatusException();
            }
            this.hp = hp;
    }

    public void setDurability(int durability) throws BadStatusException {
            if (durability < 0) {
                throw new BadStatusException();
            }
            this.durability = durability;
    }

    public void setAttack(int attack) throws BadStatusException{
        if (attack < 0) {
            throw new BadStatusException();
        }
        this.attack = attack;
    }

    public void setMagic(int magic) throws BadStatusException {
            if (magic < 0) {
                throw new BadStatusException();
            }
            this.magic = magic;

    }

    public int getHp() {
        return hp;
    }

    public int getDurability() {
        return durability;
    }

    public int getAttack() {
        return attack;
    }

    public int getMagic() {
        return magic;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    public void addStatus(Status another) throws BadStatusException{
        this.hp += another.getHp();
        this.durability += another.getDurability();
        this.attack += another.getAttack();
        this.magic += another.getMagic();
    }
}
