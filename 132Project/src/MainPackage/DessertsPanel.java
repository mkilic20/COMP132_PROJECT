package MainPackage;

@SuppressWarnings("serial")
public class DessertsPanel extends SuperPanel {
	
	public int cakeNum=0;
	public int icecreamNum=0;
	public int candyNum=0;
	public int cookieNum=0;
	public int puddingNum=0;
	/**
	 * Creates Panel for Dessert Units
	 */
	public DessertsPanel() {
		super("DESSERTS");
		// TODO Auto-generated constructor stub		
		unitDisplay("cake", Test.stock.getCakeUnit(),"Delicious One Piece of Cake",cakeNum, 60, 200);
		unitDisplay("icecream", Test.stock.getIcecreamUnit(), "Three Ice Cream Rolls",icecreamNum, 460, 200);
		unitDisplay("candy", Test.stock.getCandyUnit(), "Various Candies",candyNum, 860, 200);
		unitDisplay("cookie", Test.stock.getCookieUnit(), "Two Big Cookies",cookieNum, 330, 400);
		unitDisplay("pudding", Test.stock.getPuddingUnit(), "Chocolate Pudding",puddingNum, 730, 400);
	}

	/**
	 * Increases given unit by one
	 * @param n unit name that you want to increase
	 * @return units current order number
	 */
	protected int increaseUnit(String n) {
		switch(n) {
		case "cake":
			DessertsPanel.this.cakeNum++;
			return DessertsPanel.this.cakeNum;
		case "icecream":
			DessertsPanel.this.icecreamNum++;
			return DessertsPanel.this.icecreamNum;
		case "candy":
			DessertsPanel.this.candyNum++;
			return DessertsPanel.this.candyNum;
		case "cookie":
			DessertsPanel.this.cookieNum++;
			return DessertsPanel.this.cookieNum;
		case "pudding":
			DessertsPanel.this.puddingNum++;
			return DessertsPanel.this.puddingNum;
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
		case "cake":
			DessertsPanel.this.cakeNum--;
			return DessertsPanel.this.cakeNum;
		case "icecream":
			DessertsPanel.this.icecreamNum--;
			return DessertsPanel.this.icecreamNum;
		case "candy":
			DessertsPanel.this.candyNum--;
			return DessertsPanel.this.candyNum;
		case "cookie":
			DessertsPanel.this.cookieNum--;
			return DessertsPanel.this.cookieNum;
		case "pudding":
			DessertsPanel.this.puddingNum--;
			return DessertsPanel.this.puddingNum;
		}
		return 0;
	}
	
	
}