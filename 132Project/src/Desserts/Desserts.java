package Desserts;

import MainPackage.Menu;

public class Desserts extends Menu{
	private double price;
	private int units;
	
	public Desserts(double price, int units) {
		super(price,units);
		this.price = price;
		this.units = units;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}
}

