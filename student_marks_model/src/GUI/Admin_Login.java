package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UserDAO;
import transferobjects.User;
import user.Encryptor;

public class Admin_Login extends JFrame implements ActionListener {
	private JPanel loginpanel;
	private JTextField usernamefield;
	private JPasswordField passwordfield;
	private JLabel username, password;
	private String encrypted_pass;

	public Admin_Login() {
		setTitle("Admin Login loginpanel");
		setBounds(350, 50, 500, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		loginpanel = new JPanel();
		setContentPane(loginpanel);
		loginpanel.setLayout(null);

		JLabel title = new JLabel("Admin Login");
		title.setFont(new Font("News706 BT", Font.BOLD, 22));
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setBounds(170, 50, 150, 30);
		loginpanel.add(title);

		username = new JLabel("Username:");
		username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		username.setBorder(BorderFactory.createLoweredBevelBorder());
		username.setBounds(70, 150, 130, 20);
		loginpanel.add(username);

		usernamefield = new JTextField(20);
		usernamefield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		usernamefield.setBorder(BorderFactory.createLineBorder(Color.black));
		usernamefield.setBounds(220, 150, 200, 20);
		loginpanel.add(usernamefield);

		password = new JLabel("Password:");
		password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		password.setBorder(BorderFactory.createLoweredBevelBorder());
		password.setBounds(70, 200, 130, 20);
		loginpanel.add(password);

		passwordfield = new JPasswordField(20);
		passwordfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordfield.setBorder(BorderFactory.createLineBorder(Color.black));
		passwordfield.setBounds(220, 200, 200, 20);
		loginpanel.add(passwordfield);

		JButton login = new JButton("Login");
		login.addActionListener(this);
		login.setFocusable(false);
		login.setBounds(120, 250, 100, 30);
		login.setBorder(BorderFactory.createRaisedBevelBorder());
		loginpanel.add(login);

		JButton forgotpass = new JButton("Forgot Password");
		forgotpass.addActionListener(this);
		forgotpass.setFocusable(false);
		forgotpass.setBounds(240, 250, 150, 30);
		forgotpass.setBorder(BorderFactory.createRaisedBevelBorder());
		loginpanel.add(forgotpass);
		
		JLabel label1 = new JLabel("Do not Register yet?  ");
		label1.setBounds(120, 320, 400, 20);
		label1.setFont(new Font("Times new roman", Font.PLAIN, 17));
		loginpanel.add(label1);

		JButton signup = new JButton("Sign Up");
		signup.addActionListener(this);
		signup.setFocusable(false);
		signup.setBounds(270, 315, 110, 30);
		signup.setBorder(BorderFactory.createRaisedBevelBorder());
		loginpanel.add(signup);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();

		if(cmd.equalsIgnoreCase("Sign Up")) {
			dispose();
			CreateAccount obj=new CreateAccount();
			obj.setVisible(true);
		}
		else if(cmd.equalsIgnoreCase("Login")) {
			String username=usernamefield.getText().trim();
			char[] passbyte=passwordfield.getPassword();
			String passstring=new String(passbyte);
			if(username.equals("")||passstring.equals("")) {
				JOptionPane.showMessageDialog(null,"Please fill all the fields..!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else {
				Encryptor encryptor = new Encryptor();
				try {
					encrypted_pass = encryptor.encryptString(passstring);
				} catch (NoSuchAlgorithmException e1) {
					e1.printStackTrace();
				}
				UserDAO obj=new UserDAO();
				User u=obj.checkUser(username, encrypted_pass);
				if (u.getPresent()) {
				JOptionPane.showMessageDialog(null, "Welcome user..!");
				StartingPage obj1 = new StartingPage();
				obj1.setVisible(true);
				dispose();
			} else 
				JOptionPane.showMessageDialog(null, "Incorrect username or password..!");
			}
			
		}
		else if(cmd.equalsIgnoreCase("Forgot Password")) {
			new ForgotPassForm();
			dispose();
		}
		
	}

}
