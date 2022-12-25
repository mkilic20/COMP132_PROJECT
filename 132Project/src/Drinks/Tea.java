package Drinks;

public class Tea extends Drinks{
	/**
	 * Creates new Tea Item with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Tea(double price, int units) {
		super(price,units);
	}
	
	public String getName(){
		return "tea";
	}
}
