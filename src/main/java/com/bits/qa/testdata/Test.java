package com.bits.qa.testdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

	public static void Test() {

		Connection con = null;

		String UserName = "Collabera_Spades";

		String Password = "321@Sq@be5";

		String DB_URL = "jdbc:sqlserver://gcisql01;databaseName=Workflow_Prod";

		String sqlquery = "Select Sum(Payable_amount) as Payable_Commission from BITS2..tbl_freeze_master where period ='10/07/2019-11/03/2019' and Location = 'INDIA' and user_name='aakanksha.shaha'";

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			con = DriverManager.getConnection(DB_URL, UserName, Password);

			Statement smt = con.createStatement();

			ResultSet rs = smt.executeQuery(sqlquery);

			rs.next();

			System.out.println(rs.getString("Payable_Commission"));

		}

		catch (Exception ex) {
			System.out.println(ex.toString());
		}

		finally {
			if (con != null) {
				con = null;
			}
		}

	}

}
