/**
 * File Name: Map.java
 * Author: Aiden Tallet
 * Date: 3/31/23
 * Description: The class responsible for holding some locations
 */
package com.example.mp2test;

public class Map {
    int playerLocationX;                                                                            //will hold player's X cord
    int playerLocationY;                                                                            //will hold player's Y cord
    int wagonLocationX;                                                                             //will hold wagon's X cord
    int wagonLocationY;                                                                             //will hold wagon's Y cord
    final int[] monumentLocationX = {44,115,165,180, 277, 290, 335, 492, 509, 564, 585, 612, 640, 660, 780, 838, 975, 1040, 1090, 1186, 1300, 1445, 1567, 1660, 1800, 2170};                                                   //will hold all monument X cords (need hardcoded)
    final int[] monumentLocationY = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};                                                      //will hold all monument Y cords (need hardcoded)
    final String[] monumentNames = {"Gardner Junction", "Red Vermillion Crossing", "Big Blue River Crossing", "Hollenberg Pony Express Station" , "Liberty Farm Station", "Fort Kearny Outpost", "Fort Kearny", "California Hill", "Ash Hallow", "Courthouse and Jail Rock", "Chimney Rock", "Pioneer Graves", "Cold Springs Camp", "Fort Laramie", "Deer Creek Crossing", "Independence Rock", "Fort Bridger", "Thomas Fork Crossing", "Sulphur Springs", "Massacre Rocks", "The Raft River", "Milner Swales", "Thousand Springs", "Hot Spring", "Umatilla River Crossing", "Fort Vancouver"};                          //holds all monument names
    final String[] monumentDescription = {"A large open field full of flowers and tall grass. There are many wagons here as many families say their goodbyes.", "A row of graves of those unfortunate to catch the trail virus...", "A small trade hut that is in the middle of the trail. The new smell of oak shows that this place has recently been built.", "A recently cleared ground that has lots of shale and spare wood around. There seems to be a couple in the distance." ,"A tiny log cabin that oversees the trail. Inside are two burly guards that seem intimidating, but are very friendly!", "The massive fort overseas the trail for many miles. It is placed strategically to protect emigrants from bandits.", "A divide in the road between California and Oregon. Mother and Father want us to keep going to Oregon, but a lot of people are going to California. They will be missed.", "A camp full of Natives can be seen in the distance as well as the smoke from the travelers nearby. This place seems very relaxing. Maybe we should rest here...", "A large rock structure that does not resemble anything at home. There are a few traders around here looking for a good deal.", "A massive hill that ever so slightly bevels upward until it become a large spike upwards.", "The wooden crosses made of sticks extends for at least a mile. The thought of how many people were buried here makes you sick...", "A beautiful location that is perfect for a rest.", "The second fort along the journey. Its large log exterior looks over the land with many Indian tipis dotting the land. A grand United States Flag waves over this area of peace.", "A shallow creek that divides the small settlement. Ferries come to and through taking people across the river.", ""};
    /**
     * Basic constructor for Map
     */
    public Map() {                                                                                  //creates a default map with everything starting at position 0
        playerLocationX = 0;
        playerLocationY = 0;
        wagonLocationX = 0;
        wagonLocationY = 0;
    }
    /**
     *should give the player's X cord
     *
     * @return playerLocationX
     */
    public int getPlayerLocationX() {                                                               //returns Player's X cord
        return playerLocationX;
    }

    /**
     * teleports the player by the X cord
     * @param playerLocationX the new location for the player on the X grid
     */
    public void setPlayerLocationX(int playerLocationX) {                                           //teleports the player (moves the player to a specific X cord)
        this.playerLocationX = playerLocationX;
    }
    /**
     *should give the player's Y cord
     *
     * @return playerLocationY
     */
    public int getPlayerLocationY() {
        return playerLocationY;
    }

    /**
     * teleports the player by the Y cord
     * @param playerLocationY the new location for the player on the Y grid
     */
    public void setPlayerLocationY(int playerLocationY) {
        this.playerLocationY = playerLocationY;
    }

    /**
     * returns the wagon's location X cord
     * @return wagonLocationX
     */
    public int getWagonLocationX() {
        return wagonLocationX;
    }

    /**
     * teleports the wagon's location to the X cord
     * @param wagonLocationX the new location for the wagon on the X grid
     */
    public void setWagonLocationX(int wagonLocationX) {
        this.wagonLocationX = wagonLocationX;
    }

    /**
     * returns the wagon's location Y cord
     * @return wagonLocationY
     */
    public int getWagonLocationY() {
        return wagonLocationY;
    }

    /**
     * teleports the wagon's location to the Y cord
     * @param wagonLocationY the new location for the wagon on the Y grid
     */
    public void setWagonLocationY(int wagonLocationY) {
        this.wagonLocationY = wagonLocationY;
    }

    /**
     * returns all monument locations on the X cord
     * @return monumentLocationX
     */
    public int[] getMonumentLocationX() {
        return monumentLocationX;
    }

    /**
     * returns all monument locations on the Y cord
     * @return monumentLocationY
     */
    public int[] getMonumentLocationY() {
        return monumentLocationY;
    }

    /**
     * adds a value to the players X and Y cords
     * @param XChange the change in X
     * @param YChange the change in Y
     */
    public void MovePlayer(int XChange, int YChange) {
        playerLocationX += XChange;                                                                 //adds the value to the playerlocationX
        playerLocationY += YChange;                                                                 //adds the value to the playerlocationY
    }

    /**
     * adds a value to the wagon's X and Y cords
     * @param XChange the change in X
     * @param YChange the change in Y
     */
    public void MoveWagon(int XChange, int YChange) {
        wagonLocationY += YChange;                                                                  //adds the value to the wagonlocationX
        wagonLocationX += XChange;                                                                  //adds the value to the wagonLocaitonY
    }

    /**
     * checks if the player is at a monument and returns the name of the monument or "none" if they
     * aren't at a monument
     * @return name of a monument or none
     */
    public String CheckMonument() {
        for (int i = 0; i < monumentLocationX.length; i ++) {
            for (int j = 0; j < monumentLocationY.length; j++) {
                if (monumentLocationX[i] == playerLocationX && monumentLocationY[j] == playerLocationY) {  //checks if the player is at the right x and y coordinates
                    return monumentNames[i];
                }
            }
        }
        return "none";
    }

    /**
     * checks if the player is at a shop
     * @param Shopname the name of a shop
     * @return true only if the player is at a shop
     */
    public boolean CheckShop(Shop Shopname) {
        if (Shopname.getX() == playerLocationX && Shopname.getY() == playerLocationY ) {            // checks if the player is at the right x and y coordinates
            return true;
        } else {
            return false;
        }
    }
}
