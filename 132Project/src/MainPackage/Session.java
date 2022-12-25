package MainPackage;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class Session implements Comparable<Session>{
	private String name;
	private int age;
	private int people;
	private LinkedHashMap<Menu,Integer> order;
	private double total;
	

	/**
	 * Creates new Session for a new Customer
	 * @param name Customer's name
	 * @param age Customer's age
	 * @param people Number of people considering sitting
	 */
	public Session(String name, int age, int people) {
		super();
		this.name = name;
		this.age = age;
		this.people = people;
		this.order = new LinkedHashMap<Menu, Integer>();
	}
	/**
	 * Increases Customer's given Menu's quantity wanted by one
	 * @param m Menu that its quantity will be increased
	 */
	public void increaseOrder(Menu m) {
		int count = order.containsKey(m) ? order.get(m) : 0;
		order.put(m, count + 1);
	}
	/**
	 * Decreases Customer's given Menu's quantity wanted by one
	 * @param m Menu that its quantity will be decrased
	 */
	public void decreaseOrder(Menu m) {
		int count = order.containsKey(m) ? order.get(m) : 0;
		if (count!=0) {
			order.put(m, count - 1);
		}
	}
	
	@Override
	/**
	 * New compare argument: First compares their age, if their ages are same then their total costs
	 */
	public int compareTo(Session o) {
		if (this.age>o.getAge()) {return -1;}
		else if (this.age<o.getAge()) { return 1;}
		else {
			if (this.total > o.getTotal()) {return 1;}
			else return -1;
		}

	}
	//Getters
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getPeople() {
		return people;
	}

	public LinkedHashMap<Menu, Integer> getOrder() {
		return order;
	}
	
	public double getTotal() {
		total=0;
		for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
		    Menu key = entry.getKey();
		    Integer value = entry.getValue();
		    total+=key.getPrice()*value;
		}
		return total;
	}

	
	
	
}
