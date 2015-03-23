package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Tester {

	private final static String hostname = "jdbc:mysql://localhost/";
	private final static String dbName = "databaseassignment";
	private final static String username = "root";
	private final static String password = "";
	public static Connection con;
	/**
	 * This class is just to test individual classes
	 * @param args
	 */
	public static void main(String[] args) {
		Tester.test();
	}






	private static void connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(hostname + dbName, username, password);
		}catch(SQLException ex){
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static void test(){
		Date temp = new Date();
		System.out.println(temp);
		Tester.connect();
		String querry = "SELECT * FROM `test`";	
		try{
			Statement testStmnt = con.createStatement();
			ResultSet testRss = testStmnt.executeQuery(querry);
			testRss.next();
			int temp2 = testRss.getInt(1);
			System.out.println(temp2);
			Tester.close();
		}catch (SQLException e){
			e.printStackTrace();
		}
		
	}

	private static void close() {
		try {
			con.close();
		}catch (SQLException ex){
			ex.printStackTrace();
		}

	}
}






/*
import java.sql.*;


public class DBConnect {
    private Connection con;
    private Statement st;
    private ResultSet rs;


    public DBConnect(){
        try{
           Class.forName("com.mysql.jdbc.Driver"); 

           con = DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
           //st = con.createStatement();

        }catch(Exception ex){
          System.out.println("Error:" +ex);  
          ex.printStackTrace();
        }
    }

    /*
    public void getData(){
        try{

            String query = "select * from Users";
            rs = st.executeQuery(query);
            System.out.println("Records from Database");
            while(rs.next()){
                String name = rs.getString("UserName");
                //String password = rs.getString("Password");
                System.out.println("Name: "+ name);

            }

        }catch(Exception ex){
            System.out.println(ex);
        }
    }
 */
