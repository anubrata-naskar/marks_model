package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class UserInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface frame = new UserInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 529, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel dept = new JPanel();
		dept.setBounds(5, 146, 158, 169);
		contentPane.add(dept);
		dept.setLayout(null);
		
		JLabel dep = new JLabel("Departments");
		dep.setBounds(10, 5, 138, 14);
		dep.setHorizontalAlignment(SwingConstants.CENTER);
		dept.add(dep);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 138, 131);
		dept.add(scrollPane);
		
		JPanel deatils = new JPanel();
		deatils.setBounds(173, 146, 330, 169);
		contentPane.add(deatils);
		deatils.setLayout(null);
		
		JLabel det = new JLabel("Details");
		det.setHorizontalAlignment(SwingConstants.CENTER);
		det.setBounds(41, 5, 261, 14);
		deatils.add(det);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 30, 310, 128);
		deatils.add(scrollPane_1);
		
		JPanel button = new JPanel();
		button.setBounds(5, 11, 498, 124);
		contentPane.add(button);
		
		JButton generateRes = new JButton("Generate Result");
		button.add(generateRes);
		
		JButton upData = new JButton("Upload Data");
		button.add(upData);
		
		JButton getDetails = new JButton("Get Deatils");
		button.add(getDetails);
		
		JComboBox setting = new JComboBox();
		setting.setModel(new DefaultComboBoxModel(new String[] {"Change Password", "Sign Out"}));
		button.add(setting);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Send");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		button.add(chckbxNewCheckBox);
		
		JLabel lblSubject = new JLabel("Subject");
		button.add(lblSubject);
		
		textField = new JTextField();
		button.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email Id");
		button.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		button.add(textField_1);
	}
}
