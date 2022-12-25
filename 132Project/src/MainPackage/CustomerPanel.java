package MainPackage;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout; // specifies how components are arranged
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

import javax.swing.BorderFactory;
import javax.swing.JButton;

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
public class CustomerPanel extends JFrame {
	private JLabel header;
	private JButton mainDishesButton;
	private JButton dessertsButton;
	private JButton drinksButton;
	private JButton condimentsButton;
	private JButton soupsButton;
	private JButton order;
	/**
	 * Creates new CustomerPanel with Header, Five Menu Panel Buttons, and Order Button
	 */
	public CustomerPanel(){
		super("Menu");
		Border border = BorderFactory.createLineBorder(Color.black,1);
		
		header = new JLabel();
		header.setText("WELCOME TO OUR RESTAURANT");
		header.setFont(new Font("Calibri", Font.BOLD, 25));
		header.setPreferredSize(new Dimension(350,150));
		header.setOpaque(true);
		header.setBackground(Color.white);
		header.setBorder(border);
		add(header);
		
		mainDishesButton = new JButton("Main Dishes");
		mainDishesButton.setPreferredSize(new Dimension(150,50));
		mainDishesButton.setBackground(Color.orange);
		dessertsButton = new JButton("Desserts");
		dessertsButton.setPreferredSize(new Dimension(150,50));
		dessertsButton.setBackground(Color.orange);
		drinksButton = new JButton("Drinks");
		drinksButton.setPreferredSize(new Dimension(150,50));
		drinksButton.setBackground(Color.orange);
		condimentsButton = new JButton("Condiments");
		condimentsButton.setPreferredSize(new Dimension(150,50));
		condimentsButton.setBackground(Color.orange);
		soupsButton = new JButton("Soups");
		soupsButton.setPreferredSize(new Dimension(150,50));
		soupsButton.setBackground(Color.orange);
		
		add(mainDishesButton);
		add(dessertsButton);
		add(drinksButton);
		add(condimentsButton);
		add(soupsButton);
		
		drinksButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.drinksPanel.setVisible(true);
			}
		});
		condimentsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.condimentsPanel.setVisible(true);
			}
		});
		dessertsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.dessertsPanel.setVisible(true);
			}
		});
		mainDishesButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.mainDishesPanel.setVisible(true);
			}
		});
		soupsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.soupsPanel.setVisible(true);
			}
		});
		
		order = new JButton("Order");
		order.setPreferredSize(new Dimension(180,100));
		order.setFont(new Font("Calibri", Font.BOLD, 35));
		order.setBackground(Color.cyan);
		add(order);
		
		order.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
				OrderPrint orderPrint = new OrderPrint(Test.registerPanel.currentCustomer.getOrder());
				orderPrint.setSize(1000, 700);
				orderPrint.setVisible(true);
				orderPrint.setLayout(new FlowLayout());
				orderPrint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			}
		});
	}
	
}
	
	
	
	
	
	

