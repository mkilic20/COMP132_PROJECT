package Soups;

public class Mushroom extends Soups {
	/**
	 * Creates new Mushroom Soup Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Mushroom(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "mushroom";
	}
}
