package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import user.MailSend;

public class MailGui extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextArea textarea, subjectarea;
	private JComboBox<String> combo1;
	private JTextField infoField;
	private String filepath;

	public MailGui() {
		setTitle("Send Notification");
		setBounds(250, 100, 800, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		JLabel title = new JLabel("Notification Management");
		title.setFont(new Font("Algerian", Font.BOLD, 18));
		title.setBorder(BorderFactory.createLineBorder(Color.black));
		title.setBounds(280, 20, 260, 30);
		panel.add(title);

		JLabel method = new JLabel("Select method:");
		method.setFont(new Font("Times new roman", Font.BOLD, 15));
		method.setBounds(100, 80, 150, 20);
		panel.add(method);

		String select[] = { "select", "Phone No", "E-mail", "Buzzer" };
		combo1 = new JComboBox<>(select);
		combo1.setBounds(220, 80, 100, 20);
		panel.add(combo1);

		JLabel label = new JLabel("Enter Information:");
		label.setFont(new Font("Times new roman", Font.BOLD, 15));
		label.setBounds(350, 80, 150, 20);
		panel.add(label);

		JLabel msgs = new JLabel("Subject: ");
		msgs.setFont(new Font("Times new roman", Font.BOLD, 15));
		msgs.setBounds(50, 120, 150, 20);
		panel.add(msgs);

		subjectarea = new JTextArea();
		JScrollPane spane = new JScrollPane(subjectarea);
		spane.setBounds(120, 122, 630, 20);
		panel.add(spane);

		combo1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String selectedItem = (String) combo1.getSelectedItem();
				if ("Phone No".equals(selectedItem)) {
					label.setText("Enter Phone No:");
					//infoField.setEditable(true);
				} else if ("E-mail".equals(selectedItem)) {
					label.setText("Enter E-mail:");
					//infoField.setEditable(true);
				} else if ("Buzzer".equals(selectedItem)) {
					label.setText("No need to enter:");
					//infoField.setEditable(false);
				} else {
					label.setText("Enter Information:");
					//infoField.setEditable(true);
				}
			}
		});
		infoField = new JTextField(25);
		infoField.setBounds(490, 80, 200, 20);
		panel.add(infoField);

		textarea = new JTextArea();
		JScrollPane pane = new JScrollPane(textarea);
		pane.setBounds(50, 160, 700, 230);
		pane.setBorder(BorderFactory.createTitledBorder("Write the message here"));
		pane.setFont(new Font("Times new roman",Font.PLAIN,16));
		textarea.setFont(new Font("Times new roman",Font.PLAIN,16));
		panel.add(pane);

		JButton attach = new JButton("Attach File");
		attach.setBounds(100, 410, 130, 30);
		//attach.addActionListener(this);
		attach.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JFileChooser fileChooser = new JFileChooser();
    	        int returnValue = fileChooser.showOpenDialog(null);

    	        if (returnValue == JFileChooser.APPROVE_OPTION) {
    	            filepath=fileChooser.getSelectedFile().getAbsolutePath();
    	        } else {
    	            System.out.println("No file selected.");
    	        }
            }
        });
		attach.setFocusable(false);
		panel.add(attach);
		
		JButton send = new JButton("Send");
		send.setBounds(670, 410, 70, 30);
		send.addActionListener(this);
		send.setFocusable(false);
		panel.add(send);
	}

	public static void main(String args[]) {
		MailGui c = new MailGui();
		c.setVisible(true);
	}

	public void reset() {
		textarea.setText("");
		subjectarea.setText("");
		infoField.setText("");
		combo1.setSelectedIndex(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		String info = infoField.getText().trim();
		String message = textarea.getText().trim();
		String subject = subjectarea.getText().trim();
		MailSend obj = new MailSend(info, message, subject, filepath);
		if (cmd.equalsIgnoreCase("Send")) {
			String method = (String) combo1.getSelectedItem();
			if(method.equals("select")) {
				JOptionPane.showMessageDialog(null,"please select a method type..!","warning",JOptionPane.WARNING_MESSAGE);
			}
			else if(method.equalsIgnoreCase("Phone No")||method.equalsIgnoreCase("E-mail")||method.equalsIgnoreCase("Buzzer")){
				if((info.equals("") && method.equalsIgnoreCase("Phone No"))||(method.equalsIgnoreCase("Phone No") && info.length()!=10)) {
					JOptionPane.showMessageDialog(null,"Enter a valid phone no..!","warning",JOptionPane.WARNING_MESSAGE);
				}
				else if((info.equals("") && method.equalsIgnoreCase("E-mail"))||(method.equalsIgnoreCase("E-mail") && !info.contains("@"))) {
					JOptionPane.showMessageDialog(null,"Enter a valid e-mail..!","warning",JOptionPane.WARNING_MESSAGE);
				}
			else {
						obj.send();
						reset();
			}
			}
		}
	}
	

}
