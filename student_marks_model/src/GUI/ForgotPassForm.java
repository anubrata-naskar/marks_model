package GUI;


import javax.swing.*;

import dao.UserDAO;
import transferobjects.User;
import user.SendOTP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ForgotPassForm extends JFrame {

    private JTextField emailTextField;

    public ForgotPassForm() {
        // Set frame properties
        setTitle("Forgot Password");
        setSize(400, 120);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel emailLabel = new JLabel("Enter Email ID:");
        emailLabel.setFont(new Font("Times new Roman",Font.PLAIN,16));
        emailTextField = new JTextField(20);
        emailTextField.setFont(new Font("Times new Roman",Font.PLAIN,16));
        JButton submitButton = new JButton("Submit");
        submitButton.setFocusable(false);
        JButton back = new JButton("Back");
        back.setFocusable(false);

        JPanel panel = new JPanel();
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(submitButton);
        panel.add(back);


        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                UserDAO obj=new UserDAO();
                User userfound=obj.searchdetails(email);
				dispose();
				if(userfound.getPresent()) {
					JOptionPane.showMessageDialog(null,"OTP sent to your mail id");
					new SendOTP(email); //create object of SendOTP class
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(null,"email id doesn't exists","warning!",JOptionPane.WARNING_MESSAGE);
				}
            }
        });
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartingPage obj=new StartingPage();
                obj.setVisible(true);
                
            }
        });


        getContentPane().add(panel);
        setVisible(true);
    }
}


