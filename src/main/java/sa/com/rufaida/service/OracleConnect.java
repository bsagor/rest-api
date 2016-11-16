package sa.com.rufaida.service;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleConnect {
	public Connection conn;
    public static OracleConnect db;
    public OracleConnect() {
        String url= "jdbc:oracle:thin:@weblogic-pc:1521:HMIS";
        String dbName = "database_name";
        String driver = "oracle.jdbc.driver.OracleDriver";
        String userName = "medisys";
        String password = "medisys";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }
    /**
     *
     * @return MysqlConnect Database connection object
     */
    public static synchronized OracleConnect getDbCon() {
        if ( db == null ) {
            db = new OracleConnect();
        }
        return db;
 
    }
    
}
