package MainPackage;


@SuppressWarnings("serial")
public class MainDishesPanel extends SuperPanel {
	
	public int kebabNum=0;
	public int hamburgerNum=0;
	public int pastaNum=0;
	public int pizzaNum=0;
	public int sushiNum=0;
	
	/**
	 * Creates Panel for MainDish Units
	 */
	public MainDishesPanel() {
		super("MAIN DISHES");
		// TODO Auto-generated constructor stub
		
		unitDisplay("kebab", Test.stock.getKebabUnit(),"Delicious Turkish Kebab",kebabNum, 60, 200);
		unitDisplay("hamburger", Test.stock.getHamburgerUnit(), "Steak Hamburger",hamburgerNum, 460, 200);
		unitDisplay("pasta", Test.stock.getPastaUnit(), "Milanese pasta",pastaNum, 860, 200);
		unitDisplay("pizza", Test.stock.getPizzaUnit(), "Sicilian Mozarello Pizza",pizzaNum, 330, 400);
		unitDisplay("sushi", Test.stock.getSushiUnit(), "Japanese Cooked Sushi",sushiNum, 730, 400);
	}

	/**
	 * Increases given unit by one
	 * @param n unit name that you want to increase
	 * @return units current order number
	 */
	protected int increaseUnit(String n) {
		switch(n) {
		case "kebab":
			MainDishesPanel.this.kebabNum++;
			return MainDishesPanel.this.kebabNum;
		case "hamburger":
			MainDishesPanel.this.hamburgerNum++;
			return MainDishesPanel.this.hamburgerNum;
		case "pasta":
			MainDishesPanel.this.pastaNum++;
			return MainDishesPanel.this.pastaNum;
		case "pizza":
			MainDishesPanel.this.pizzaNum++;
			return MainDishesPanel.this.pizzaNum;
		case "sushi":
			MainDishesPanel.this.sushiNum++;
			return MainDishesPanel.this.sushiNum;
		}
		return 0;
	}
	
	protected int decreaseUnit(String n) {
		switch(n) {
		case "kebab":
			MainDishesPanel.this.kebabNum--;
			return MainDishesPanel.this.kebabNum;
		case "hamburger":
			MainDishesPanel.this.hamburgerNum--;
			return MainDishesPanel.this.hamburgerNum;
		case "pasta":
			MainDishesPanel.this.pastaNum--;
			return MainDishesPanel.this.pastaNum;
		case "pizza":
			MainDishesPanel.this.pizzaNum--;
			return MainDishesPanel.this.pizzaNum;
		case "sushi":
			MainDishesPanel.this.sushiNum--;
			return MainDishesPanel.this.sushiNum;
		}
		return 0;
	}
	/**
	 * Decreases given unit by one
	 * @param n unit name that you want to decrease
	 * @return units current order number
	 */
}