package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Product;


	public class DataBase {

		private static DataBase instancia;
		
		private String driver="com.mysql.cj.jdbc.Driver";
		private String host="localhost";
		private String port="3306";
		private String user="javaM";
		private String password="himitsu";
		private String db="javaMarket";
		private int conectados=0;
		private Connection conn=null;
		
		private DataBase() {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public static DataBase getInstancia() {
			if (instancia == null) {
				instancia = new DataBase();
			}
			return instancia;
		}
		
		public Connection getConn() {
			try {
				if(conn==null || conn.isClosed()) {
					conn=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, password);
					conectados=0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conectados++;
			return conn;
		}
		
		public void releaseConn() {
			conectados--;
			try {
				if (conectados<=0) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

