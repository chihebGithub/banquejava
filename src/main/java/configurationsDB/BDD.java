package configurationsDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD {
	Connection connection;
	Statement statement;
	String  SQL;
	
	public void connexionDatabase() throws SQLException{
		this.connection= DatabaseConnection.getInstance().getConnection();
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
	
	public BDD() {
		super();
	}
	public ResultSet executionQuery(String sql) throws SQLException
	{
		connexionDatabase();
		ResultSet resultSet=null;
		
		try {
			statement=connection.createStatement();
		
			resultSet=statement.executeQuery(sql);
			System.out.println(sql);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultSet;
	}
	
	public String executeUpdate(String sql) throws SQLException
	{
		connexionDatabase();
		String result="";
		
		statement=connection.createStatement();
		statement.executeUpdate(sql);
		result=sql;
		
		
		return result;
		
	}
	
	public ResultSet querySelectAll(String nomTable) throws SQLException
	{
		connexionDatabase();
		SQL="SELECT * FROM "+nomTable;
		System.out.println(SQL);
		return this.executionQuery(SQL);
		
	}
	
	public ResultSet querySelectAll(String nomTable,String etat) throws SQLException
	{
		connexionDatabase();
		SQL="SELECT * FROM "+nomTable+" WHERE "+etat;
		System.out.println(SQL);
		return this.executionQuery(SQL);
		
	}
	
	public ResultSet querySelect(String[]nomColonne,String nomTable) throws SQLException
	{
		connexionDatabase();
		SQL="Select ";
		int i;
		for(i=0;i<=nomColonne.length-1;i++)
		{SQL+=nomColonne[i];
		 if(i<nomColonne.length-1)
			SQL+=",";
			
		}
		
		SQL+=" FROM "+nomTable;
		System.out.println(SQL);
		return this.executionQuery(SQL);
		
		
		
	}
public ResultSet fcSelectComand(String[]nomColonne,String nomTable,String etat) throws SQLException	
{
	
	connexionDatabase();
	int i;
	SQL="select ";
	for(i=0;i<=nomColonne.length-1;i++)
	{SQL+=nomColonne[i];
	 if(i<nomColonne.length-1)
		SQL+=",";
		
	}
	
	SQL+=" FROM "+nomTable+" where "+etat;
	System.out.println(SQL);
	return this.executionQuery(SQL);
	
}

public String queryInsert(String nomTable,String[]contenuTAbleau) throws SQLException
{
	connexionDatabase();
	
	int i;
	SQL="INSERT INTO "+nomTable+" VALUES(";
	for(i=0;i<=contenuTAbleau.length-1;i++)
	{SQL+="'"+contenuTAbleau[i];
	 if(i<contenuTAbleau.length-1)
		SQL+="',";
	
	
		
	}
	
	SQL+="')";
	System.out.println(SQL);
	return this.executeUpdate(SQL);
	



}

public String queryInsert(String nomTable,String[]nomColonne,String[]contenuTAbleau) throws SQLException
{
	connexionDatabase();
	
	int i;
	SQL="INSERT INTO "+nomTable+"(";
	for(i=0;i<=nomColonne.length-1;i++)
	     {SQL+=nomColonne[i];
	 if(i<nomColonne.length-1)
		SQL+=",";
		
	}
	
	SQL+=")VALUES(";
	for(i=0;i<=contenuTAbleau.length-1;i++)
	{SQL+="'"+contenuTAbleau[i]+"'";
	 if(i<contenuTAbleau.length-1)
		SQL+=",";
		
	}
	SQL+=")";
	System.out.println(SQL);
	return this.executeUpdate(SQL);
}

public String queryUpdate(String nomTable,String[]nomColonne,String[]contenuTAbleau,String etat) throws SQLException
{
	connexionDatabase();
	
	int i;
	SQL="Update "+nomTable+" set ";
	for(i=0;i<=nomColonne.length-1;i++)
	     {SQL+=nomColonne[i]+"='"+contenuTAbleau[i]+"'";
	 if(i<nomColonne.length-1)
		SQL+=",";
		
	}
	
	SQL+="where "+etat;
	System.out.print(SQL);
return this.executeUpdate(SQL);
}






	 public String QueryDelete(String nomTAble) throws SQLException
	 {
		 connexionDatabase();
		 SQL="Delete from "+nomTAble;
		 return this.executeUpdate(SQL);
	 
	 }
	 
	 public String QueryDelete(String nomTAble,String nomcolonne) throws SQLException
	 {
		 connexionDatabase();
		 SQL="Delete from "+nomTAble+" where "+nomcolonne;
		 return this.executeUpdate(SQL);
	 
	 } 
	 
	public String queryDelete(String nomTable,String etat) throws SQLException 
	{
		
		connexionDatabase();
		SQL="delete from "+nomTable+" where "+etat;
		
			return this.executeUpdate(SQL);
		
		
	}
	 
	public String queryDelete(String nomTable) throws SQLException 
	{
		
		connexionDatabase();
		SQL="delete from "+nomTable;
		
			return this.executeUpdate(SQL);
		
		
	}	 
	
}