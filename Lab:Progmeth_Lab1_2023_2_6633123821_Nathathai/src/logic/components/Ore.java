package logic.components;

public class Ore {
    private String name;
    private int cost;

    //----------Method----------
    public Ore(String name, int cost){
        setName(name);
        setCost(cost);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = Math.max(1,cost);
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ore otherOre = (Ore) o;

        return getName().equals(otherOre.getName()) && getCost() == otherOre.getCost();
    }
}
