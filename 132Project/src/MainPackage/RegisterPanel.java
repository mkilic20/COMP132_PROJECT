package MainPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
public class RegisterPanel extends JFrame{
	private JLabel header;
	private JLabel peopleInfo;
	private JTextField name;
	private JTextField age;
	private JComboBox<Integer> peopleBox;
	private JButton register;
	private static final Integer[] peopleArr = {1,2,3,4,5,6}; 
	private boolean approved=false;
	public Session currentCustomer;
	
	public RegisterPanel() {
		super("Registration");
		
		Border border = BorderFactory.createLineBorder(Color.black,1);
		header = new JLabel();
		header.setText("PLEASE REGISTER");
		header.setFont(new Font("Calibri", Font.BOLD, 40));
		header.setOpaque(true);
		header.setBackground(Color.white);
		header.setBorder(border);
		header.setPreferredSize(new Dimension(350,150));
		add(header);
		
		name = new JTextField("Enter your name");
		name.setPreferredSize(new Dimension(250,50));
		name.setBackground(Color.pink);
		add(name);
		
		age = new JTextField("Enter your age");
		age.setPreferredSize(new Dimension(250,50));
		age.setBackground(Color.pink);
		add(age);
		
		peopleInfo = new JLabel("How many people plan to sit?");
		peopleInfo.setPreferredSize(new Dimension(300,50));
		peopleInfo.setBackground(Color.pink);
		add(peopleInfo);
		
		peopleBox = new JComboBox<Integer>(peopleArr);
		add(peopleBox);
		
		register = new JButton("Register");
		register.setPreferredSize(new Dimension(150,50));
		register.setBackground(Color.magenta);
		add(register);
		
		JLabel alertLabel = new JLabel("There is no table appropriate for you");
		alertLabel.setPreferredSize(new Dimension(360,50));
		alertLabel.setBorder(border);
		alertLabel.setBackground(Color.red);
		alertLabel.setVisible(false);
		alertLabel.setOpaque(true);
		add(alertLabel);
		
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String customerName = String.valueOf(name.getText());
				Integer customerAge = Integer.valueOf(age.getText());
				Integer peopleNum = (Integer) peopleBox.getSelectedItem();
				int tableNo=0;
				if (peopleNum<=2) {
					if (Test.stock.getTwoTable()>0) {
						approved=true;
						tableNo=2;
					}
				}
				else {
					if (Test.stock.getSixTable()>0) {
						approved=true;
						tableNo=6;
					}
				}
				if ((customerName != null)&&(customerAge!=null)&&(approved)) {
					setVisible(false);
					Test.customerPanel.setVisible(true);
					Test.stock.decreaseTable(tableNo);
					Test.managerPanel.updateTableText();
					currentCustomer = new Session(customerName,customerAge,peopleNum);
				}
				else alertLabel.setVisible(true);
			}
		});
	}
	
}
