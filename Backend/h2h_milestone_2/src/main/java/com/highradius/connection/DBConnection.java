package com.highradius.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
  // connection url jdbc:mysql://ipAddress:portnumber/databasename
  // Create H2H_DEMO IN MYSql Workbench or SQLyog
  static final String URL = "jdbc:mysql://localhost:3306/h2h10962k";
  // Database username
  static final String USER = "root";
  // Database password
  static final String PASS = "C_20051685";

  public static Connection connect() throws SQLException {
    Connection con = null;

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(URL, USER, PASS);
      if (con == null) {
        System.out.println("Connection cannot be established");
      }
      return con;
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

}