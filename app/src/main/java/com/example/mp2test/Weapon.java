/**
 * File Name: Weapon.java
 * Author: Ethan Berei
 * Date: 3/31/23
 * Description: The class responsible for holding weapons and combat within COLA's Oregon Trail Game
 */

package com.example.mp2test;

import java.io.Serializable;
import java.util.Random;

public class Weapon extends Item implements Serializable {

   //Member Variables
    private final int numberOfWeapons = 3;
    private int type;
    private int wear;
    private int bulletCount;
    private int maxBulletCount;
    private int ammo;
    private double bulletValue;
    private String[] typeConvert = new String[numberOfWeapons];

    /**
     * The Default Weapon Constructor. Creates a Basic Revolver called "DoHickey"
     */
    Weapon() {
        super();
        setupArray();
        this.type = 0;
        this.wear = 0;
        this.bulletCount = 6;
        this.maxBulletCount = 6;
        this.ammo = 0;
        this.bulletValue = 1.0;
        }

    /**
     * The Main Weapon Constructor. Has many adjustable values based on the weapon created
     * @param value The Amount the Weapon is worth
     * @param name - The flavor Name of the weapon. Has no effect on its type
     * @param randomizeValue True when the value of the weapon is randomized +-5.
     * @param type The type of the weapon that is being used. Determines its bullet count and the value of the bullets. Set as 0-X with X being numberOfWeapons
     * @param ammo The amount of extra ammo that is stored with the Weapon class
     * @param wear The amount of wear on the weapon. If 100, the weapon will not fire.
     */
    Weapon(double value, String name, boolean randomizeValue, int type, int ammo, int wear) {
        super(value, name, randomizeValue, true);
        setupArray();
        this.type = type;
        this.wear = wear;
        this.ammo = ammo;
        switch (type) {
            case 0:
                this.bulletCount = 6;
                this.maxBulletCount = 6;
                this.bulletValue = 1.0;
                break;
            case 1:
                this.bulletCount = 1;
                this.maxBulletCount = 1;
                this.bulletValue = 3.0;
                break;
            case 2:
                this.bulletCount = 4;
                this.maxBulletCount = 4;
                this.bulletValue = 5.0;
        }
    }

    /**
     * Getter for the type variable.
     * @return An integer between 0-X where X is the numberOfWeapons.
     */
    public int getType() {
        return type;
    }

    /**
     * Sets the type of the weapon and changes
     * @param type type of weapon between 0-X. See typeConvert for which weapon type is which
     */
    public void setType(int type) {
        this.type = type;
        switch (type) {
            case 0:
                this.bulletCount = 6;
                this.maxBulletCount = 6;
                this.bulletValue = 1.0;
                break;
            case 1:
                this.bulletCount = 1;
                this.maxBulletCount = 1;
                this.bulletValue = 3.0;
                break;
            case 2:
                this.bulletCount = 4;
                this.maxBulletCount = 4;
                this.bulletValue = 5.0;
        }
    }

    /**
     * Getter for the wear value of the weapon
     * @return An integer between 0 and 100
     */
    public int getWear() {
        return wear;
    }

    /**
     * Setter of the wear value of the weapon
     * @param wear An integer between 0 and 100 with 0 being brand new and 100 being broken
     */
    public void setWear(int wear) {
        if (wear > 100) this.wear = 100;
        else if (wear < 0) this.wear = 0;
        else this.wear = wear;
    }

    /**
     * Getter for the amount of bullets left in the clip of the weapon
     * @return An integer between 0 and maxBulletCount
     */
    public int getBulletCount() {
        return bulletCount;
    }

    /**
     * Setter for the amount of bullets left in the weapon
     * @param bulletCount An integer between 0 and maxBulletCount
     */
    public void setBulletCount(int bulletCount) {
        if (bulletCount > maxBulletCount) {
            this.bulletCount = maxBulletCount;
        }
        else if (bulletCount < 0) {
            this.bulletCount = 0;
        }
        else {
            this.bulletCount = bulletCount;
        }
    }

    /**
     * Getter for the maxBulletCount
     * @return An integer of the max number of bullets the weapon can have at one time.
     */
    public int getMaxBulletCount() {
        return maxBulletCount;
    }

    /**
     * Setter for maxBulletCount. Use lightly or funny might ensue.
     * @param maxBulletCount An integer of the max clip for the weapon.
     */
    public void setMaxBulletCount(int maxBulletCount) {
        this.maxBulletCount = maxBulletCount;
    }

    /**
     * Getter for the amount of reserve ammo for the weapon
     * @return An integer between 0 and X.
     */
    public int getAmmo() {
        return ammo;
    }

    /**
     * Setter for the amount of reserve ammo for the weapon
     * @param ammo An integer between 0 and intMax
     */
    public void setAmmo(int ammo) {
        if (ammo < 0) {
            this.ammo = 0;
        }
        else {
            this.ammo = ammo;
        }
    }

    /**
     * Getter for the value of each bullet
     * @return An integer for the amount of money each bullet is worth
     */
    public double getBulletValue() {
        return bulletValue;
    }

    /**
     * Setter for the value of each bullet
     * @param bulletValue An integer between 0 and intMax
     */
    public void setBulletValue(double bulletValue) {
        if (bulletValue < 0) {
            this.bulletValue = 0;
        }
        else {
            this.bulletValue = bulletValue;
        }
    }

    /**
     * Getter for the type of the name of the type of weapon.
     * @return A String of the type of weapon
     */
    public String getTypeString() {
        return typeConvert[type];
    }

    //Abstract Methods

    /**
     * The Implementation of the abstract useItem method. It allows the player to shoot bandits, hunt animals, or do target practice on other Items to delete them.
     * @param itemTarget The Item target for what item you want to shoot. Set to 'null' when you want to target a Member. NOTE: If both are not null, it will default to the ITEM!
     * @param memberTarget The Member target for what animal or person you want to shoot. Set to 'null' when you want to target an Item.
     * @return 0.0 when the shot was successful against an item. -1.0 when the shot failed. Any other value based on how much damage was done.
     */
    @Override
    public double useItem(Item itemTarget, Member memberTarget) {
        if (getInventoryIdentifier().equals(memberTarget.getName())) {
            if(bulletCount != 0){
                if (wear == 100){
                    //Splash text why gun cannot shoot
                    return -1.0;
                }
                else {
                    if (memberTarget == null) {
                        if (!itemTarget.getIndestructible()) {
                            //Insert console code here
                            itemTarget.setUsed(true);
                            itemTarget.setInventoryIdentifier(null);
                            return 0.0;
                        } else {
                            //Splash text for when the gun cannot be used
                            return -1.0;
                        }
                    } else {
                        if (memberTarget.isFriendly() && memberTarget.isHuman()) {
                            //Splash text for why you cannot shoot a friendly person
                            return -1.0;
                        } else if (memberTarget.isFriendly() && !memberTarget.isHuman()) {
                            //Splash text for why you cannot shoot a friendly dog
                            return -1.0;
                        } else if (memberTarget.isHuman()) {
                            //return murder(memberTarget);
                            //Implement later. For now: Splash text why murdering people is bad
                            return -1.0;
                        } else {
                            return hunt(memberTarget);
                        }
                    }
                }
            }
            else {
                //splash text why do not own the gun
                return -1.0;
            }
        }
        return -1.0;
    }

    //Implement Later
    //private double murder(Member memberTarget)

    /**
     * A helper function for the useItem method. Allows the player to hunt animals and get meat from the animal.
     * @param memberTarget The animal passed in by the useItem method
     * @return 0.0 when the hunt failed. Anything other than zero is the amount of meat the player gains from the hunt between 10-100 lbs.
     */
    private double hunt(Member memberTarget) {
            Random rand = new Random(System.currentTimeMillis());
            this.bulletCount-=1;
            //This is temporary. Will eventually have it so that you get proper amounts of meat from hunting with proper odds depending on which animal
            int chance = rand.nextInt(100);
            if (chance >= 75) {
                //Splash text of how you killed the animal
                memberTarget.die();
                return 10.0 + rand.nextInt(90);
            }
            else {
                //splash text of why you missed
                memberTarget.move((rand.nextInt(15) - rand.nextInt(15)), (rand.nextInt(15) - rand.nextInt(15)));
                return 0.0;
            }
    }

    /**
     * Allows the player to reload their weapon from their reserve.
     * @return False when the player is unable to reload their weapon due to it being full or being out of reserve ammo. True otherwise.
     */
    public boolean reload() {
        if (ammo == 0) {
            //Splash text why you are out of ammo
            return false;
        }
        if (bulletCount == maxBulletCount) {
            System.out.println("Your weapon is full...");
            return false;
        }
        int numberOfBulletsReloaded = maxBulletCount - bulletCount;
        if (ammo < numberOfBulletsReloaded) {
            numberOfBulletsReloaded = ammo;
        }
        ammo -= numberOfBulletsReloaded;
        bulletCount += numberOfBulletsReloaded;
        return true;
    }

    /**
     * Implementation of the abstract method sellItem for Weapon. It sells the value of the weapon + how much the bullets cost.
     * @return The value of the weapon and leftover ammo combined.
     */
    @Override
    public double sellItem() {
        return super.getValue() + (bulletValue * ammo);
    }

    /**
     * Helper Function that creates the array of the different types of weapons. The number of values listed here will always be based on the numberOfWeapons Variable.
     */
    private void setupArray() {
        typeConvert[0] = "Revolver";
        typeConvert[1] = "Shotgun";
        typeConvert[2] = "Rifle";
    }


}
