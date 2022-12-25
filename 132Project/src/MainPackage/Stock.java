package MainPackage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Condiments.Ketchup;
import Condiments.Mayonnaise;
import Condiments.Oil;
import Condiments.Salt;
import Condiments.Sugar;
import Desserts.Cake;
import Desserts.Candy;
import Desserts.Cookie;
import Desserts.IceCream;
import Desserts.Pudding;
import Drinks.Coffee;
import Drinks.Coke;
import Drinks.Juice;
import Drinks.Tea;
import Drinks.Water;
import MainDishes.Hamburger;
import MainDishes.Kebab;
import MainDishes.Pasta;
import MainDishes.Pizza;
import MainDishes.Sushi;
import Soups.Chicken;
import Soups.Fish;
import Soups.MeatBall;
import Soups.Mushroom;
import Soups.Tomato;
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
public class Stock {
	private static Kebab kebabUnit;
	private static Hamburger hamburgerUnit;
	private static Pasta pastaUnit;
	private static Pizza pizzaUnit;
	private static Sushi sushiUnit;
	private static Tomato tomatoUnit;
	private static Chicken chickenUnit;
	private static MeatBall meatballUnit;
	private static Mushroom mushroomUnit;
	private static Fish fishUnit;
	private static Ketchup ketchupUnit;
	private static Mayonnaise mayonnaiseUnit;
	private static Oil oilUnit;
	private static Salt saltUnit;
	private static Sugar sugarUnit;
	private static Cake cakeUnit;
	private static IceCream icecreamUnit;
	private static Candy candyUnit;
	private static Cookie cookieUnit;
	private static Pudding puddingUnit;
	private static Water waterUnit;
	private static Coke cokeUnit;
	private static Juice juiceUnit;
	private static Tea teaUnit;
	private static Coffee coffeeUnit;
	
	private int sixTable;
	private int twoTable;
	private ArrayList<Menu> unitList; 
	private String[] stringList = {"kebab","hamburger","pasta","pizza","sushi","tomato","chicken","meatball","mushroom","fish","ketchup","mayonnaise",
			"oil","salt","sugar","cake","icecream","candy","cookie","pudding","water","coke","juice","tea","coffee"};
	/**
	 * Creates new Stock unit
	 * Updates stock data each time it's been created
	 */
	public Stock(){
		getUnits();
		getTables();
		unitList = new ArrayList<Menu>(0);
		Menu[] arr = {kebabUnit,hamburgerUnit,pastaUnit,pizzaUnit,sushiUnit,tomatoUnit,chickenUnit,meatballUnit,mushroomUnit,fishUnit,ketchupUnit,mayonnaiseUnit,
			oilUnit,saltUnit,sugarUnit,cakeUnit,icecreamUnit,candyUnit,cookieUnit,puddingUnit,waterUnit,cokeUnit,juiceUnit,teaUnit,coffeeUnit};
		Collections.addAll(unitList, arr);
				
	}
	/**
	 * For given LinkedHashMap every Menu Item will decrease by its value and data.txt will be modified for next customer
	 * @param t LinkedHashMap with Menus that will be decreased as keys and subtrahend  as value
	 */
	public void decreaseUnits(LinkedHashMap<Menu,Integer> t) {
		Menu[] foodArr= {kebabUnit,hamburgerUnit,pastaUnit,pizzaUnit,sushiUnit,tomatoUnit,chickenUnit,meatballUnit,mushroomUnit,fishUnit,ketchupUnit,mayonnaiseUnit,
				oilUnit,saltUnit,sugarUnit,cakeUnit,icecreamUnit,candyUnit,cookieUnit,puddingUnit,waterUnit,cokeUnit,juiceUnit,teaUnit,coffeeUnit};
		try {
			Formatter output = new Formatter("data.txt");
			for (int i = 0; i < foodArr.length; i++) {
				if (!t.containsKey(foodArr[i])) {
					output.format("%s %,.2f %d"+System.getProperty("line.separator"),foodArr[i].getName(),foodArr[i].getPrice(),foodArr[i].getUnits());
					
				}
				else if(t.containsKey(foodArr[i])){
					foodArr[i].setUnits(foodArr[i].getUnits()-t.get(foodArr[i]));
					output.format("%s %,.2f %d"+System.getProperty("line.separator"),foodArr[i].getName(),foodArr[i].getPrice(),foodArr[i].getUnits());
				}}
			output.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}
	
	/**
	 * For given Table type, Stock's table variable will decrease by one and tables.txt will be modified for next customer
	 * @param n Table Type (Integer)
	 */
	public void decreaseTable(int n) {
		try {
			Formatter output = new Formatter("tables.txt");
			if (n == 6) {
				this.sixTable--;
				output.format("%d %d"+System.getProperty("line.separator"), 6, sixTable);
				output.format("%d %d"+System.getProperty("line.separator"), 2, twoTable);
			}
			else if (n == 2) {
				this.twoTable--;
				output.format("%d %d"+System.getProperty("line.separator"), 6, sixTable);
				output.format("%d %d"+System.getProperty("line.separator"), 2, twoTable);
			}
			output.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	

	/**
	 * Reads the data form tables.txt and changes the Stock's table variables
	 */
	private void getTables() {
		try {
			Scanner scan = new Scanner(Paths.get("tables.txt"));
			Pattern p = Pattern.compile("(\\d+)\\s(\\d+)");
			while(scan.hasNextLine()) {
				Matcher m = p.matcher(scan.nextLine());
				while(m.find()) {
					switch(m.group(1)) {
					case "6":
						sixTable = Integer.valueOf(m.group(2));
						break;
					case "2":
						twoTable = Integer.valueOf(m.group(2));
						break;
				}
			}
		}}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Reads the data form data.txt and creates new unit for every valid units
	 */
	private void getUnits() {
		try {
			Scanner scan = new Scanner(Paths.get("data.txt"));
			Pattern p = Pattern.compile("(\\w+)\\s(\\d+\\.\\d+)\\s(\\d+)");
			while(scan.hasNextLine()) {
				Matcher m = p.matcher(scan.nextLine());
				while(m.find()) {
					switch(m.group(1)) {
					case "kebab":
						kebabUnit = new Kebab(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "hamburger":
						hamburgerUnit = new Hamburger(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "pasta":
						pastaUnit = new Pasta(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "pizza":
						pizzaUnit = new Pizza(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "sushi":
						sushiUnit = new Sushi(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "ketchup":
						ketchupUnit = new Ketchup(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "mayonnaise":
						mayonnaiseUnit = new Mayonnaise(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "oil":
						oilUnit = new Oil(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "salt":
						saltUnit = new Salt(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "sugar":
						sugarUnit = new Sugar(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "tomato":
						tomatoUnit = new Tomato(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "chicken":
						chickenUnit = new Chicken(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "meatball":
						meatballUnit = new MeatBall(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "mushroom":
						mushroomUnit = new Mushroom(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "fish":
						fishUnit = new Fish(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "cake":
						cakeUnit = new Cake(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "icecream":
						icecreamUnit = new IceCream(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "candy":
						candyUnit = new Candy(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "cookie":
						cookieUnit = new Cookie(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "pudding":
						puddingUnit = new Pudding(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "water":
						waterUnit = new Water(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "coke":
						cokeUnit = new Coke(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "juice":
						juiceUnit = new Juice(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "tea":
						teaUnit = new Tea(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					case "coffee":
						coffeeUnit = new Coffee(Double.valueOf(m.group(2)), Integer.valueOf(m.group(3)));
						break;
					}
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Getters
	
	public int getSixTable() {
		return sixTable;
	}

	public int getTwoTable() {
		return twoTable;
	}
	
	public ArrayList<Menu> getUnitList() {
		return unitList;
	}

	public Kebab getKebabUnit() {
		return kebabUnit;
	}


	public Hamburger getHamburgerUnit() {
		return hamburgerUnit;
	}


	public Pasta getPastaUnit() {
		return pastaUnit;
	}


	public Pizza getPizzaUnit() {
		return pizzaUnit;
	}


	public Sushi getSushiUnit() {
		return sushiUnit;
	}


	public Tomato getTomatoUnit() {
		return tomatoUnit;
	}


	public Chicken getChickenUnit() {
		return chickenUnit;
	}


	public MeatBall getMeatballUnit() {
		return meatballUnit;
	}


	public Mushroom getMushroomUnit() {
		return mushroomUnit;
	}


	public Fish getFishUnit() {
		return fishUnit;
	}


	public Ketchup getKetchupUnit() {
		return ketchupUnit;
	}


	public Mayonnaise getMayonnaiseUnit() {
		return mayonnaiseUnit;
	}


	public Oil getOilUnit() {
		return oilUnit;
	}


	public Salt getSaltUnit() {
		return saltUnit;
	}


	public Sugar getSugarUnit() {
		return sugarUnit;
	}


	public Cake getCakeUnit() {
		return cakeUnit;
	}


	public IceCream getIcecreamUnit() {
		return icecreamUnit;
	}


	public Candy getCandyUnit() {
		return candyUnit;
	}


	public Cookie getCookieUnit() {
		return cookieUnit;
	}


	public Pudding getPuddingUnit() {
		return puddingUnit;
	}


	public Water getWaterUnit() {
		return waterUnit;
	}


	public Coke getCokeUnit() {
		return cokeUnit;
	}


	public Juice getJuiceUnit() {
		return juiceUnit;
	}


	public Tea getTeaUnit() {
		return teaUnit;
	}

	public Coffee getCoffeeUnit() {
		return coffeeUnit;
	}
	public String[] getStringList() {
		return stringList;
	}
}
