package Drinks;

public class Water extends Drinks{
	/**
	 * Creates new Water Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Water(double price, int units) {
		super(price, units);
	}
	
	public String getName(){
		return "water";
	}
}
