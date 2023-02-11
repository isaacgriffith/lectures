package edu.isu.cs2235l20.items;

public class BoxedItem implements Sellable, Transportable {

    private String description;
    private int price;
    private int weight;
    private boolean hazardous;
    private int height = 0;
    private int width = 0;
    private int depth = 0;

    public BoxedItem(String description, int price, int weight, boolean hazardous) {
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.hazardous = hazardous;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public int listPrice() {
        return price;
    }

    @Override
    public int lowestPrice() {
        return price / 2;
    }

    @Override
    public int weight() {
        return weight;
    }

    @Override
    public boolean isHazardous() {
        return hazardous;
    }

    public int insuredValue() { return price * 2; }

    public void setBox(int h, int w, int d) {
        height = h;
        width = w;
        depth = d;
    }
}
