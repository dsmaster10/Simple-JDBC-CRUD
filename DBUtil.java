package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection()throws Exception{
        Connection conn=null;

            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/very_first_database","root","Password");
        return conn;
    }
    public static void closeConnection(Connection conn)throws Exception{
            conn.close();
    }
}
