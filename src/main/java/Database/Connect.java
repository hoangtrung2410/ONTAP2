package Database;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public
class Connect {
    public static
    Connection getConnection() {
        Connection conn = null;
        try {
            //Dang ki mssql sever
            DriverManager.registerDriver(new SQLServerDriver());
            //cac thong so

            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=nhasach;";

            String user = "sa";
            String pass = "123456aA@$";
            // tao ket noi
            conn = DriverManager.getConnection(dbURL, user, pass);


        } catch (Exception e) {
            e.printStackTrace();
        }
       return conn;
    }
    public static void  closeConnection(Connection conn){
        try{
            if(conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static void information(Connection conn){
        try{
            if(conn!=null){
                DatabaseMetaData mtdt=conn.getMetaData();
                System.out.println(mtdt.getConnection());
                System.out.println(mtdt.getDatabaseProductName());
                System.out.println(mtdt.getDatabaseProductVersion());
            }


        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
