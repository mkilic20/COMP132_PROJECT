package MainPackage;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public abstract class SuperPanel extends JFrame {
	private final JLabel header;
	protected JButton back;
	/**
	 * Creates Menu Panel for GUI
	 * @param name Sets the Panel Header Name
	 */
	public SuperPanel(String name) {
		super(name);
		
		Border border = BorderFactory.createLineBorder(Color.black,2);
		header = new JLabel();
		header.setText(name);
		header.setBounds(500,50,400,80);
		header.setVerticalAlignment(JLabel.CENTER);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setBorder(border);
		header.setBackground(Color.cyan);
		header.setOpaque(true);
		header.setFont(new Font("Calibri", Font.BOLD, 50));
		add(header);
		
		back = new JButton("Back");
		back.setBounds(10,10,80,30);
		add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.customerPanel.setVisible(true);
			}
		});
	}
	/**
	 * Displays the Unit Photo, Info, Price, Add and Remove Buttons on the Panel
	 * @param n Unit's name
	 * @param m Unit's itself
	 * @param info Information that will be demonstrated to user
	 * @param unitNum The quantity the customer wants from that product
	 * @param x x coordinate of the displayment
	 * @param y y coordinate of the displayment
	 */
	protected void unitDisplay(String n, Menu m, String info, int unitNum, int x, int y) {
		JLabel imageLabel = new JLabel();
		imageLabel.setBounds(x,y,160,160);
		
		Icon i = new ImageIcon(getClass().getResource("/Pictures/"+n+".png"));
		imageLabel.setIcon(i); // add icon to JLabel
		imageLabel.setOpaque(true);
		Border border = BorderFactory.createLineBorder(Color.black,1);
		imageLabel.setBorder(border);
		add(imageLabel);
		
		JLabel alertLabel = new JLabel(n+" is unavailable!");
		alertLabel.setBounds(x+190, y+60,250,50);
		alertLabel.setVisible(false);
		add(alertLabel);
		
		
		JLabel unitHeader = new JLabel(n.toUpperCase()+"  " + m.getPrice()+" $");
		unitHeader.setBounds(x+190,y-10,300,50);
		unitHeader.setFont(new Font("Calibri",Font.BOLD,20));
		add(unitHeader);
		
		if (unitNum==m.getUnits()) {
			imageLabel.setEnabled(false);
			alertLabel.setVisible(true);
		}
		
		JLabel unitInfo = new JLabel(info);
		unitInfo.setBounds(x+190,y+30,180,50);
		add(unitInfo);
		
		JButton unitDecrease = new JButton("-");
		unitDecrease.setBounds(x+170,y+100,50,50);
		add(unitDecrease);
		unitDecrease.setEnabled(false);
		
		JButton unitIncrease = new JButton("+");
		unitIncrease.setBounds(x+270,y+100,50,50);
		if (unitNum==m.getUnits()) {
			unitIncrease.setEnabled(false);
		}
		
		JLabel unitCount = new JLabel(""+unitNum);
		unitCount.setBounds(x+240,y+100,50,50);
		unitCount.setFont(new Font("Calibri",Font.BOLD,20));
		add(unitIncrease);
		add(unitCount);
		
		unitDecrease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int unitNum=decreaseUnit(n);
				Test.registerPanel.currentCustomer.decreaseOrder(m);
				unitCount.setText(String.valueOf(unitNum));
				if (unitNum==0) {
					unitDecrease.setEnabled(false);}
				if (unitNum<=m.getUnits()) {
					unitIncrease.setEnabled(true);
					alertLabel.setVisible(false);
					imageLabel.setEnabled(true);}
			}
		});
		unitIncrease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int unitNum=increaseUnit(n);
				Test.registerPanel.currentCustomer.increaseOrder(m);
				unitCount.setText(String.valueOf(unitNum));
				if (unitNum>0) {
					unitDecrease.setEnabled(true);}
				if (unitNum==m.getUnits()) {
					unitIncrease.setEnabled(false);
					alertLabel.setVisible(true);
					imageLabel.setEnabled(false);}
			}
		});
	}
	
	/**
	 * Increases given unit by one
	 * @param n unit name that you want to increase
	 * @return units current order number
	 */
	protected abstract int increaseUnit(String n);
	/**
	 * Decreases given unit by one
	 * @param n unit name that you want to decrease
	 * @return units current order number
	 */
	protected abstract int decreaseUnit(String n);
}
