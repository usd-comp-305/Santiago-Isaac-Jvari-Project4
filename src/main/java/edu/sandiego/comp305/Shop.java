package edu.sandiego.comp305;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Shop {
    private ArrayList<Item> avaliableItems;

    public Shop() {
        this.avaliableItems = new ArrayList<>();
    }

    public Shop(final Shop other){
        this.avaliableItems = new ArrayList<>(other.avaliableItems);
    }

    public List<Item> getAvailableItems() {
        return Collections.unmodifiableList(avaliableItems);
    }

    public void addItem(final Item item){
        avaliableItems.add(item);
    }

    public void removeItem(final Item item){
        avaliableItems.remove(item);
    }

    public void addMultipleItems(final ArrayList<Item> items){
        avaliableItems.addAll(items);
    }

    public boolean hasItem(final Item item){
        return avaliableItems.contains(item);
    }
}
