package ColorDB;
import Obj.*;

import java.sql.*;

public class DbController {
    String url = "jdbc:sqlite:DressYourself.db";

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        try (Statement st = connection.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
    }

    public void initSchema(){
        String clothes = "CREATE TABLE IF NOT EXISTS Clothes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "category TEXT NOT NULL, "
                + "color INTEGER)";

        String outfits = "CREATE TABLE IF NOT EXISTS Clothes ("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "name TEXT NOT NULL, "
                + "Category TEXT NOT NULL, "
                + "Clothes TEXT NOT NULL)";

        try (Connection conn = getConnection();
            Statement statement = conn.createStatement()){
            statement.execute(clothes);
            statement.execute(outfits);
        } catch (SQLException e){
            System.err.println("Could not create a table" + e.getMessage());
        }
    }


    public Clothes findPieceOfClothnigByID(int id){
         initSchema();

        String sql = "SELECT id FROM Clothes WHERE id = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    //return rs.getString("name");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        return null;   // not found, or an error happened
    }

    public void saveClothes(Clothes clothes){}
    public Clothes findClothById(int id){return null;}
    public Category findClothingByCategory(Category category){return null;}

    public void deleteClothing(int id){}

    public void saveOutfit(){}

    public Outfit findOutfitByName(String name){return null;}

    public void deleteOutfit(){}

}
