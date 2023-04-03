package com.example.mp2test;
import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<Item>();
    private int maxItemCount;
    private String memberIdentifier;

    Inventory() {
        this.maxItemCount = 5;
        String memberIdentifier = "Test";
    }

    Inventory(int maxItemCount, Member memberIdentifier) {
        this.maxItemCount = maxItemCount;
        this.memberIdentifier = Member.getName();
    }

    //getters
    public int getMaxItemCount() {
        return maxItemCount;
    }

    public String getMemberIdentifier() {
        return memberIdentifier;
    }

    public Item getItem(int index) {
        return items.get(index);
    }

    public int getItemsLength() {
        return items.size();
    }

    //setters
    public void setMaxItemCount(int maxItemCount) {
        this.maxItemCount = maxItemCount;
    }

    public void setMemberIdentifier(Member memberIdentifier) {
        this.memberIdentifier = memberIdentifier.toString();
    }

    public void setItem(int index, Item item) {
        items.set(index, item);
    }

    public void addItem(Item item) {
        if (items.size() == maxItemCount) {
            //Splash text to why you cannot add another item.
        }
        items.add(item);
    }

    public void removeItem() {
        items.remove(getItemsLength()-1);
    }
    public void removeItem(int index) {
        items.remove(index);
    }
    //Member Functions

    public boolean giveItem(int itemIndex, Inventory inv) {
        if (inv.getItemsLength() == inv.getMaxItemCount()) {
            //Splash text why you cannot give an item
            return false;
        }
        try {
            inv.addItem(getItem(itemIndex));
        }
        catch(IndexOutOfBoundsException e) {
            //Splash text why you do not have that index of item in your inventory
            return false;
        }
            items.remove(itemIndex);
            return true;
    }

    public boolean takeItem(int itemIndex, Inventory inv) {
    }
}
