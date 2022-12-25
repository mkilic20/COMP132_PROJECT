package Soups;

public class MeatBall extends Soups {
	/**
	 * Creates new MeatBall Soup Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public MeatBall(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "meatball";
	}
}
