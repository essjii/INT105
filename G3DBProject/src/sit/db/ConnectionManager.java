
package sit.db;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.derby.jdbc.ClientDataSource;


public class ConnectionManager {
    public static Connection createConnection
        (String url, String username, String psw) 
        throws ClassNotFoundException, SQLException{
            
//        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
//        System.out.println("Driver class registed successfully");
        
        Connection cn = DriverManager.getConnection(url,username, psw);
        System.out.println("Driver class registed successfully");
        return cn;
    }
        
    public static Connection createConnection(String fileName) throws FileNotFoundException, IOException, SQLException{
        FileReader dbPropFile = new FileReader(fileName);
        Properties dbProp = new Properties();
        dbProp.load(dbPropFile);
        //read database properties from file db.properties
        String serverName = dbProp.getProperty("DERBY_SERVER_NAME");
        String tempPort = dbProp.getProperty("DERBY_SERVER_PORT");
        int serverPort = Integer.parseInt(tempPort); //change String to integer
        String dbName = dbProp.getProperty("DERBY_DB_NAME");
        String dbUser = dbProp.getProperty("DERBY_DB_USERNAME");
        String dbPsw = dbProp.getProperty("DERBY_DB_PASSWORD");
        //set properties to datasource
        ClientDataSource ds = new ClientDataSource();
        ds.setServerName(serverName);
        ds.setPortNumber(serverPort);
        ds.setDatabaseName(dbName);
        ds.setUser(dbUser);
        ds.setPassword(dbPsw);
        //create connect database
        Connection cn = ds.getConnection();
        return cn;
    }
        
    public static void closeConnection(Connection cn) throws SQLException{
        cn.close();
    }
        
}
