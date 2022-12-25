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
@SuppressWarnings("serial")
public class CondimentsPanel extends SuperPanel {
	
	public int ketchupNum=0;
	public int mayonnaiseNum=0;
	public int oilNum=0;
	public int saltNum=0;
	public int sugarNum=0;
	/**
	 * Creates Panel for Condiment Units
	 */
	public CondimentsPanel() {
		super("CONDIMENTS");
		// TODO Auto-generated constructor stub		
		unitDisplay("ketchup", Test.stock.getKetchupUnit(),"One Bottle Ketchup",ketchupNum, 60, 200);
		unitDisplay("mayonnaise", Test.stock.getMayonnaiseUnit(), "One Bottle Mayonnaise",mayonnaiseNum, 460, 200);
		unitDisplay("oil", Test.stock.getOilUnit(), "Fresh Oil",oilNum, 860, 200);
		unitDisplay("salt", Test.stock.getSaltUnit(), "10 gr Salt",saltNum, 330, 400);
		unitDisplay("sugar", Test.stock.getSugarUnit(), "10 gr Sugar",sugarNum, 730, 400);
	}

	/**
	 * Increases given unit by one
	 * @param n unit name that you want to increase
	 * @return units current order number
	 */
	protected int increaseUnit(String n) {
		switch(n) {
		case "ketchup":
			CondimentsPanel.this.ketchupNum++;
			return CondimentsPanel.this.ketchupNum;
		case "mayonnaise":
			CondimentsPanel.this.mayonnaiseNum++;
			return CondimentsPanel.this.mayonnaiseNum;
		case "oil":
			CondimentsPanel.this.oilNum++;
			return CondimentsPanel.this.oilNum;
		case "salt":
			CondimentsPanel.this.saltNum++;
			return CondimentsPanel.this.saltNum;
		case "sugar":
			CondimentsPanel.this.sugarNum++;
			return CondimentsPanel.this.sugarNum;
		}
		return 0;
	}
	
	/**
	 * Decreases given unit by one
	 * @param n unit name that you want to decrease
	 * @return units current order number
	 */
	protected int decreaseUnit(String n) {
		switch(n) {
		case "ketchup":
			CondimentsPanel.this.ketchupNum--;
			return CondimentsPanel.this.ketchupNum;
		case "mayonnaise":
			CondimentsPanel.this.mayonnaiseNum--;
			return CondimentsPanel.this.mayonnaiseNum;
		case "oil":
			CondimentsPanel.this.oilNum--;
			return CondimentsPanel.this.oilNum;
		case "salt":
			CondimentsPanel.this.saltNum--;
			return CondimentsPanel.this.saltNum;
		case "sugar":
			CondimentsPanel.this.sugarNum--;
			return CondimentsPanel.this.sugarNum;
		}
		return 0;
	}
	
}
