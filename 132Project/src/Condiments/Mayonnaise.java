package Condiments;

public class Mayonnaise extends Condiments{
	/**
	 * Creates new Mayonnaise Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Mayonnaise(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "mayonnaise";
	}
}
