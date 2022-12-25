package MainPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
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
public class ManagerPanel extends JFrame {
	private ArrayList<Session> sessions;
	private JTextArea textArea;
	private JTextArea textArea2;
	private JTextArea textArea3;
	private JLabel alertLabel;
	/**
	 * Creates new ManagerPanel that you can access Sessions, Stock list, Table list, and Sold Items
	 */
	public ManagerPanel(){
		super("Manager Panel");
		this.sessions = new ArrayList<Session>();
		Collections.sort(sessions);
		displaySessions();
		updateAlertLabel();
	}
	/**
	 * Displays Session Button and JTextAreas 
	 */
	private void displaySessions() {
		Border border = BorderFactory.createLineBorder(Color.black,1);
		JLabel header = new JLabel();
		
		
		header.setText("Manager Panel");
		header.setBounds(500,15,250,80);
		header.setVerticalAlignment(JLabel.CENTER);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setBorder(border);
		header.setBackground(Color.cyan);
		header.setOpaque(true);
		header.setFont(new Font("Calibri", Font.BOLD, 30));
		add(header);
		
		JButton sessionsButton = new JButton("Session Panel");
		sessionsButton.setBounds(50,150,200,100);
		sessionsButton.setFont(new Font("Calibri", Font.BOLD, 25));
		add(sessionsButton);
		
		sessionsButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SessionsPanel sesPanel = new SessionsPanel(sessions);
				sesPanel.setLayout(new BorderLayout());
				sesPanel.setSize(1280,720);
				sesPanel.setVisible(true);
				sesPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		
		textArea = new JTextArea("ads");
		textArea.setBounds(400,150,200,450);
		add(textArea);
		textArea.setLineWrap(true);
	    textArea.setEditable(false);
	    textArea.setVisible(true);
	    textArea.setText(getStock());
	    
	    textArea2 = new JTextArea("ads");
		textArea2.setBounds(700,150,200,450);
		add(textArea2);
		textArea2.setLineWrap(true);
	    textArea2.setEditable(false);
	    textArea2.setVisible(true);
	    textArea2.setText(getTotalOrders());
	    
	    textArea3 = new JTextArea("ads");
	    textArea3.setBounds(50,400,200,200);
		add(textArea3);
		textArea3.setLineWrap(true);
		textArea3.setEditable(false);
		textArea3.setVisible(true);
		textArea3.setText(getTables());
		
		alertLabel = new JLabel();
		alertLabel.setBounds(50,275,200,100);
		add(alertLabel);
		alertLabel.setBorder(border);
		alertLabel.setOpaque(true);
		alertLabel.setBackground(Color.red);
		alertLabel.setVisible(false);
	}
	/**
	 * Adds a new Session to session list of the ManagerPanel
	 * @param s
	 */
	public void addSession(Session s) {
		sessions.add(s);
		Collections.sort(sessions);
		updateTotalOrderText();
	}
	/**
	 * Gets stock information from Test's current stock unit and return string version to display 
	 * @return Stock information to display
	 */
	private String getStock() {
		ArrayList<Menu> tempArr= Test.stock.getUnitList();
		String tempStr = "Total Stocks:"+System.getProperty("line.separator");
		int sum=0;
		for (Menu m:tempArr) {
			tempStr= tempStr + m.getName()+": "+m.getUnits()+" units, "+m.getPrice()+"$"+System.getProperty("line.separator");
			sum+=m.getUnits();
		}
		return tempStr+System.getProperty("line.separator")+"Total Units: "+sum;
	}
	/**
	 * Gets the quantity the customer wants from each product information from Test's current stock unit and return string version to display 
	 * @return Quantity sold information to display
	 */
	private String getTotalOrders() {
		String[] tempArr= Test.stock.getStringList();
		String tempStr = "Total Units Ordered By Customers:"+System.getProperty("line.separator");
		int tempInt = 0;
		double revenue=0;
		for (String m:tempArr) {
			tempInt = 0;
			for (Session s:sessions) {
				boolean b=false;
				for (Menu n:s.getOrder().keySet() ) {
					if (n.getName().equals(m)) {
						b=true;
					}
					if(b) {
						tempInt+=s.getOrder().get(n);
					}
				}	
			}
			ArrayList<Menu> menuArr= Test.stock.getUnitList();
			double price=0;
			for (Menu k:menuArr) {
				if (k.getName().equals(m)) {
					price = k.getPrice();
				}
			}
			tempStr= tempStr + m+": "+tempInt+" units sold, "+price+"$"+System.getProperty("line.separator");
			revenue+=tempInt*price;
		}
		return tempStr+System.getProperty("line.separator")+"Total Revenue: "+revenue+"$";
	}

	/**
	 * Gets table information from Test's current stock unit and return string version to display 
	 * @return Table information to display
	 */
	private String getTables() {
		String tempStr = "Empty Tables:"+System.getProperty("line.separator");
		tempStr+="Two Chairs Tables: "+Test.stock.getTwoTable()+System.getProperty("line.separator");
		tempStr+="Six Chairs Tables: "+Test.stock.getSixTable()+System.getProperty("line.separator");
		
		return tempStr;
	}
	/**
	 * updates the Stock Text Area	
	 */
	public void updateStockText() {
		textArea.setText(getStock());
	}
	/**
	 * updates the Total Orders Text Area	
	 */
	public void updateTotalOrderText() {
		textArea2.setText(getTotalOrders());
	}
	/**
	 * updates the Table Text Area	
	 */
	public void updateTableText() {
		textArea3.setText(getTables());
	}
	/**
	 * updates the Alert Label
	 */
	public void updateAlertLabel() {
		if (Test.stock.getTwoTable()==0) {
			alertLabel.setText("Two Chairs Tables are Out of Stock");
			alertLabel.setVisible(true);
		}
		if (Test.stock.getSixTable()==0) {
			alertLabel.setText("Six Chairs Tables are Out of Stock");
			alertLabel.setVisible(true);
		}
		if ((Test.stock.getTwoTable()==0)&&(Test.stock.getSixTable()==0)) {
			alertLabel.setText("All tables are full");
			alertLabel.setVisible(true);
		}
		if ((Test.stock.getTwoTable()!=0) && (Test.stock.getSixTable()!=0)){
			alertLabel.setVisible(false);
		}
		
	}
}
