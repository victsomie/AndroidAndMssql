package com.example.pi.androidandmssql.helpers;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Victor on 8/26/2017.
 *
 * This is the db connection class
 *
 */

public class ConnectionClass {
    String ip = "192.168.0.100"; // The IP address or server name of your PC or server where your database is stored.
    String  classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "Andro";
    String un = "hitesh"; // Username
    String password = "789";  // User password


    // This will return the Connection object for connecting with the server.
    public Connection CONN(){
        StrictMode.ThreadPolicy policy =  new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;

        try{
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://"+ip+";"
                    + "databaseName=" + db + ";user=" + un+"password="
                    + password + ";";
            conn = DriverManager.getConnection(ConnURL);

        }catch (SQLException se){
            Log.e("ERRO", se.getMessage());
        }catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }

        return conn;
    }
}