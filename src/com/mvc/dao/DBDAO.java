package com.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBDAO {
	private static Connection dbCon;
	private static String dbURL;
	private static String dbDriver;
	private static String userName;
	private static String passWord;

	// --------------START------database initialization---------------
	/**
	 *
	 * @author: syamily
	 * @Date: 17/07/2024
	 * @version : v 1.0
	 * @purpose :Initialize database connection values
	 * @param :
	 *            Nothing
	 * @see : Nothing
	 * @return: Nothing
	 */
	private static void dbInit() {
		try {
			dbDriver = "com.mysql.cj.jdbc.Driver";
			dbURL = "jdbc:mysql://localhost:3306/luminarjsp";
			userName = "root";
			passWord = "Syamily@123";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// -------------END---------database initialization---------------

	// --------------START----------database connection ------------
	/**
	 *
	 * @author: syamily
	 * @Date: 17/07/2024
	 * @version : v 1.0
	 * @purpose : database connection
	 * @param :
	 *            Nothing
	 * @throws :
	 *             Exception in case of missing driver class
	 * @return: Connection
	 */

	public static void connect() throws ClassNotFoundException, SQLException {
		dbInit();
		Connection conn = null;
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbURL, userName, passWord);
			setDbCon(conn);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	// --------------START----------set db connection ------------

	/**
	 *
	 * @author : syamily
	 * @date :
	 * @version: v 1.0
	 * @purpose: Set Connection
	 * @param :
	 *            Connection
	 * @return : Nothing
	 */

	public static void setDbCon(Connection con) {
		dbCon = con;
	}
	// ------------------END-------------set connection---------

	// --------------START----------get db connection ------------
	/**
	 *
	 * @author : syamily
	 * @date :
	 * @version: v 1.0
	 * @purpose: Get Connection
	 * @param :
	 *            Nothing
	 * @return : Connection
	 */

	public static Connection getDbCon() {
		return dbCon;
	}
	// ------------------END-------------get connection---------

	// --------------START----------close connection ------------

	/**
	 *
	 * @author : syamily
	 * @date :
	 * @version: v 1.0
	 * @purpose: Close connection
	 * @param :
	 *            Nothing
	 * @throws :Exception
	 *             in case of closing connection
	 * @return : Nothing
	 */

	public static void close() throws SQLException {
		dbCon.close();
	}
	// ------------------END-------------closing connection---------
}
