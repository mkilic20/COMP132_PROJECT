package Condiments;

import MainPackage.Menu;

public class Condiments extends Menu{
	private double price;
	private int units;
	
	public Condiments(double price, int units) {
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
