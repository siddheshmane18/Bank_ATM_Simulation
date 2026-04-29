package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
	
	JButton back;
	String CardNo;
	TransactionService service;
	
	public BalanceEnquiry(String CardNo) {
		this.CardNo=CardNo;
		service=new TransactionService();
		
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back=new JButton("Back");
		back.setBounds(355,520,150,30);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		back.setForeground(Color.decode("#E5B567"));
		back.addActionListener(this);
		image.add(back);
		
		int balance=service.getBalance(CardNo);
		
		JLabel text=new JLabel("Your Account Balance is Rs. "+balance);
		text.setForeground(Color.WHITE);
		text.setBounds(190,350,400,30);
		image.add(text);
		
		setSize(900,900);
		setLocation(300,10);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		setVisible(false);
		new Transactions(CardNo).setVisible(true);
	}
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}