package Drinks;

import MainPackage.Menu;

public class Drinks extends Menu{
	private double price;
	private int units;
	
	public Drinks(double price, int units) {
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
