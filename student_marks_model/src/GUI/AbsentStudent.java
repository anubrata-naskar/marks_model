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

public class AbsentStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AbsentStudent() {
		setTitle("GET DETAILS OF ABSENT STUDENTS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel subCode = new JLabel("Subject Code");
		subCode.setHorizontalAlignment(SwingConstants.CENTER);
		subCode.setVerticalAlignment(SwingConstants.CENTER);
		subCode.setBounds(87, 11, 76, 25);
		contentPane.add(subCode);
		
		JTextArea subcode = new JTextArea();
		subcode.setBounds(193, 11, 98, 22);
		contentPane.add(subcode);
		
		JLabel year1 = new JLabel("Year");
		year1.setVerticalAlignment(SwingConstants.CENTER);
		year1.setHorizontalAlignment(SwingConstants.CENTER);
		year1.setBounds(87, 52, 76, 25);
		contentPane.add(year1);
		
		JTextArea year = new JTextArea();
		year.setBounds(193, 52, 98, 22);
		contentPane.add(year);
		
		JTextPane result = new JTextPane();
		result.setBounds(87, 147, 249, 82);
		result.setEditable(false);
		contentPane.add(result);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.setBounds(113, 91, 89, 23);
		contentPane.add(submitBtn);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 125, 79, 14);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.setBounds(225, 91, 89, 23);
		contentPane.add(back);
		
		submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	result.setText("");
            	if(year.getText() !=null && subcode.getText() != null) {
            		List<Marks> markList = new FetchFromDatabase().getAbsentStudents(subcode.getText().trim().toLowerCase(), year.getText().trim().toLowerCase());
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
