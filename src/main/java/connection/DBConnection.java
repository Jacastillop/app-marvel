package connection;

import service.Messages;
import service.PreferencesServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection = null;
    private static PreferencesServices preferencesServices = PreferencesServices.getInstance();
    private static final Messages message = Messages.getInstance();

    static {
        try {
            Class.forName(preferencesServices.getKey("DRIVER"));
        } catch (ClassNotFoundException e) {
            message.showMessage("Error en el driver: " + e);
        }
    }

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(preferencesServices.getKey("URL"), preferencesServices.getKey("USER"), preferencesServices.getKey("PASSWORD"));
        } catch (SQLException e) {
            message.showMessage("Conexion fallida: " + e);
        }
        return connection;
    }

}

