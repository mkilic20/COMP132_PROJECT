package MainPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BorderFactory;
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
public class SessionsPanel extends JFrame{
	private ArrayList<Session> sessions;
	private JLabel header;
	/**
	 * Creates Session Panel that displays all active sessions
	 * User can increase or decrease order units and accept or decline the orders of the sessions
	 * @param sessions ArrayList of Sessions
	 */
	public SessionsPanel(ArrayList<Session> sessions) {
		super("SESSIONS");
		this.sessions = sessions;
		
		Border border = BorderFactory.createLineBorder(Color.black,1);
		header = new JLabel();
		header.setText("sessions");
		header.setBounds(500,15,250,80);
		header.setVerticalAlignment(JLabel.CENTER);
		header.setHorizontalAlignment(JLabel.CENTER);
		header.setBorder(border);
		header.setBackground(Color.cyan);
		header.setOpaque(true);
		header.setFont(new Font("Calibri", Font.BOLD, 50));
		add(header);
		displaySessions();
		
		JButton back = new JButton("Back");
		back.setBounds(10,10,80,30);
		add(back);
		back.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Test.managerPanel.setVisible(true);
			}
		});
	}
	/**
	 * Displays each sessions interface
	 */
	private void displaySessions() {
		if (this.sessions != null) {
			int a=100;
			int y=120;
			for(int i=0;i<sessions.size();i++) {
				int x=10;
				JLabel sessionName = new JLabel("Name: "+sessions.get(i).getName() +" Age: "+ sessions.get(i).getAge()+" Cost: "+sessions.get(i).getTotal());
				sessionName.setBounds(10,a,500,20);
				add(sessionName);
				JLabel costLabel = new JLabel(" Cost: "+sessions.get(i).getTotal());
				costLabel.setBounds(250,a,500,20);
				JButton accept = new JButton("Accept");
				accept.setBackground(Color.green);
				accept.setBounds(350,a,80,20);
				add(accept);
				JButton decline = new JButton("Decline");
				decline.setBackground(Color.red);
				decline.setBounds(460,a,80,20);
				add(decline);
				JLabel status= new JLabel("status");
				status.setBounds(600,a,80,20);
				status.setVisible(false);
				add(status);
				a+=100;
				Session tempSes= sessions.get(i);
				accept.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						status.setText("Accepted");
						status.setVisible(true);
						Test.stock.decreaseUnits(tempSes.getOrder());
						Test.managerPanel.updateStockText();
					}
				});
				decline.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						status.setText("Declined");
						status.setVisible(true);
						sessions.remove(tempSes);
					}
				});
				for (Map.Entry<Menu, Integer> entry : sessions.get(i).getOrder().entrySet()) {
				    Menu key = entry.getKey();
				    Integer value = entry.getValue();
				    addButton(sessions.get(i),key,value,x,y,sessionName);
				    x+= 250;
				}
				x-=200;
				y+=100;
			}
		}
		else System.out.println("no session");
	}
	/**
	 * Adds Button for interface
	 * @param s Session Unit
	 * @param m Menu Unit
	 * @param k Unit Number
	 * @param x X Coordinate
	 * @param y Y Coordinate
	 * @param l Label that shows total cost
	 */
	private void addButton(Session s,Menu m,int k, int x, int y,JLabel l) {
		JLabel infoLabel = new JLabel(m.getName()+": "+m.getPrice()+" X "+k);
		infoLabel.setBounds(x,y,100,50);
		add(infoLabel);
		
		JButton unitDecrease = new JButton("-");
		unitDecrease.setBounds(x+100,y,50,50);
		add(unitDecrease);
		
		JButton unitIncrease = new JButton("+");
		unitIncrease.setBounds(x+200,y,50,50);
		add(unitIncrease);
		
		JLabel unitCount = new JLabel(""+k);
		unitCount.setBounds(x+170,y,50,50);
		unitCount.setFont(new Font("Calibri",Font.BOLD,20));
		add(unitCount);
		
		unitDecrease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int unitNum=decreaseUnit(s,m);
				unitCount.setText(String.valueOf(unitNum));
				if (unitNum==0) {
					unitDecrease.setEnabled(false);}
				if (unitNum<=m.getUnits()) {
					unitIncrease.setEnabled(true);}
				l.setText("Name: "+s.getName() +" Age: "+ s.getAge()+" Cost: "+s.getTotal());
			}
		});
		
		unitIncrease.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int unitNum=increaseUnit(s,m);
				unitCount.setText(String.valueOf(unitNum));
				if (unitNum>0) {
					unitDecrease.setEnabled(true);}
				if (unitNum==m.getUnits()) {
					unitIncrease.setEnabled(false);}
				l.setText("Name: "+s.getName() +" Age: "+ s.getAge()+" Cost: "+s.getTotal());
			}
		});
	}
	/**
	 * Decrease 1 unit of given menu from the session
	 * Returns  new quantity that customer wants
	 * @param s Session Unit
	 * @param m Menu Unit
	 * @return the new quantity the customer wants from that product
	 */
	private int decreaseUnit(Session s, Menu m) {
		s.decreaseOrder(m);
		return s.getOrder().get(m);
	}
	/**
	 * Increase 1 unit of given menu from the session
	 * Returns  new quantity that customer wants
	 * @param s Session Unit
	 * @param m Menu Unit
	 * @return the new quantity the customer wants from that product
	 */
	private int increaseUnit(Session s, Menu m) {
		s.increaseOrder(m);
		return s.getOrder().get(m);
	}
	
}
