package diff_file_Url_and_Driver;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class fetchingUsingDiffFile {
	public static void main(String[] args) throws IOException, SQLException {
		
		FileInputStream f = new FileInputStream("C:\\Users\\KIIT\\Desktop\\File\\Jspider\\JAVA Advance\\A4\\com.jdbc.advance\\lib\\jdbc.properties");
			
		Properties p = new Properties();
		p.load(f); 	// loading the properties 
		try {
			Class.forName(p.getProperty("driver"));
			Connection c = DriverManager.getConnection(p.getProperty("url"));
			Statement s = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = s.executeQuery("select * from premium_student order by age");
			if(rs.absolute(2)) {
				System.out.println(rs.getInt("age")+"\t"+rs.getString("name")+"\t"+rs.getInt("score"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
}
