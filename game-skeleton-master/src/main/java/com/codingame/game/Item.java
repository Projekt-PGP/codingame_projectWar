package com.codingame.game;

public class Item {
	
	protected static int attack;
	protected static int defence;
	protected static int speedBonus;
	protected static int stoneHarvestBonus;
	protected static int woodHarvestBonus;


	protected static int woodNeeded;
	protected static int stoneNeeded;
	protected static int cherriesNeeded;
	protected static int copperNeeded;
	
	public static int getAttack() {
		return attack;
	}
	
	public static void setAttack(int attack) {
		Item.attack = attack;
	}
	
	public static int getDefence() {
		return defence;
	}
	
	public static void setDefence(int defence) {
		Item.defence = defence;
	}
	
	public static int getSpeedBonus() {
		return speedBonus;
	}
	public static void setSpeedBonus(int speedBonus) {
		Item.speedBonus = speedBonus;
	}

	public static int getHarvestBonus() {
		return stoneHarvestBonus;
	}

	public static void setHarvestBonus(int harvestBonus) {
		Item.stoneHarvestBonus = harvestBonus;
	}

}
