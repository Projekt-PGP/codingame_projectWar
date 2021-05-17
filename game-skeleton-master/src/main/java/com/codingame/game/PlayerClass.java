package com.codingame.game;

import com.google.errorprone.annotations.Var;

import java.util.ArrayList;

public class PlayerClass {
	
	private static int playerX;
	private static int playerY;
	private static int currentPlace;
	private static ArrayList<Item> playerItems;
	
	private static int attack;
	private static int defence;
	private static int speedBonus;
	private static int harvestBonus;

	private int wood;
	private int stone;
	private int copper;
	private int cherrys;
	
	public PlayerClass(int x, int y) {
		playerX = x;
		playerY = y;
		attack = 10;
		defence = 10;
		speedBonus = 0;
		harvestBonus = 0;
		playerItems = new ArrayList<Item>();
	}

	public static int getCurrentPlace() {
		return currentPlace;
	}

	public static void setCurrentPlace(int currentPlace) {
		PlayerClass.currentPlace = currentPlace;
	}

	public static int getPlayerY() {
		return playerY;
	}

	public static void setPlayerY(int playerY) {
		PlayerClass.playerY = playerY;
	}

	public static int getPlayerX() {
		return playerX;
	}

	public static void setPlayerX(int playerX) {
		PlayerClass.playerX = playerX;
	}
	public static int getAttack() { return PlayerClass.attack; }

	public void calculateStats()
	{
		for (int i=0;i<playerItems.size();i++)
		{
			playerItems.get(i);
		}
	}
}
