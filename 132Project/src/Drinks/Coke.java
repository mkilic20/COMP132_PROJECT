package Drinks;

public class Coke extends Drinks {
	/**
	 * Creates new Coke with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Coke(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "coke";
	}
}
