package interfaces;

import java.sql.SQLException;

public interface IAppMarvel {
    void getCharacter();
    void crateCharacter(Character character) throws SQLException;
}
