package com.bits.qa.testdata;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import com.bits.qa.base.TestBase;




public class DataBaseConnection extends TestBase

{

	public void test() throws ClassNotFoundException, SQLException {
	
	
		String UserName="Collabera_Spades";
	
		String Password="321@Sq@be5";
	
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	
		String DB_URL ="jdbc:sqlserver://gcisql01;databaseName=Workflow_Prod";
	
		Connection con = DriverManager.getConnection(DB_URL, UserName, Password);
		
		Statement smt =con.createStatement();
		
		ResultSet rs= smt.executeQuery("Select Sum(Payable_amount) as Payable_Commission from BITS2..tbl_freeze_master where period ='10/07/2019-11/03/2019' and Location = 'INDIA' and user_name='aakanksha.shaha'");
			
		System.out.println(rs);
}

}
