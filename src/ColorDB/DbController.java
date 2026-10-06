package ColorDB;
import Obj.*;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbController {
    String url = "jdbc:sqlite:src/AddFiles/DataBase.db";

    public Connection getConnection() throws SQLException {
        /*
        Connection connection = DriverManager.getConnection(url);
        try (Statement st = connection.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }
        return connection;
         */

        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("SQLite driver found");
        } catch (ClassNotFoundException e) {
            System.out.println("SQLite driver NOT found");
        }

        System.out.println("Connecting to: " + url);

        Connection connection = DriverManager.getConnection(url);

        try (Statement st = connection.createStatement()) {
            st.execute("PRAGMA foreign_keys = ON");
        }

        return connection;
    }

/*
// This fnuction is not needed yet in case it is would be in a future it is left written here!
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
 */

    public Clothes findPieceOfClothnigByID(int id){
        String sql = "SELECT ID, NAME, CATEGORY, COLOR FROM CLOTHES WHERE ID = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int clothesId = rs.getInt("ID");
                    String clothesName = rs.getNString("NAME");
                    String clothesCategory = rs.getString("CATEGORY");
                    String clothesColor = rs.getString("COLOR");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        return null;
    }

    public List<Clothes> showClothesByCategory(Category category){

        List<Clothes> clothesList = new ArrayList<>();
        String sql = "SELECT ID, NAME, CATEGORY, COLOR FROM CLOTHES WHERE CATEGORY = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, category.name());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int clothesId = rs.getInt("ID");
                    String clothesName = rs.getString("NAME");
                    Category clothesCategory = Category.valueOf(rs.getString("CATEGORY"));
                    String clothesColor = rs.getString("COLOR");
                    Color color = parseColor(clothesColor);
                    Clothes cloth = new Clothes(clothesId,clothesName,clothesCategory,color);
                    clothesList.add(cloth);
                }
            }
        } catch (SQLException e) {
            System.err.println("Couldn't load the clothes " + e.getMessage());
        }
        return clothesList;
    }

    public boolean saveClothes(Clothes clothes){
        String sql = "INSERT INTO CLOTHES (ID, NAME, CATEGORY, COLOR) VALUES (?, ?, ?, ?)";
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, clothes.getId());
            ps.setString(2, clothes.getName());   // enum -> text
            ps.setString(3, clothes.getCategory().name());
            //we change the format to r,g,b not some strange idk
            Color avarageColor = clothes.getAvarageColor();
            ps.setString(4, avarageColor.getRed()+","+ avarageColor.getGreen()+","+avarageColor.getBlue());

            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            System.err.println("Could not save clothes: " + e.getMessage());
            return false;
        }
    }

    public Category findClothingByCategory(Category category){
        String sql = "SELECT ID, NAME, CATEGORY, CLOTHES FROM OUTFITS WHERE CLOTHES = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, String.valueOf(category));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int outfitsId = rs.getInt("ID");
                    String outfitsName = rs.getNString("NAME");
                    String outfitsCategory = rs.getString("CATEGORY");
                    String outfitsClothes = rs.getString("CLOTHES");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        return null;
    }

    public boolean deleteClothing(int id){
        String sql = "DELETE FROM CLOTHES WHERE ID = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            return  ps.executeUpdate() == 1;
        }
        catch (SQLException e){
            System.err.println("Could not delete clothing" + e.getMessage());
            return false;
        }
    }

    public boolean saveOutfit(Outfit outfit){
        String sql = "INSERT INTO OUTFITS (ID, NAME, CATEGORY, CLOTHES) VALUES (?, ?, ?, ?)";
        try(Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, outfit.getId());
            ps.setString(2, outfit.getName());   // enum -> text
            ps.setString(3, outfit.getCateogry().name());

            StringBuilder clothesIds = new StringBuilder();

            for (Clothes clothes : outfit.getPartsOfOutfit()) {
                if (clothesIds.length() > 0) {
                    clothesIds.append(",");
                }

                clothesIds.append(clothes.getId());
            }

            ps.setString(4, clothesIds.toString());

            return ps.executeUpdate() == 1;
        } catch (SQLException e){
            System.err.println("Could not save recipe: " + e.getMessage());
            return false;
        }
    }

    public Outfit findOutfitByName(String name){
        String sql = "SELECT ID, NAME, CATEGORY, CLOTHES FROM OUTFITS WHERE NAME = ?";
        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int outfitsId = rs.getInt("ID");
                    String outfitsName = rs.getNString("NAME");
                    String outfitsCategory = rs.getString("CATEGORY");
                    String outfitsClothes = rs.getString("CLOTHES");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        return null;   // not found, or an error happened
    }

    public boolean deleteOutfit(int id){
        String sql = "DELETE FROM OUTFITS WHERE ID = ?";

        try (Connection c = getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, id);

            return  ps.executeUpdate() == 1;
        }
        catch (SQLException e){
            System.err.println("Could not delete clothing" + e.getMessage());
            return false;
        }
    }
    private Color parseColor(String color) {
        try {
            String[] rgb = color.split(",");
            int r = Integer.parseInt(rgb[0]);
            int g = Integer.parseInt(rgb[1]);
            int b = Integer.parseInt(rgb[2]);
            return new Color(r, g, b);
        } catch (Exception e) {
            return Color.GRAY;
        }
    }
}
