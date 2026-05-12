package edu.sandiego.comp305;

public abstract class Item{
    private String name;

    private int cost;

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }

    protected void setCost(final int cost) {
        this.cost = cost;
    }

    protected void setName(final String name){
        this.name = name;

    }

}


