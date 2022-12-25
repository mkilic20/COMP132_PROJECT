package MainDishes;

public class Pasta extends MainDishes {
	/**
	 * Creates new Pasta Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Pasta(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "pasta";
	}
}
