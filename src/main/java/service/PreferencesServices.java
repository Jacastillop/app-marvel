package service;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PreferencesServices {
    private static final String PATH = "src/main/resources/Configuration.properties";
    private static final Messages message = Messages.getInstance();
    private static Properties properties= new Properties();
    private static PreferencesServices instance = null;

    public static PreferencesServices getInstance() {
        if (instance instanceof PreferencesServices) {
            return instance;
        } else {
            instance = new PreferencesServices();
        }
        return instance;
    }

    public static String getKey(String value){

        try {
            properties.load(new FileReader(PATH));
        } catch (FileNotFoundException e){
            message.showMessage("Archivo no encontrado : " + e);
        } catch (IOException e) {
            message.showMessage("IOException : " + e);
        }
        return properties.getProperty(value);
    }

}
