package Desserts;

public class Cookie  extends Desserts{
	/**
	 * Creates new Cookie Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Cookie(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "cookie";
	}
}
