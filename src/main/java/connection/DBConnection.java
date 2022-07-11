package connection;

import service.Messages;
import service.Preferences;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;
    private static Preferences preferences = Preferences.getInstance();
    private static final Messages message = Messages.getInstance();

    static {
        try {
            Class.forName(preferences.getKey("DRIVER"));
        } catch (ClassNotFoundException e) {
            message.showMessage("Error en el driver: " + e);
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(preferences.getKey("URL"), preferences.getKey("USER"), preferences.getKey("PASSWORD"));
        } catch (SQLException e) {
            message.showMessage("Conexion fallida: " + e);
        }
        return connection;
    }

}

