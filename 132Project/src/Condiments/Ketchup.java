package Condiments;

public class Ketchup extends Condiments{
	/**
	 * Creates new Ketchup Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Ketchup(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "ketchup";
	}
}
