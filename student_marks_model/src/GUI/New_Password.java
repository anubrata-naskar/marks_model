package GUI;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


import dao.UserDAO;
import user.Encryptor;

public class New_Password extends JFrame{
	private JPasswordField passwordfield,confirmpasswordfield;
	private JLabel password,confirmpassword;
	private JPanel panel;
	private String encrypted_pass;
	
	public New_Password(String mail){
		
		setTitle("Edit password");
        setBounds(350, 200, 500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        
        password = new JLabel("New Password:");
        password.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        password.setBorder(BorderFactory.createLoweredBevelBorder());
        password.setBounds(70, 70, 130, 20);
        panel.add(password);

        passwordfield = new JPasswordField(20);
        passwordfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        passwordfield.setBorder(BorderFactory.createLineBorder(Color.black));
        passwordfield.setBounds(220, 70, 200, 20);
        panel.add(passwordfield);
        
        confirmpassword = new JLabel("Confirm Password:");
        confirmpassword.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        confirmpassword.setBorder(BorderFactory.createLoweredBevelBorder());
        confirmpassword.setBounds(70, 120, 130, 20);
        panel.add(confirmpassword);

        confirmpasswordfield = new JPasswordField(20);
        confirmpasswordfield.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        confirmpasswordfield.setBorder(BorderFactory.createLineBorder(Color.black));
        confirmpasswordfield.setBounds(220, 120, 200, 20);
        panel.add(confirmpasswordfield);
        
        JButton submit = new JButton("Submit");
        submit.setFocusable(false);
        submit.setBounds(190, 170, 100, 30);
        submit.setBorder(BorderFactory.createRaisedBevelBorder());
        panel.add(submit);


	        // Add action listener to the button
	        submit.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	dispose();
	            	char[] password = passwordfield.getPassword();
	  	          	String pass=new String(password); //convert the char[] into string
	  	          
	  	          	char[] confirmpassword =confirmpasswordfield.getPassword();
	  	          	String confirmpass=new String(confirmpassword);
	  	          	
	  	          if(pass.equals("")||confirmpass.equals("")) {
		        	  JOptionPane.showMessageDialog(null,"Please fill all the fields..!!","warning",JOptionPane.WARNING_MESSAGE);
		          }
		          else {
						if (pass.equals(confirmpass)) {
							Encryptor encryptor = new Encryptor();
							try {
								encrypted_pass = encryptor.encryptString(pass);
								UserDAO obj=new UserDAO();
								obj.modifypass(encrypted_pass,mail);
							} catch (NoSuchAlgorithmException e1) {
								e1.printStackTrace();
							}
							StartingPage obj = new StartingPage();
							obj.setVisible(true);

						} else {
							JOptionPane.showMessageDialog(null, "Password and Confirm password field does not match",
									"title", JOptionPane.WARNING_MESSAGE);
						}
		          }
	              
	            }
	        });
	}
}