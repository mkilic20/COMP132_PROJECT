package Soups;

public class Chicken extends Soups {
	/**
	 * Creates new Chicken Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Chicken(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "chicken";
	}
}
