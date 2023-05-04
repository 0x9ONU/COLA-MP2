/**
 * File Name: Inventory.java
 * Author: Ethan Berei
 * Date: 4/1/23
 * Description: The class responsible for holding and keeping all Item objects within for every Member.
 */

package com.example.mp2test;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {
    private ArrayList<Item> items = new ArrayList<Item>();                                             //holds the list of items
    private int maxItemCount;                                                                       //the maximum amount of items that can be held
    private String memberIdentifier;                                                                //an ID string for the member

    /**
     * default constructor for Inventory
     */
    Inventory() {
        this.maxItemCount = 5;
        String memberIdentifier = "Test";
    }

    /**
     * constructor for inbentory requiring the max items and the member ID string
     * @param maxItemCount the maximum amount of items this inventory can hold
     * @param memberIdentifier the member that this belongs to
     */
    Inventory(int maxItemCount, Member memberIdentifier) {
        this.maxItemCount = maxItemCount;
        this.memberIdentifier = memberIdentifier.getName();
    }

    //getters

    protected Inventory(Parcel in) {
        maxItemCount = in.readInt();
        memberIdentifier = in.readString();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * gets the max items of the inventory
     * @return maxItemCount
     */


    public int getMaxItemCount() {
        return maxItemCount;
    }

    /**
     * returns the string of the name of the member the inventory belongs to
     * @return memberIdentifier
     */
    public String getMemberIdentifier() {
        return memberIdentifier;
    }

    /**
     * returns the item at the set index
     * @param index the index in the inventory of the member
     * @return the item at the index specified
     */
    public Item getItem(int index) {
        return items.get(index);
    }

    /**
     * gets the amount of items the inventory holds
     * @return the length of the items array
     */
    public int getItemsLength() {
        return items.size();
    }

    //setters

    /**
     * sets a new maxItemCount for an inventory
     * @param maxItemCount the amount of max items you want the inventory to have
     */
    public void setMaxItemCount(int maxItemCount) {
        this.maxItemCount = maxItemCount;
    }

    /**
     * sets who the inventory belongs to
     * @param memberIdentifier the member you want the inventory to belong to
     */
    public void setMemberIdentifier(Member memberIdentifier) {
        this.memberIdentifier = memberIdentifier.toString();
    }

    /**
     * sets a specific item into an inventory
     * @param index the index you want the item at
     * @param item which item you want the inventory to have
     */
    public void setItem(int index, Item item) {
        items.set(index, item);
    }

    /**
     * adds a default worthless item
     * @return true only if the item can be successfully added to the inventory
     */
    public boolean addItem() {
        if (maxItemCount == getItemsLength())
        {
            //Splash text why inventory is full
            return false;
        }
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
        return true;
    }

    /**
     * adds a specific item to an inventory
     * @param item that you want added to the inventory
     * @return true only if the specific item was added to the inventory
     */
    public boolean addItem(Item item) {
        if (maxItemCount == getItemsLength()) {
            //Splash text why your inventory is full
            return false;
        }

        try {
            items.add(item);
        }
        catch (IndexOutOfBoundsException e) {
            //Splash Text why you are out of bounds
            return false;
        }
        items.get(getItemsLength()-1).setInventoryIdentifier(memberIdentifier);
        return true;

    }

    /**
     * removes the last item in an inventory array
     * @return true only if the last item was removed from the array
     */
    public boolean removeItem() {
        if (getItemsLength() != 0) {
            items.remove(getItemsLength() - 1);
            return true;
        }
        return false;
    }

    /**
     * removes a specific item from the inventory array
     * @param index the index at which the item is held in the inventory
     * @return true only if it is removed successfully
     */
    public boolean removeItem(int index) {
        if (getItemsLength() == 0) {
            //Splash why you cannot remove nothing
            return false;
        }
        try {
            items.remove(index);
        }
        catch(IndexOutOfBoundsException e) {
            //SPlash text why you are out of bounds
            return false;
        }
        finally {
            return true;
        }
    }

    //Member Functions

    /**
     * gives an item to an external inventory
     * @param itemIndex the index in which the item is located
     * @param inv the inventory its being given to
     * @return true only if it gives the item successfully
     */
    public boolean giveItem(int itemIndex, Inventory inv) {
        if (inv.getItemsLength() == inv.getMaxItemCount()) {
            //Splash text why you cannot give an item
            return false;
        }
        try {
            Item temp = items.get(itemIndex);
            inv.addItem(temp);
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

    /**
     * takes an item from another inventory's index
     * @param itemIndex the index of item of the external inventory
     * @param inv the inventory that the item is coming from
     * @return true only if it works successfully
     */
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

    public String listInventory() {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < getItemsLength(); i++) {
            temp.append(i + ": " + items.get(i).getName() + "\n\r");
        }
        return temp.toString();
    }
}
