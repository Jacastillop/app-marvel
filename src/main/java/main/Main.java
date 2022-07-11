package main;

import connection.DBConnection;
import service.ConsumerApi;
import service.Messages;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class Main {
    private static final Connection CONNECTION = DBConnection.getConnection();
    private static final Messages message = Messages.getInstance();

    public static void main(String[] args) throws IOException {
    String hero = ConsumerApi.getCharacter("hulk");
    message.showMessage(hero);
    }
}
