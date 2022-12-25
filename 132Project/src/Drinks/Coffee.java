package Drinks;

public class Coffee extends Drinks {
	/**
	 * Creates new Coffee Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Coffee(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "coffee";
	}
}
