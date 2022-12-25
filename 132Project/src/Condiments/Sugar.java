package Condiments;

public class Sugar extends Condiments{
	/**
	 * Creates new Sugar Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Sugar(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "sugar";
	}
}
