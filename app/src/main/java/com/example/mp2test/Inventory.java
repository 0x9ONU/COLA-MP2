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

    public void addItem() {
        Item newItem = new Item() {
            @Override
            public double useItem(Item itemTarget, Member memberTarget) {
                return 0;
            }

            @Override
            public double sellItem() {
                return 0;
            }
        };
        items.add(newItem);
    }

    public void addItem(Item item) {
        item.setInventoryIdentifier(memberIdentifier);
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
            inv.addItem(this.getItem(itemIndex));
        }
        catch(IndexOutOfBoundsException e) {
            //Splash text why you do not have that index of item in your inventory
            return false;
        }
        finally {
            removeItem(itemIndex);
            return true;
        }
    }

    public boolean takeItem(int itemIndex, Inventory inv) {
        if (maxItemCount == getItemsLength()) {
            //Splash text why you cannot take an item
            return false;
        }
        try {
            addItem(inv.getItem(itemIndex));
        }
        catch(IndexOutOfBoundsException e) {
            //Splash text why the index of the item in the other inventory does not exist
            return false;
        }
        finally {
            inv.removeItem(itemIndex);
            return true;
        }
    }
}
