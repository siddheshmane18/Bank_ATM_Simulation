package bankmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

class StatementService {
	
	String getMiniStatement(String CardNo) {
		StringBuilder data = new StringBuilder("<html>");
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE cardno='"+CardNo+"' ORDER BY id DESC LIMIT 5");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String date = rs.getString("date");
				String type = rs.getString("type");
				int amount = rs.getInt("amount");
				
				data.append("TxnID: ").append(id).append(" &nbsp;&nbsp; ")
				    .append(date).append(" &nbsp;&nbsp; ")
				    .append(type).append(" &nbsp;&nbsp; ₹")
				    .append(amount).append("<br><br>");
			}
			
			data.append("<br><b>Current Balance: ₹ ")
			    .append(getBalance(CardNo))
			    .append("</b></html>");
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return data.toString();
	}
	
	int getBalance(String CardNo) {
		int balance = 0;
		
		try {
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from bank where cardno='"+CardNo+"'");
			
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

public class MiniStatement extends JFrame {
	
	String CardNo;
	StatementService service;
	
	MiniStatement(String CardNo){
		this.CardNo=CardNo;
		service = new StatementService();
		
		setLayout(null);
		
		JLabel mini=new JLabel();
		mini.setBounds(20,140,360,350);
		add(mini);
		
		JLabel bank=new JLabel("Bank");
		bank.setFont(new Font("Railway",Font.BOLD,19));
		bank.setBounds(160,20,100,20);
		add(bank);
		
		String masked;
		if(CardNo!=null && CardNo.length()>=4) {
			masked="Card: xxxxxxxxxxxx"+CardNo.substring(CardNo.length()-4);
		}else {
			masked="Card: xxxxxxxxxxxxxxxx";
		}
		
		JLabel card=new JLabel(masked);
		card.setBounds(20,80,300,20);
		add(card);
		
		mini.setText(service.getMiniStatement(CardNo));
		
		setTitle("Mini Statement");
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MiniStatement("");
	}
}