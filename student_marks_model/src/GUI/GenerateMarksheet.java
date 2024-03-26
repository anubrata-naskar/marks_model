package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import transferobjects.Marks;
import user.FetchFromDatabase;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextPane;

public class GenerateMarksheet extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public GenerateMarksheet() {
		setTitle("GENERATE MARKSHEET");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Roll Number");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(66, 11, 78, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setHorizontalAlignment(SwingConstants.CENTER);
		lblYear.setBounds(66, 43, 78, 21);
		contentPane.add(lblYear);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setHorizontalAlignment(SwingConstants.CENTER);
		lblSemester.setBounds(66, 75, 78, 21);
		contentPane.add(lblSemester);
		
		JTextArea roll = new JTextArea();
		roll.setBounds(180, 9, 131, 22);
		contentPane.add(roll);
		
		JTextArea year = new JTextArea();
		year.setBounds(180, 41, 131, 22);
		contentPane.add(year);
		
		JTextArea sem = new JTextArea();
		sem.setBounds(180, 73, 131, 22);
		contentPane.add(sem);
		
		JButton genMarksheet = new JButton("Submit");
		genMarksheet.setBounds(101, 106, 89, 23);
		contentPane.add(genMarksheet);
		
		JTextPane result = new JTextPane();
		result.setBounds(79, 154, 263, 97);
		result.setEditable(false);
		contentPane.add(result);
		
		JLabel lblNewLabel_1 = new JLabel("Result");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(157, 140, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton back = new JButton("Back");
		back.setBounds(238, 106, 89, 23);
		contentPane.add(back);
		
		genMarksheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	result.setText("");
            	if(roll.getText() !=null && year.getText() != null && sem.getText() != null) {
            		List<Marks> marksList = new FetchFromDatabase().generatePDF(roll.getText().trim().toLowerCase(), year.getText().trim().toLowerCase(),sem.getText().trim().toLowerCase());
            		for(Marks marks : marksList) {
            			result.setText("\tPaper Code: "+marks.getPaperCode()+
                    			"\tPaper Title: "+marks.getPaperTitle()+"\tFull Marks: "+marks.getFullMark()+"\tObtained Marks: "+marks.getObMark());
            		}
            	}
            }
        });
		
		back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	dispose();
            	FetchingOptions fo =new FetchingOptions();
                fo.setVisible(true);
                
            }
        });
	}

}
