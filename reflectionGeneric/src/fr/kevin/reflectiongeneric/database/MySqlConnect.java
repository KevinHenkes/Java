package fr.kevin.reflectiongeneric.database;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public final class MySqlConnect {
    public Connection conn;

    private static MySqlConnect db;
    private MySqlConnect() {
        String url= "jdbc:mysql://localhost:3306/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";
        try {
            Class.forName(driver).newInstance();
            this.conn = (Connection)DriverManager.getConnection(url+dbName,userName,password);
        }
        catch (Exception sqle) {
            sqle.printStackTrace();
        }
    }

    public static synchronized MySqlConnect getDbCon() {
        if ( db == null ) {
            db = new MySqlConnect();
        }
        
        return db;
    }
    
    public ResultSet query(String query) throws SQLException{
        Statement statement = db.conn.createStatement();
        ResultSet res = statement.executeQuery(query);
        return res;
    }
}