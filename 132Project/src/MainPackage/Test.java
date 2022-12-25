package MainPackage;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
public class Test {
	public static CustomerPanel customerPanel;
	public static DrinksPanel drinksPanel;
	public static CondimentsPanel condimentsPanel;
	public static DessertsPanel dessertsPanel;
	public static MainDishesPanel mainDishesPanel;
	public static SoupsPanel soupsPanel;
	public static RegisterPanel registerPanel;
	public static Stock stock;
	public static ManagerPanel managerPanel;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		generateNewCustomer();
		
		managerPanel = new ManagerPanel();
		managerPanel.setLayout(new BorderLayout());
		managerPanel.setSize(1280,720);
		managerPanel.setVisible(true);
		managerPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Generates the panels, Refreshes the stock for new Customer
	 */
	public static void generateNewCustomer() {
		stock = new Stock();
		registerPanel = new RegisterPanel();
		registerPanel.setSize(500, 500);
		registerPanel.setVisible(true);
		registerPanel.setLayout(new FlowLayout());
		registerPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		customerPanel = new CustomerPanel();

		customerPanel.setSize(500, 500);
		customerPanel.setVisible(false);
		customerPanel.setLayout(new FlowLayout());
		customerPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		drinksPanel = new DrinksPanel();
		drinksPanel.setSize(1280,720);
		drinksPanel.setVisible(false);
		drinksPanel.setLayout(new BorderLayout());
		drinksPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		condimentsPanel = new CondimentsPanel();
		condimentsPanel.setSize(1280,720);
		condimentsPanel.setVisible(false);
		condimentsPanel.setLayout(new BorderLayout());
		condimentsPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		dessertsPanel = new DessertsPanel();
		dessertsPanel.setSize(1280,720);
		dessertsPanel.setVisible(false);
		dessertsPanel.setLayout(new BorderLayout());
		dessertsPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainDishesPanel = new MainDishesPanel();
		mainDishesPanel.setSize(1280,720);
		mainDishesPanel.setVisible(false);
		mainDishesPanel.setLayout(new BorderLayout());
		mainDishesPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		soupsPanel = new SoupsPanel();
		soupsPanel.setSize(1280,720);
		soupsPanel.setVisible(false);
		soupsPanel.setLayout(new BorderLayout());
		soupsPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
