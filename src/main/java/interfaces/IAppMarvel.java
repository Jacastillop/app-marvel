package interfaces;

import java.io.IOException;
import java.sql.SQLException;
import model.Character;

public interface IAppMarvel {
    Character getCharacter(String name) throws IOException;
    void crateCharacter(Character character) throws SQLException;
}
