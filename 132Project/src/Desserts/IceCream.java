package Desserts;

public class IceCream extends Desserts{
	/**
	 * Creates new Ice Cream Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public IceCream(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "icecream";
	}
}
