package MainDishes;
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
public class Kebab extends MainDishes {
	/**
	 * Creates new Kebab Unit with given price and units
	 * @param price The price of the item
	 * @param units The units of the item
	 */
	public Kebab(double price, int units) {
		super(price, units);
	}
	public String getName(){
		return "kebab";
	}
}
