package com.codingame.game;

import java.util.ArrayList;

public class PlayerClass {
	
	private static int playerX;
	private static int playerY;
	private static int currentPlace;
	private static ArrayList<Item> playerItems;
	
	private static int attack;
	protected int defence;
	private static int speedBonus;
	protected int stoneHarvest;
	protected int woodHarvest;
	protected int cherriesHarvest;
	protected int copperHarvest;

	protected int wood;
	protected int stone;
	protected int copper;
	protected int cherries;

	public int access; // 0 Craft 1 Wood 2 Stone 3 Copper 4 Cherries
	
	public PlayerClass(int x, int y) {
		playerX = x;
		playerY = y;
		attack = 10;
		defence = 10;
		speedBonus = 0;
		stoneHarvest = 3;
		woodHarvest = 3;
		cherriesHarvest = 5;
		copperHarvest = 1;
		wood = 0;
		stone = 0;
		copper = 0;
		cherries = 0;
		access = 0;
		playerItems = new ArrayList<Item>();
	}

	public static int getCurrentPlace() {
		return currentPlace;
	}

	public static void setCurrentPlace(int currentPlace) {
		PlayerClass.currentPlace = currentPlace;
	}

	public int getPlayerY() {
		return playerY;
	}

	public static void setPlayerY(int playerY) {
		PlayerClass.playerY = playerY;
	}

	public int getPlayerX() {
		return playerX;
	}

	public static void setPlayerX(int playerX) {
		PlayerClass.playerX = playerX;
	}

	public static int getAttack() { return PlayerClass.attack; }

	public void addItem(Item item) {
		playerItems.add(item);
	}
}
