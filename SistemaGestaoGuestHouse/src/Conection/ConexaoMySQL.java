package Conection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoMySQL  {

    private static Connection connection;
    private static String URL = "jdbc:mysql://127.0.0.1:3306/guesthouse";
    private static String USER = "root";
    private static String PASSWORD = "";


    public static Connection obterConexao() throws SQLException {
        if(connection == null) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    public static void main(String[] args) throws SQLException {
        System.out.println(obterConexao());
    }


    public void fecharConexao() throws SQLException {
        if(connection != null)
            connection.close();
    }

}
