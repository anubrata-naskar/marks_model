package user;

import java.sql.SQLException;
import javax.swing.JFileChooser;

public class Upload_details {
	private static JFileChooser jFileChooser1;
		
	//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
	//upload-detailsgg
	public void uploadData() throws SQLException  {
		
		String path ="";
		jFileChooser1 = new javax.swing.JFileChooser();
		int res = jFileChooser1.showSaveDialog(null);
		if(res == JFileChooser.APPROVE_OPTION) {
			path = jFileChooser1.getSelectedFile().getAbsolutePath();
      	try {
				new Excel().readExcel(path);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      }
		
//    	String path = "C:\\Users\\Shetasree\\Desktop\\btech1.xlsx";
//    	new Excel().readExcel(path);
    }
	//upload-details
	
	
}