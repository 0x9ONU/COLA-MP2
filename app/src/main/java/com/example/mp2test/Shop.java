package com.example.mp2test;

public class Shop {
    private int x;                                                                                  // holds x cord
    private int y;                                                                                  //holds y cord
    private Inventory shopInventory;                                                                //gives an inventory to the Shop
    private String name;                                                                            //holds a name for the shop
    private Member shopKeeper;                                                                      //holds a character for the ShopKeeper

    /**
     * Basic constructor for Shop
     */
    Shop() {                                                                                        //default constructor
        this.x = 0;
        this.y = 0;
        this.name = "Test";
        shopInventory = new Inventory();
        shopKeeper =  new Member();
    }

    /**
     * constructor for shop without shopkeeper name
     * @param x to hold an inserted x value
     * @param y to hold an inserted y value
     * @param name to hold an inserted shop name
     * @param shopInventory to hold an inserted inventory (may need to be a creeate inventory method)
     *
     */
    Shop(int x, int y, String name, Inventory shopInventory) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.shopInventory = shopInventory;
        this.shopKeeper = new Member();
        shopInventory.setMemberIdentifier(shopKeeper);
    }

    /**
     * constructor for shop with all values
     * @param x to hold an inserted x value
     * @param y to hold an inserted y value
     * @param name to hold an inserted shop name
     * @param shopInventory to hold an inserted inventory
     * @param shopKeeper to hold an inserted shopkeeper
     */
    Shop(int x, int y, String name, Inventory shopInventory, Member shopKeeper) {
        this.x = x;
        this.y = y;
        this.shopInventory = shopInventory;
        this.shopKeeper = shopKeeper;
        shopInventory.setMemberIdentifier(shopKeeper);
    }

    /**
     * gets x value
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * sets x value
     * @param x sets x value to inserted x value
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * gets y value
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * sets y value
     * @param y sets y value to inserted y value
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * gets Shop name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * sets shop name
     * @param name sets name value to inserted name value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * checks if its possible to add an item to the inventory
     * @param item the item that the player wants to add to an inventory
     * @return true if the inventory would not hit max items
     * @return false if the inventory would hit hit max items
     */
    public boolean addItem(Item item) {
        if (!shopInventory.addItem(item)) {
            return false;
        }
        return true;
    }

    /**
     * gets an item at the specific index
     * @param itemIndex should be the index at which the item is held
     * @return what item is held at that specific index
     */
    public Item getItem(int itemIndex) {
        return shopInventory.getItem(itemIndex);
    }

    /**
     * checks if an item exists then removes it from the sellers inventory and adds the money
     * from to the sellers inventory
     * @param seller who is selling the item
     * @param index what the index of the item is in the sellers inventory
     * @return false if the item doesn't exist, or it fails
     * @return true if the item is sold correctly
     */
    public boolean sellItem(Member seller, int index) {
        try {
            seller.inventory.getItem(index).getValue();
        }
        catch (IndexOutOfBoundsException e) {
            //Splash text why that item does not exist
            return false;
        }
        finally {
            double receivingMoney = seller.inventory.getItem(index).getValue();
            seller.inventory.removeItem(index);
            seller.incrementMoney(receivingMoney);
            return true;
        }
    }

    /**
     * has the member buy the item from the shopkeeper
     * @param buyer who is buying the item
     * @param index where the item is held in the Shop's inventory
     * @return true only if they can buy the item from the shopkeeper
     */
    public boolean buyItem(Member buyer, int index) {
        try {
            shopInventory.getItem(index).getValue();
        }
        catch (IndexOutOfBoundsException e) {
            //Splash text why that item does not exist
            return false;
        }
        finally {
            double payment = shopInventory.getItem(index).getValue();
            if (buyer.getMoney() < payment) {
                //Splash text why you do not have enough money to buy that item
                return false;
            }
            else {
                buyer.decrementMoney(payment);
                shopInventory.giveItem(index, buyer.inventory);
                return true;
            }
        }
    }
}