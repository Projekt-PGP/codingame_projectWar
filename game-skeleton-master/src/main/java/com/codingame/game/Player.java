package com.codingame.game;
import java.util.ArrayList;

import com.codingame.gameengine.core.AbstractMultiplayerPlayer;

// Uncomment the line below and comment the line under it to create a Solo Game
// public class Player extends AbstractSoloPlayer {
public class Player extends AbstractMultiplayerPlayer {
	
	private static int playerX;
	private static int playerY;
	private static int currentPlace;
	private static ArrayList<Item> playerItems;
	
	private static int attack;
	private static int defence;
	private static int speedBonus;
	private static int harvestBonus;
	
	public Player(int x, int y) {
		playerX = x;
		playerY = y;
		attack = 10;
		defence = 10;
		speedBonus = 0;
		harvestBonus = 0;
		playerItems = new ArrayList<Item>();
		
	}
	
	
    @Override
    public int getExpectedOutputLines() {
        // Returns the number of expected lines of outputs for a player

        // TODO: Replace the returned value with a valid number. Most of the time the value is 1. 
        return 1;
    }


	public static int getCurrentPlace() {
		return currentPlace;
	}

	public static void setCurrentPlace(int currentPlace) {
		Player.currentPlace = currentPlace;
	}

	public static int getPlayerY() {
		return playerY;
	}

	public static void setPlayerY(int playerY) {
		Player.playerY = playerY;
	}

	public static int getPlayerX() {
		return playerX;
	}

	public static void setPlayerX(int playerX) {
		Player.playerX = playerX;
	}
}
