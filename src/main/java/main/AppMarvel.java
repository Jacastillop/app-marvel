package main;

import com.google.gson.Gson;
import connection.DBConnection;
import interfaces.IAppMarvel;
import org.json.JSONArray;
import org.json.JSONObject;
import service.ConsumerApi;
import service.Messages;
import model.Character;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppMarvel implements IAppMarvel {
    private static final Connection CONNECTION = DBConnection.getConnection();
    private static final Messages message = Messages.getInstance();

    @Override
    public Character getCharacter(String name) throws IOException {
        final Gson gson = new Gson();
        String response = ConsumerApi.response(name);
        JSONObject jsonResponse = new JSONObject(response);
        JSONObject data = jsonResponse.getJSONObject("data");
        JSONArray result = data.getJSONArray("results");
        return gson.fromJson(result.getJSONObject(0).toString(), Character.class);
    }

    @Override
    public void crateCharacter(Character character) throws SQLException {
        String query = "INSERT INTO marvel.character(id, name, description) VALUES(?,?,?)";
        try (PreparedStatement ps = CONNECTION.prepareStatement(query)) {
            ps.setInt(1,character.getId());
            ps.setString(2,character.getName());
            ps.setString(3,character.getDescription());
            ps.executeUpdate();
            message.showMessage("CONTACT CREATED SUCCESSFULLY");
        } catch (SQLException e) {
            message.showMessage("SQLException: "+e);
        }
    }
}
