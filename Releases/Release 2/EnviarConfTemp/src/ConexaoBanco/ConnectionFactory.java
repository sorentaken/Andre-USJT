package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionFactory 
{    
	public static Connection getConnection()
	{        
		try {            
			return DriverManager.getConnection("jdbc:mysql://localhost/Empresa","root","dnyws4nx"); 
			}       	
		catch(SQLException excecao) 
		{        
			throw new RuntimeException(excecao);     
			}    
		} 
	}


