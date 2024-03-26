package user;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import GUI.New_Password;


public class OTP_match extends JFrame{
	private int otp;
	private String mail;
	private JTextField otpField;
	public OTP_match(int number,String mail){
		this.mail=mail;
		 // Set frame properties
        setTitle("OTP");
        setSize(400, 120);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel otpLabel = new JLabel("Enter OTP:");
        otpLabel.setFont(new Font("Times new Roman",Font.PLAIN,16));
        otpField = new JTextField(20);
        otpField.setFont(new Font("Times new Roman",Font.PLAIN,16));
        JButton submitButton = new JButton("Submit");
        submitButton.setFocusable(false);

        JPanel panel = new JPanel();
        panel.add(otpLabel);
        panel.add(otpField);
        panel.add(submitButton);


        // Add action listener to the button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               otp=Integer.parseInt(otpField.getText());
               match_otp(otp,number);
            }
        });
        getContentPane().add(panel);
        setVisible(true);
	}
	public void match_otp(int number,int otp) {
		if(otp==number) {
			dispose();
			New_Password obj=new New_Password(mail);
			obj.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong OTP","warning",JOptionPane.WARNING_MESSAGE);
		}
	}
}
