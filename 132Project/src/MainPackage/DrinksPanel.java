package MainPackage;

@SuppressWarnings("serial")
public class DrinksPanel extends SuperPanel{
	//private final JLabel header;
	
	public int waterNum=0;
	public int cokeNum=0;
	public int juiceNum=0;
	public int teaNum=0;
	public int coffeeNum=0;
	
	/**
	 * Creates Panel for Drink Units
	 */
	public DrinksPanel(){
		super("DRINKS");
		unitDisplay("water", Test.stock.getWaterUnit(),"200 ml Pure Water",waterNum, 60, 200);
		unitDisplay("coke", Test.stock.getCokeUnit(), "500 ml Delicious Coke",cokeNum, 460, 200);
		unitDisplay("juice", Test.stock.getJuiceUnit(), "Fresh juice",juiceNum, 860, 200);
		unitDisplay("tea", Test.stock.getTeaUnit(), "Black tea",teaNum, 330, 400);
		unitDisplay("coffee", Test.stock.getCoffeeUnit(), "Hot Turkish coffee",coffeeNum, 730, 400);
	}
	
	/**
	 * Increases given unit by one
	 * @param n unit name that you want to increase
	 * @return units current order number
	 */
	protected int increaseUnit(String n) {
		switch(n) {
		case "water":
			DrinksPanel.this.waterNum++;
			return DrinksPanel.this.waterNum;
		case "coke":
			DrinksPanel.this.cokeNum++;
			return DrinksPanel.this.cokeNum;
		case "juice":
			DrinksPanel.this.juiceNum++;
			return DrinksPanel.this.juiceNum;
		case "tea":
			DrinksPanel.this.teaNum++;
			return DrinksPanel.this.teaNum;
		case "coffee":
			DrinksPanel.this.coffeeNum++;
			return DrinksPanel.this.coffeeNum;
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
		case "water":
			DrinksPanel.this.waterNum--;
			return DrinksPanel.this.waterNum;
		case "coke":
			DrinksPanel.this.cokeNum--;
			return DrinksPanel.this.cokeNum;
		case "juice":
			DrinksPanel.this.juiceNum--;
			return DrinksPanel.this.juiceNum;
		case "tea":
			DrinksPanel.this.teaNum--;
			return DrinksPanel.this.teaNum;
		case "coffee":
			DrinksPanel.this.coffeeNum--;
			return DrinksPanel.this.coffeeNum;
		}
		return 0;
	}
}
