package bankmanagementsystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class BaseService {
	Conn getConnection() {
		return new Conn();
	}
}

class TransactionService extends BaseService {
	
	void deposit(String cardNo, int amount) {
		try {
			Conn c = getConnection();
			String q = "insert into bank(cardno,date,type,amount) values('"+cardNo+"',now(),'Deposit','"+amount+"')";
			c.s.executeUpdate(q);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	void withdraw(String cardNo, int amount) {
		try {
			if(getBalance(cardNo) < amount) return;
			
			Conn c = getConnection();
			String q = "insert into bank(cardno,date,type,amount) values('"+cardNo+"',now(),'Withdraw','"+amount+"')";
			c.s.executeUpdate(q);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	int getBalance(String cardNo) {
		int balance = 0;
		
		try {
			Conn c = getConnection();
			ResultSet rs = c.s.executeQuery("select * from bank where cardno='"+cardNo+"'");
			
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += rs.getInt("amount");
				} else {
					balance -= rs.getInt("amount");
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return balance;
	}
}

public class Transactions extends JFrame implements ActionListener{
	
	JButton deposit,withdraw,ministmt,balance,pinchange,exit;
	String cardNo;
	
	Transactions(String cardNo) {
		this.cardNo=cardNo;
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(200,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit=new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.setContentAreaFilled(false);
		deposit.setFocusPainted(false);
		deposit.setForeground(Color.decode("#E5B567"));
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw=new JButton("Withdraw");
		withdraw.setBounds(355,415,150,30);
		withdraw.setContentAreaFilled(false);
		withdraw.setFocusPainted(false);
		withdraw.setForeground(Color.decode("#E5B567"));
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		ministmt=new JButton("Mini Statement");
		ministmt.setBounds(170,450,150,30);
		ministmt.setContentAreaFilled(false);
		ministmt.setFocusPainted(false);
		ministmt.setForeground(Color.decode("#E5B567"));
		ministmt.addActionListener(this);
		image.add(ministmt);
		
		balance=new JButton("Balance");
		balance.setBounds(355,450,150,30);
		balance.setContentAreaFilled(false);
		balance.setFocusPainted(false);
		balance.setForeground(Color.decode("#E5B567"));
		balance.addActionListener(this);
		image.add(balance);
		
		pinchange=new JButton("Pinchange");
		pinchange.setBounds(170,485,150,30);
		pinchange.setContentAreaFilled(false);
		pinchange.setFocusPainted(false);
		pinchange.setForeground(Color.decode("#E5B567"));
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		exit=new JButton("Exit");
		exit.setBounds(355,485,150,30);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);
		exit.setForeground(Color.decode("#E5B567"));
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,10);
		setUndecorated(true);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			System.exit(0);
		}
		else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(cardNo).setVisible(true);
		}
		else if(ae.getSource()==withdraw) {
			setVisible(false);
			new withdrawl(cardNo).setVisible(true);
		}
		else if(ae.getSource()==pinchange) {
			setVisible(false);
			new PinChange(cardNo).setVisible(true);
		}
		else if(ae.getSource()==balance) {
			setVisible(false);
			new BalanceEnquiry(cardNo).setVisible(true);
		}
		else if(ae.getSource()==ministmt) {
			setVisible(false);
			new MiniStatement(cardNo).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Transactions("");
	}
}