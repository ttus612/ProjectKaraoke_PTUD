    
package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author THANHTU
 */
public class ConnectDB {
    public static Connection con = null;
    private static ConnectDB instance = new ConnectDB();
    public static ConnectDB getIntance(){
        return instance;
    }

    public static void getinstance() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void connect() throws SQLException{
        String url = "jdbc:sqlserver://localhost:1433;databaseName=KaraokeCGV";
	String user = "sa";
	String password = "sapassword";
        con = DriverManager.getConnection(url, user, password);
    }
    
    public void disconnect(){
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static Connection getConnection(){
        return con;
    }
}
