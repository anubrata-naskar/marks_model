package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import transferobjects.Marks;
import user.FetchFromDatabase;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class AverageMark extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public AverageMark() {
		setVisible(true);
		setTitle("GET AVERAGE MARKS");
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
		
		JButton avgMarksbtn = new JButton("Submit");
		avgMarksbtn.setBounds(111, 91, 89, 23);
		contentPane.add(avgMarksbtn);
		
		JLabel lblNewLabel = new JLabel("Result");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 125, 79, 14);
		contentPane.add(lblNewLabel);
		
		JButton back = new JButton("Back");
		back.setBounds(221, 91, 89, 23);
		contentPane.add(back);
		
		avgMarksbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	result.setText("");
            	if(year.getText() !=null && subcode.getText() != null) {
            		Marks marks = new FetchFromDatabase().getAvgMarks(subcode.getText().trim().toLowerCase(), year.getText().trim().toLowerCase());
            		result.setText("Roll: "+marks.getRoll()+"\nYear: "+marks.getSemYear()+"\nPaper Code: "+marks.getPaperCode()+
                			"\nPaper Title: "+marks.getPaperTitle()+"\nAverage: "+marks.getObMark());
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
