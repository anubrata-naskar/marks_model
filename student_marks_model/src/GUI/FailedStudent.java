package GUI;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import transferobjects.Marks;
import user.FetchFromDatabase;

public class FailedStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public FailedStudent() {
		setTitle("GET DETAILS OF FAILED STUDENTS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel subjectCode = new JLabel("Subject Code");
		subjectCode.setHorizontalAlignment(SwingConstants.CENTER);
		subjectCode.setVerticalAlignment(SwingConstants.CENTER);
		subjectCode.setBounds(10, 11, 76, 25);
		contentPane.add(subjectCode);
		
		JLabel year1 = new JLabel("Year");
		year1.setVerticalAlignment(SwingConstants.CENTER);
		year1.setHorizontalAlignment(SwingConstants.CENTER);
		year1.setBounds(94, 44, 97, 25);
		contentPane.add(year1);
		
		JTextPane result = new JTextPane();
		result.setBounds(73, 154, 290, 97);
		result.setEditable(false);
		contentPane.add(result);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(114, 110, 89, 23);
		contentPane.add(submitBtn);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(178, 139, 79, 14);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.setBounds(224, 110, 89, 23);
		contentPane.add(back);
		
		JLabel passPer = new JLabel("Passing Percentage");
		passPer.setVerticalAlignment(SwingConstants.CENTER);
		passPer.setHorizontalAlignment(SwingConstants.CENTER);
		passPer.setBounds(90, 74, 101, 25);
		contentPane.add(passPer);
		
		JTextArea passPerc = new JTextArea();
		passPerc.setBounds(232, 77, 94, 22);
		contentPane.add(passPerc);
		
		JTextArea year = new JTextArea();
		year.setBounds(232, 44, 94, 22);
		contentPane.add(year);
		
		JTextArea subCode = new JTextArea();
		subCode.setBounds(124, 11, 94, 22);
		contentPane.add(subCode);
		
		JLabel exam = new JLabel("Exam Type");
		exam.setVerticalAlignment(SwingConstants.CENTER);
		exam.setHorizontalAlignment(SwingConstants.CENTER);
		exam.setBounds(224, 11, 76, 25);
		contentPane.add(exam);
		
		JTextArea examType = new JTextArea();
		examType.setBounds(314, 11, 94, 22);
		contentPane.add(examType);
		
		submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	result.setText("");
            	if( subCode.getText() != null && examType.getText() != null&& year.getText() !=null && passPerc.getText() != null) {
            		List<Marks> markList = new FetchFromDatabase().getFailedStudents(subCode.getText().trim().toLowerCase(), examType.getText().trim().toLowerCase(), year.getText().trim().toLowerCase(), passPerc.getText().trim().toLowerCase());
            		for(Marks mark : markList)
            		result.setText("Roll: "+mark.getRoll()+"\nYear: "+mark.getSemYear()+"\nPaper Code: "+mark.getPaperCode()+
                			"\nPaper Title: "+mark.getPaperTitle()+"\nHighest: "+mark.getObMark());
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
