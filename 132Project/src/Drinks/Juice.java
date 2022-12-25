package Drinks;

public class Juice extends Drinks {
	/**
	 * Creates new Juice Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Juice(double price, int units) {
		super(price,units);
	}

	public String getName(){
		return "juice";
	}
}
