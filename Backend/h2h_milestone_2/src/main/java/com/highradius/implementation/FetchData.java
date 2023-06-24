package com.highradius.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.highradius.connection.DBConnection;

public class FetchData {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement ps = null;

		// The object of ResultSet maintains a cursor pointing to a row of a table.
		// Initially, cursor points to before the first row.
		ResultSet rs = null;
		try {
			System.out.println("Fetching records without condition...");
			String query = "SELECT * FROM h2h_oap";
			conn = DBConnection.connect();
			// The createStatement() method of Connection interface is used to create
			// statement.
			stmt = conn.createStatement();
			// The executeQuery() method of Statement interface is used to execute queries
			// to the database.
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				System.out.println(rs.getString(1) + "  " + rs.getString(2));
			}
			System.out.println("Fetching records with condition...");
			
			String query2 = "SELECT Sl_no FROM h2h_oap WHERE Sl_no BETWEEN  1 and 10";
			ps = conn.prepareStatement(query2);
			System.out.println(ps.toString());
			rs = ps.executeQuery();
			while (rs.next()) {
			    System.out.print("ID: " + rs.getInt("Sl_no"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// By closing connection object statement and ResultSet will be closed
				// automatically.
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}