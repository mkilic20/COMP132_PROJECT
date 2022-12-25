package MainDishes;

public class Sushi extends MainDishes {
	/**
	 * Creates new Sushi Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Sushi(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "sushi";
	}
}
