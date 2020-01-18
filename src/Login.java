import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Login {

	private JFrame frame;
	private JTextField tfLogUsername;
	private JPasswordField tfLogPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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
		frame.setTitle("Login");
		frame.getContentPane().setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(115, 54, 218, 143);
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
				JOptionPane.showMessageDialog(frame, "Login Successful");
			}
		});
		btnLogin.setBounds(6, 108, 87, 29);
		panelLogin.add(btnLogin);
		
		JButton btnLogReset = new JButton("Reset");
		btnLogReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogReset.setBounds(125, 108, 87, 29);
		panelLogin.add(btnLogReset);
	}

}
