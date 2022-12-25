package MainDishes;

public class Hamburger extends MainDishes {
	/**
	 * Creates new Hamburger Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Hamburger(double price, int units) {
		super(price, units);
	}
	
	public String getName(){
		return "hamburger";
	}
}
