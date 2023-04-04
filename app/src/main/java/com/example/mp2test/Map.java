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
    int[] monumentLocationX;                                                                        //will hold all monument X cords (need hardcoded)
    int[] monumentLocationY;                                                                        //will hold all monument Y cords (need hardcoded)

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
        playerLocationX += XChange;
        playerLocationY += YChange;
    }

    /**
     * adds a value to the wagon's X and Y cords
     * @param XChange the change in X
     * @param YChange the change in Y
     */
    public void MoveWagon(int XChange, int YChange) {
        wagonLocationY += YChange;
        wagonLocationX += XChange;
    }

    /**
     * checks if the player is at a monument
     * @return true if the player is at a monument
     * @return false if the player is not a monument
     */
    public boolean CheckMonument() {
        for (int i = 0; i < monumentLocationX.length; i ++) {
            for (int j = 0; j < monumentLocationY.length; j++) {
                if (monumentLocationX[i] == playerLocationX && monumentLocationY[j] == playerLocationY) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks if the player is at a shop
     * @param Shopname
     * @return true if the player is at a shop
     * @return false if the player is not at a shop
     */
    public boolean CheckShop(Shop Shopname) {
        if (Shopname.getX() == playerLocationX && Shopname.getX() == playerLocationY ) {
            return true;
        } else {
            return false;
        }
    }
}
