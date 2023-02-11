package edu.isu.cs2235l20.items;

public class Photograph implements Sellable {

    private String description;
    private int price;
    private boolean color;

    public Photograph(String description, int price, boolean color) {
        this.description = description;
        this.price = price;
        this.color = color;
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

    public boolean isColor() {
        return color;
    }
}
