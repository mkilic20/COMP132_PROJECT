package Soups;

public class Fish extends Soups {
	/**
	 * Creates new Fish Soup Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Fish(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "fish";
	}
}
