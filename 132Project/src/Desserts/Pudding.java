package Desserts;

public class Pudding extends Desserts{
	/**
	 * Creates new Pudding Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Pudding(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "pudding";
	}
}
