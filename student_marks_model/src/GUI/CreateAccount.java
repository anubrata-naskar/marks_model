package GUI;

import java.awt.Color;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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


public class CreateAccount extends JFrame implements ActionListener{
		private JPanel createaccpanel;
	    private JTextField usernamefield,namefield,emailfield;
	    private JPasswordField passwordfield,confirmpassfield;
	    private JLabel username,password,confirmpass,name,email;
	    private String encrypted_pass;
	    private List<User> admindetails=new ArrayList<>();
		public CreateAccount(){
			setTitle("Admin Login createaccpanel");
	        setBounds(350, 100, 500, 450);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setResizable(false);

	        createaccpanel = new JPanel();
	        setContentPane(createaccpanel);
	        createaccpanel.setLayout(null);

	        JLabel title = new JLabel("Create Account");
	        title.setFont(new Font("News706 BT", Font.BOLD, 20));
	        title.setBorder(BorderFactory.createLineBorder(Color.black));
	        title.setBounds(150, 20, 170, 30);
	        createaccpanel.add(title);
	        
	        
	        name = new JLabel("Name:");
	        name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        name.setBorder(BorderFactory.createLoweredBevelBorder());
	        name.setBounds(70, 80, 120, 20);
	        createaccpanel.add(name);

	        namefield = new JTextField(20);
	        namefield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        namefield.setBorder(BorderFactory.createLineBorder(Color.black));
	        namefield.setBounds(220, 80, 200, 20);
	        createaccpanel.add(namefield);
	        
	        email = new JLabel("E-mail:");
	        email.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        email.setBorder(BorderFactory.createLoweredBevelBorder());
	        email.setBounds(70, 130, 120, 20);
	        createaccpanel.add(email);

	        emailfield = new JTextField(20);
	        emailfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        emailfield.setBorder(BorderFactory.createLineBorder(Color.black));
	        emailfield.setBounds(220, 130, 200, 20);
	        createaccpanel.add(emailfield);

	        username = new JLabel("Username:");
	        username.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        username.setBorder(BorderFactory.createLoweredBevelBorder());
	        username.setBounds(70, 180, 120, 20);
	        createaccpanel.add(username);

	        usernamefield = new JTextField(20);
	        usernamefield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        usernamefield.setBorder(BorderFactory.createLineBorder(Color.black));
	        usernamefield.setBounds(220, 180, 200, 20);
	        createaccpanel.add(usernamefield);

	        password = new JLabel("Password:");
	        password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        password.setBorder(BorderFactory.createLoweredBevelBorder());
	        password.setBounds(70, 230, 120, 20);
	        createaccpanel.add(password);

	        passwordfield = new JPasswordField(20);
	        passwordfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        passwordfield.setBorder(BorderFactory.createLineBorder(Color.black));
	        passwordfield.setBounds(220, 230, 200, 20);
	        createaccpanel.add(passwordfield);
	        
	        confirmpass = new JLabel("Confirm Password:");
	        confirmpass.setFont(new Font("Times New Roman", Font.PLAIN, 18));
	        confirmpass.setBorder(BorderFactory.createLoweredBevelBorder());
	        confirmpass.setBounds(70, 280, 120, 20);
	        createaccpanel.add(confirmpass);

	        confirmpassfield = new JPasswordField(20);
	        confirmpassfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	        confirmpassfield.setBorder(BorderFactory.createLineBorder(Color.black));
	        confirmpassfield.setBounds(220, 280, 200, 20);
	        createaccpanel.add(confirmpassfield);
	        
	        JButton creatacc = new JButton("Create Account");
	        creatacc.addActionListener(this);
	        creatacc.setFocusable(false);
	        creatacc.setBounds(120, 330, 100, 30);
	        creatacc.setBorder(BorderFactory.createRaisedBevelBorder());
	        createaccpanel.add(creatacc);
	        
	        JButton back = new JButton("Back");
	        back.addActionListener(this);
	        back.setFocusable(false);
	        back.setBounds(250, 330, 100, 30);
	        back.setBorder(BorderFactory.createRaisedBevelBorder());
	        createaccpanel.add(back);

		}
		
		 @Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();


				if(cmd.equalsIgnoreCase("Create Account")) {
				
			          String name = namefield.getText().trim();
			          String email = emailfield.getText().trim();
			          String username =  usernamefield.getText().trim();
			          
			          char[] password = passwordfield.getPassword();
			          String pass=new String(password); //convert the char[] into string
			          
			          char[] confirmpassword =confirmpassfield.getPassword();
			          String confirmpass=new String(confirmpassword);
			          if(name.equals("")||email.equals("")||username.equals("")||pass.equals("")||confirmpass.equals("")) {
			        	  JOptionPane.showMessageDialog(null,"Please fill all the fields..!!","warning",JOptionPane.WARNING_MESSAGE);
			          }
			          else {
							if (pass.equals(confirmpass)) {
								Encryptor encryptor = new Encryptor();
								try {
									encrypted_pass = encryptor.encryptString(pass);
								} catch (NoSuchAlgorithmException e1) {
									e1.printStackTrace();
								}

								UserDAO ud=new UserDAO();
								ud.store(name,email,username,encrypted_pass);
								JOptionPane.showMessageDialog(null, "Account created Sucessfully..!"); 
								dispose();
								StartingPage obj = new StartingPage();
								obj.setVisible(true);

							} else {
								JOptionPane.showMessageDialog(null, "Password and Confirm password field does not match",
										"title", JOptionPane.WARNING_MESSAGE);
							}
			          }
				}
				else if(cmd.equalsIgnoreCase("Back")) {
					dispose();
					Admin_Login obj=new Admin_Login();
					obj.setVisible(true);
				}
		}

}
