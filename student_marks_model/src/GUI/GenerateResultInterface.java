package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GenerateResultInterface extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField dept;
	private JTextField roll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateResultInterface frame = new GenerateResultInterface();
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
	public GenerateResultInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 74, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblRollNumber.setBounds(220, 11, 74, 28);
		contentPane.add(lblRollNumber);
		
		dept = new JTextField();
		dept.setBounds(94, 15, 116, 20);
		contentPane.add(dept);
		dept.setColumns(10);
		
		roll = new JTextField();
		roll.setColumns(10);
		roll.setBounds(308, 15, 116, 20);
		contentPane.add(roll);
		
		JButton generate = new JButton("Generate");
		generate.setBounds(173, 50, 89, 23);
		contentPane.add(generate);
	}
}
