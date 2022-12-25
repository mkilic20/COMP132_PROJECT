package MainPackage;
/* *********** Pledge of Honor ***************************************************************************
* I hereby certify that I have completed this programming project on my own
* without any help from anyone else. The effort in the project thus belongs
* completely to me. I did not search for a solution, or I did not consult to any program
* written by other students or did not copy any program from other sources. I read and
* followed the guidelines provided in the project description.
*
* READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
* SIGNATURE: <MEHMET EREN KILIC, 76621>
*
************************************************************************************************************/
public class Menu {
	private double price;
	private int units;
	/**
	 * Creates new Menu Item with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Menu(double price, int units) {
		this.price = price;
		this.units = units;
	}
	/**
	 * Gives the name of the item
	 * @return Name of the item (String)
	 */
	public String getName(){
		return "menu";
	}
	/**
	 * Gives the price of the item
	 * @return Price of the item (double)
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Sets the Item's price
	 * @param price New Price input
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * Gives the unit number of the item
	 * @return Unit number of the item (int)
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * Sets the Item's unit number
	 * @param price New unit input
	 */
	public void setUnits(int units) {
		this.units = units;
	}
}
