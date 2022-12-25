package Condiments;

public class Salt extends Condiments{
	/**
	 * Creates new Salt Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Salt(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "salt";
	}
}
