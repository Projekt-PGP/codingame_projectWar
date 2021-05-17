package com.codingame.game;

public class Item {
	
	private static int attack;
	private static int defence;
	private static int speedBonus;
	private static int harvestBonus;
	private static int price;
	
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
	
	public static int getPrice() {
		return price;
	}
	
	public static void setPrice(int price) {
		Item.price = price;
	}

	public static int getHarvestBonus() {
		return harvestBonus;
	}

	public static void setHarvestBonus(int harvestBonus) {
		Item.harvestBonus = harvestBonus;
	}
	
	
	
	
	
}
