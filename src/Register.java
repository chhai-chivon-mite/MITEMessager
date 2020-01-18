import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * @author: Chhai Chivon on Jan 18, 2020
 * Senior Application Developer
 */

public class Register {

	private JFrame frame;
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
					Register window = new Register();
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
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Register");
		frame.getContentPane().setLayout(null);
		
		JPanel panelRegister = new JPanel();
		panelRegister.setBounds(133, 38, 218, 183);
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
				
				JOptionPane.showMessageDialog(frame, "Register Successful");
			}
		});
		btnRegister.setBounds(6, 148, 95, 29);
		panelRegister.add(btnRegister);
		
		JButton btnRegReset = new JButton("Reset");
		btnRegReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRegReset.setBounds(111, 148, 101, 29);
		panelRegister.add(btnRegReset);
	}

}
