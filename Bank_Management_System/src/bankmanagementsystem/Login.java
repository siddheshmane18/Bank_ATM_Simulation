package bankmanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class AuthService {
	boolean login(String cardno, String pin) {
		try {
			Conn c = new Conn();
			String query = "SELECT 1 FROM customer WHERE cardNumber='"+cardno+"' AND pinNumber='"+pin+"'";
			ResultSet rs = c.s.executeQuery(query);
			return rs.next();
		} catch(Exception e) {
			System.out.println(e);
		}
		return false;
	}
}

public class Login extends JFrame implements ActionListener{
	
	JButton login,signup,clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	AuthService auth;

	Login(){
		auth = new AuthService();
		
		setTitle("-- ATM --");
		setLayout(null);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/l.jpg"));
		Image i2=i1.getImage().getScaledInstance(100,100, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel label=new JLabel(i3);
		label.setBounds(70,10,100,100); 
		add(label);
		
		ImageIcon i0=new ImageIcon(ClassLoader.getSystemResource("icons/MIT logo.jpg.jpeg"));
		Image i20=i0.getImage().getScaledInstance(260,70, Image.SCALE_SMOOTH);
		ImageIcon i30=new ImageIcon(i20);
		JLabel label2=new JLabel(i30);
		label2.setBounds(500,30,260,70); 
		add(label2);
		
		JLabel text=new JLabel("Bank of MITAOE");
		text.setFont(new Font("Osward",Font.BOLD,28));
		text.setBounds(220,40,250,40);
		add(text);
		
		JLabel text2=new JLabel("Name:");
		text2.setFont(new Font("Osward",Font.BOLD,18));
		text2.setBounds(50,360,250,40);
		add(text2);
		JLabel text3=new JLabel("Siddhesh Abasaheb Mane");
		text3.setFont(new Font("Osward",Font.PLAIN,15));
		text3.setBounds(50,380,250,40);
		add(text3);
		
		JLabel text5=new JLabel("Guide:");
		text5.setFont(new Font("Osward",Font.BOLD,18));
		text5.setBounds(590,360,250,40);
		add(text5);
		
		JLabel text4=new JLabel("Dr. Vijaykumar Mantri");
		text4.setFont(new Font("Osward",Font.PLAIN,15));
		text4.setBounds(590,380,250,40);
		add(text4);
		
		JLabel cardno=new JLabel("Card No.: ");
		cardno.setFont(new Font("Railway",Font.BOLD,28));
		cardno.setBounds(120,150,150,30);
		add(cardno);
		
		cardTextField=new JTextField();
		cardTextField.setBounds(300,150,230,30);
		add(cardTextField);
		
		JLabel pin=new JLabel("PIN: ");
		pin.setFont(new Font("Railway",Font.BOLD,28));
		pin.setBounds(120,220,250,30);
		add(pin);
		
		pinTextField=new JPasswordField();
		pinTextField.setBounds(300,220,230,30);
		add(pinTextField);
		
		login=new JButton("Sign In");
		login.setBounds(300,300,100,30);
		login.addActionListener(this);
		add(login);
		
		signup=new JButton("Sign Up");
		signup.setBounds(300,350,230,30);
		signup.addActionListener(this);
		add(signup);
		
		clear=new JButton("Clear");
		clear.setBounds(430,300,100,30);
		clear.addActionListener(this);
		add(clear);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setLocation(350,200);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==login) {
			String cardno=cardTextField.getText().trim();
			String pin=new String(pinTextField.getPassword()).trim();
			
			if(cardno.equals("") || pin.equals("")) {
				JOptionPane.showMessageDialog(null,"Enter Card Number and PIN");
				return;
			}
			
			if(auth.login(cardno,pin)) {
				JOptionPane.showMessageDialog(null,"Login Successful");
				setVisible(false);
				new Transactions(cardno).setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
			}
		}
		else if(ae.getSource()==signup) {
			setVisible(false);
			new SignupOne().setVisible(true);
		}
		else if(ae.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
	}

	public static void main(String[] args) {
		new Login();
	}
}