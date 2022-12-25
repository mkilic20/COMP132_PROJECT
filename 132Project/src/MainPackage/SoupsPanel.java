package MainPackage;


@SuppressWarnings("serial")
public class SoupsPanel extends SuperPanel{	
	public int tomatoNum=0;
	public int chickenNum=0;
	public int meatballNum=0;
	public int mushroomNum=0;
	public int fishNum=0;
	
	/**
	 * Creates Panel for Soup Units
	 */

	public SoupsPanel(){
		super("SOUPS");

		unitDisplay("tomato", Test.stock.getTomatoUnit(),"Hot Tomato Soup",tomatoNum, 60, 200);
		unitDisplay("chicken", Test.stock.getChickenUnit(), "Chicken Soup",chickenNum, 460, 200);
		unitDisplay("meatball", Test.stock.getMeatballUnit(), "Soup with Swedish Meatballs",meatballNum, 860, 200);
		unitDisplay("mushroom", Test.stock.getMushroomUnit(), "White Mushroom Soup",mushroomNum, 330, 400);
		unitDisplay("fish", Test.stock.getFishUnit(), "Fish Soup ",fishNum, 730, 400);
	}
	
	/**
	 * Increases given unit by one
	 * @param n unit name that you want to increase
	 * @return units current order number
	 */
	protected int increaseUnit(String n) {
		switch(n) {
		case "tomato":
			SoupsPanel.this.tomatoNum++;
			return SoupsPanel.this.tomatoNum;
		case "chicken":
			SoupsPanel.this.chickenNum++;
			return SoupsPanel.this.chickenNum;
		case "meatball":
			SoupsPanel.this.meatballNum++;
			return SoupsPanel.this.meatballNum;
		case "mushroom":
			SoupsPanel.this.mushroomNum++;
			return SoupsPanel.this.mushroomNum;
		case "fish":
			SoupsPanel.this.fishNum++;
			return SoupsPanel.this.fishNum;
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
		case "tomato":
			SoupsPanel.this.tomatoNum--;
			return SoupsPanel.this.tomatoNum;
		case "chicken":
			SoupsPanel.this.chickenNum--;
			return SoupsPanel.this.chickenNum;
		case "meatball":
			SoupsPanel.this.meatballNum--;
			return SoupsPanel.this.meatballNum;
		case "mushroom":
			SoupsPanel.this.mushroomNum--;
			return SoupsPanel.this.mushroomNum;
		case "fish":
			SoupsPanel.this.fishNum--;
			return SoupsPanel.this.fishNum;
		}
		return 0;
	}
	
}

