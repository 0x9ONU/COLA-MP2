package com.example.mp2test;

public class Shop {
    private int x;
    private int y;
    private Inventory shopInventory;
    private String name;
    private Member shopKeeper;

    Shop() {
        this.x = 0;
        this.y = 0;
        this.name = "Test";
        shopInventory = new Inventory();
        shopKeeper =  new Member();
    }

    Shop(int x, int y, String name, Inventory shopInventory) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.shopInventory = shopInventory;
        this.shopKeeper = new Member();
        shopInventory.setMemberIdentifier(shopKeeper);
    }

    Shop(int x, int y, String name, Inventory shopInventory, Member shopKeeper) {
        this.x = x;
        this.y = y;
        this.shopInventory = shopInventory;
        this.shopKeeper = shopKeeper;
        shopInventory.setMemberIdentifier(shopKeeper);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean addItem(Item item) {
        if (!shopInventory.addItem(item)) {
            return false;
        }
        return true;
    }

    public Item getItem(int itemIndex) {
        return shopInventory.getItem(itemIndex);
    }

    public boolean sellItem(Member seller, int index) {
        try {
            seller.inventory.getItem(index).sellItem();
        }
        catch (IndexOutOfBoundsException e) {
            //Splash text why that item does not exist
            return false;
        }
        finally {
            double receivingMoney = seller.inventory.getItem(index).sellItem();
            seller.inventory.removeItem(index);
            seller.incrementMoney(receivingMoney);
            return true;
        }
    }

    public boolean buyItem(Member buyer, int index) {
        try {
            shopInventory.getItem(index).getValue();
        }
        catch (IndexOutOfBoundsException e) {
            //Splash text why that item does not exist
            return false;
        }
        finally {
            double payment = shopInventory.getItem(index).sellItem();
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