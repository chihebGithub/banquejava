package configurationsDB;

import java.sql.Connection;
import java.sql.SQLException;


import java.sql.DriverManager;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private  Connection connection;
    public  String IPHOST="127.0.0.1";//adresse de bouclage
    private String url = "jdbc:mysql://"+IPHOST+":3306/banque";
    private String username = "root";
    private String password = "";

    private DatabaseConnection() throws SQLException {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }catch(SQLException  e) {
        	System.out.println("SLV demarer votre SGBD");
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
