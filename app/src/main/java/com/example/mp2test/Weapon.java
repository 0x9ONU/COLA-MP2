package com.example.mp2test;

import java.util.Random;

public class Weapon extends Item{
    static int numberOfWeapons = 3;
    int type;
    int wear;
    int bulletCount;
    int maxBulletCount;
    int ammo;
    double bulletValue;
    String[] typeConvert = new String[numberOfWeapons];
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWear() {
        return wear;
    }

    public void setWear(int wear) {
        if (wear > 100) this.wear = 100;
        else if (wear < 0) this.wear = 0;
        else this.wear = wear;
    }

    public int getBulletCount() {
        return bulletCount;
    }

    public void setBulletCount(int bulletCount) {
        this.bulletCount = bulletCount;
    }

    public int getMaxBulletCount() {
        return maxBulletCount;
    }

    public void setMaxBulletCount(int maxBulletCount) {
        this.maxBulletCount = maxBulletCount;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public double getBulletValue() {
        return bulletValue;
    }

    public void setBulletValue(double bulletValue) {
        this.bulletValue = bulletValue;
    }

    //Abstract Methods
    @Override
    public double useItem(Item itemTarget, Member memberTarget) {
        if(bulletCount != 0){
            if (wear == 100){
                //Splash text why gun cannot shoot
                return 0.0;
            }
            else {
                if (memberTarget == null) {
                    if (!itemTarget.getIndestructible()) {
                        //Insert console code here
                        itemTarget.setUsed(true);
                    } else {
                        //Splash text for when the gun cannot be used
                        return 0.0;
                    }
                } else {
                    if (memberTarget.getFriendly() && memberTarget.getHuman()) {
                        //Splash text for why you cannot shoot a friendly person
                        return 0.0;
                    } else if (memberTarget.getFriendly() && !memberTarget.getHuman()) {
                        //Splash text for why you cannot shoot a friendly dog
                        return 0.0;
                    } else if (memberTarget.getHuman()) {
                        //return murder(memberTarget);
                        //Implement later. For now: Splash text why murdering people is bad regardless if they are bad or not.
                        return 0.0;
                    } else {
                        return hunt(memberTarget)
                    }
                }
            }
        }
        else {
            //splash text why gun is empty
            return 0.0;
        }
        return 0.0;
    }

    //Implement Later
    //private double murder(Member memberTarget)

    private double hunt(Member memberTarget) {
        while (true) {
            Random rand = new Random(System.currentTimeMillis());
            this.bulletCount-=1;
            //This is temporary. Will eventually have it so that you get proper amounts of meat from hunting with proper odds depending on which animal
            int chance = rand.nextInt(100);
            if (chance >= 75) {
                //Splash text of how you killed the animal
                memberTarget.dead();
                return 10.0 + rand.nextInt(300);
            }
            else {
                //splash text of why you missed
                memberTarget.move((rand.nextInt(15) - rand.nextInt(15)), (rand.nextInt(15) - rand.nextInt(15)));
                return 0.0;
            }
        }
    }

    @Override
    public double sellItem() {
        super.setUsed(true);
        return value + (bulletValue * ammo);
    }

    private void setupArray() {
        typeConvert[0] = "Revolver";
        typeConvert[1] = "Shotgun";
        typeConvert[2] = "Rifle";
    }

}
