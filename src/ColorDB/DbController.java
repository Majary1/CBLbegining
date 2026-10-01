package ColorDB;
import Obj.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbController {
    String url = "jdbc:sqlite:DressYourself.db";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        try (Statement st = connection.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }

    public void saveClothes(Clothes clothes){

    }

    public Clothes findPieceOfClothnigByName(String name){return null;}

    public Category findClothingByCategory(Category category){return null;}

    public void deleteClothing(int id){}

    public void saveOutfit(){}

    public Outfit findOutfitByName(String name){return null;}

    public void deleteOutfit(){}

}
