package main;

import model.Character;
import service.Messages;
import service.MyScanner;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    private static final Messages message = Messages.getInstance();
    static MyScanner scanner = MyScanner.getInstance();


    public static void main(String[] args) throws IOException, SQLException {
        AppMarvel myAppMarvel = new AppMarvel();
        message.showMessage("Insert name");
        Character character = myAppMarvel.getCharacter(scanner.getString());
        message.showMessage(character.toString());
        myAppMarvel.crateCharacter(character);

    }
}
