package Condiments;

public class Oil extends Condiments{
	/**
	 * Creates new Oil Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Oil(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "oil";
	}
}
