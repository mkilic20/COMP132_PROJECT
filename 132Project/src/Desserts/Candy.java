package Desserts;

public class Candy  extends Desserts{
	/**
	 * Creates new Candy Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Candy(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "candy";
	}
}
