package Desserts;

public class Cake extends Desserts {
	/**
	 * Creates new Cake Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Cake(double price, int units) {
		super(price,units);
	}
	public String getName(){
		return "cake";
	}
}
