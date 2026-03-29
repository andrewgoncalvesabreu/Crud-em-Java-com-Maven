package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String url = "jdbc:mysql://sql.freedb.tech:3306/freedb_db-andrew";
    private static final String user = "freedb_freedb_user321";
    private static final String password = "cV%Z&F8A5bqDKew";

    public static Connection fazConexao(){

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
