package MainDishes;

public class Pizza extends MainDishes {
	/**
	 * Creates new Pizza Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Pizza(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "pizza";
	}
}
