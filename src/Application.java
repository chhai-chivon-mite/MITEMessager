import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

/*
 * @author: Chhai Chivon on Jan 18, 2020
 * Senior Application Developer
 */

public class Application {

	private static Application window;
	private JFrame frame;
	private JTextField tfLogUsername;
	private JPasswordField tfLogPass;
	private JTextField tfReUsername;
	private JPasswordField tfRePass;
	private JPasswordField tfReConfPas;
	private JTextField tfMsg;
	
	private Socket connection;
	private Scanner scanner;
	private OutputStreamWriter outputStreamWriter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 572);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(153, 6, 218, 143);
		frame.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(6, 6, 211, 16);
		panelLogin.add(lblNewLabel);
		
		tfLogUsername = new JTextField();
		tfLogUsername.setBounds(6, 27, 211, 29);
		panelLogin.add(tfLogUsername);
		tfLogUsername.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(6, 57, 211, 16);
		panelLogin.add(lblNewLabel_1);
		
		tfLogPass = new JPasswordField();
		tfLogPass.setBounds(6, 76, 211, 29);
		panelLogin.add(tfLogPass);
		tfLogPass.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Login Successful","Login", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnLogin.setBounds(6, 108, 87, 29);
		panelLogin.add(btnLogin);
		
		JButton btnLogReset = new JButton("Reset");
		btnLogReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClearLogin();
			}
		});
		btnLogReset.setBounds(125, 108, 87, 29);
		panelLogin.add(btnLogReset);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBounds(153, 161, 218, 183);
		frame.getContentPane().add(panelRegister);
		panelRegister.setLayout(null);
		
		frame.setTitle("Welcome to Chhai Chivon");
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(6, 6, 206, 16);
		panelRegister.add(lblNewLabel_2);
		
		tfReUsername = new JTextField();
		tfReUsername.setBounds(6, 28, 206, 26);
		panelRegister.add(tfReUsername);
		tfReUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(6, 54, 61, 16);
		panelRegister.add(lblNewLabel_3);
		
		tfRePass = new JPasswordField();
		tfRePass.setBounds(6, 78, 206, 26);
		panelRegister.add(tfRePass);
		tfRePass.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Confirm Password");
		lblNewLabel_4.setBounds(6, 104, 206, 16);
		panelRegister.add(lblNewLabel_4);
		
		tfReConfPas = new JPasswordField();
		tfReConfPas.setBounds(6, 123, 206, 26);
		panelRegister.add(tfReConfPas);
		tfReConfPas.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().onStartLogin();
				window.frame.setVisible(false);
				//JOptionPane.showMessageDialog(frame, "Register Successful","Register", JOptionPane.INFORMATION_MESSAGE);
				
	
			}
		});
		btnRegister.setBounds(6, 148, 95, 29);
		panelRegister.add(btnRegister);
		
		JButton btnRegReset = new JButton("Reset");
		btnRegReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClearRegister();
			}
		});
		btnRegReset.setBounds(111, 148, 101, 29);
		panelRegister.add(btnRegReset);
		
		JPanel panelSendMessage = new JPanel();
		panelSendMessage.setBounds(6, 356, 522, 188);
		frame.getContentPane().add(panelSendMessage);
		panelSendMessage.setLayout(null);
		
		tfMsg = new JTextField();
		tfMsg.setBounds(6, 148, 451, 34);
		panelSendMessage.add(tfMsg);
		tfMsg.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Send Successful");
			}
		});
		btnSend.setBounds(455, 152, 61, 29);
		panelSendMessage.add(btnSend);
		
		JPanel panelRecieveMsg = new JPanel();
		panelRecieveMsg.setBounds(6, 6, 246, 140);
		panelSendMessage.add(panelRecieveMsg);
		
		JPanel panelSendMsg = new JPanel();
		panelSendMsg.setBounds(270, 6, 246, 134);
		panelSendMessage.add(panelSendMsg);
		
	
		panelLogin.setVisible(false);
		
	}
	
	private void onClearRegister() {
		tfReUsername.setText("");
		tfRePass.setText("");
		tfReConfPas.setText("");
	}
	
	private void onClearLogin() {
		tfLogUsername.setText("");
		tfLogPass.setText("");
	}
	
	class BindThread extends Thread {
		
	}
	
	class SendThread extends Thread {
			
		}
	
	class ReceiveThread extends Thread {
		
	}
}
