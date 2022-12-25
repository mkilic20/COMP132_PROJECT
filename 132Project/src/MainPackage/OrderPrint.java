package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
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
public class OrderPrint extends JFrame{
	private double total=0;
	/**
	 * Creates new OrderPrint and Displays Ordered Units and quantities
	 * @param order LinkedHashMap with Menus that is ordered as keys and quantities as value
	 */
	public OrderPrint(LinkedHashMap<Menu,Integer> order) {
		super("PRINTED ORDER");

		JButton back = new JButton("Back");
		back.setBounds(10,10,80,30);
		add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.customerPanel.setVisible(true);
			}
		});
		for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
		    Menu key = entry.getKey();
		    Integer value = entry.getValue();
		    total+=key.getPrice()*value;
		    addLabel(key,value);
		}
		
		Border border = BorderFactory.createLineBorder(Color.black,2);
		JLabel totalLabel = new JLabel("TOTAL PRICE = "+total+" $");
		totalLabel.setBorder(border);
		totalLabel.setBackground(Color.yellow);
		totalLabel.setOpaque(true);
		totalLabel.setPreferredSize(new Dimension(250,50));
		totalLabel.setFont(new Font("Calibri",Font.BOLD,20));
		add(totalLabel);
		
		JButton close = new JButton("Finish");
		add(close);
		close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Test.managerPanel.addSession(Test.registerPanel.currentCustomer);
				dispose();
				Test.customerPanel.dispose();
				Test.registerPanel.dispose();
				Test.drinksPanel.dispose();
				Test.condimentsPanel.dispose();
				Test.dessertsPanel.dispose();
				Test.mainDishesPanel.dispose();
				Test.soupsPanel.dispose();
				Test.registerPanel.dispose();
				Test.stock = new Stock();
				Test.generateNewCustomer();
			}
		});
	}
	/**
	 * Add new Label for each Menu item
	 * @param k Menu item
	 * @param v Quantity wanted
	 */
	private void addLabel(Menu k, Integer v) {
		JLabel imageLabel = new JLabel();	
		Icon i = new ImageIcon(getClass().getResource("/Pictures/"+k.getName()+".png"));
		imageLabel.setIcon(i); // add icon to JLabel
		imageLabel.setOpaque(true);
		Border border = BorderFactory.createLineBorder(Color.black,1);
		imageLabel.setBorder(border);
		imageLabel.setText(k.getName().toUpperCase()+"  " + k.getPrice()+" $ X "+v+" = "+v*k.getPrice());
		imageLabel.setFont(new Font("Calibri",Font.BOLD,15));
		imageLabel.setVerticalTextPosition(JLabel.BOTTOM);
		imageLabel.setHorizontalTextPosition(JLabel.CENTER);
		add(imageLabel);
	}
}
