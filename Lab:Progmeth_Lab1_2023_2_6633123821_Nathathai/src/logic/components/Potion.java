package logic.components;

public class Potion {
    private String name;
    private int price;
    private Status increasingStatus;

    //----------Method----------
    public Potion(String name,int price, Status increasingStatus){
        setName(name);
        setPrice(price);
        setIncreasingStatus(increasingStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(obj == null || getClass()!=obj.getClass()) return false;
        Potion other = (Potion) obj;
        return(
                getName().equals(other.getName()) && getPrice() == other.getPrice() && getIncreasingStatus().equals(other.getIncreasingStatus())
                );
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Status getIncreasingStatus() {
        return increasingStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        price = Math.max(1,price);
        this.price = price;
    }

    public void setIncreasingStatus(Status increasingStatus) {
        this.increasingStatus = increasingStatus;
    }
}
