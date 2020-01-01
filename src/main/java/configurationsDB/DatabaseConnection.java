package configurationsDB;

import java.sql.Connection;
import java.sql.SQLException;


import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private  Connection connection;
   // public  String IPHOST="127.0.0.1";//adresse de bouclage
  public  String IPHOST="mysql20.mysql.database.azure.com";//adresse de bouclage
    private String url = "jdbc:mysql://"+IPHOST+":3306/banque?useSSL=true&requireSSL=false";
    private String username = "chiheb@mysql20";
    private String password = "Rabeh2020";

    private DatabaseConnection() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            //this.connection = DriverManager.getConnection(url, username, password);
            this.connection =  DriverManager.getConnection("jdbc:mysql://mysql20.mysql.database.azure.com:3306/banque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "chiheb@mysql20", "Rabeh2020");
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
     	if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

       
       return instance;
    }
    
	public Connection closeconnexion(){
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
    
    
    
    
    
}
