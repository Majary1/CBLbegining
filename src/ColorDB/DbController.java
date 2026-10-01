package ColorDB;
import Obj.*;

import java.sql.Connection;
import java.util.List;

public class DbController {
    String url;

    public Connection getConnection(){return null;}

    public void saveClothes(Clothes clothes){}

    public Clothes findPieceOfClothnigByName(String name){return null;}

    public Category findClothingByCategory(Category category){return null;}

    public void deleteClothing(int id){}

    public void saveOutfit(){}

    public Outfit findOutfitByName(String name){return null;}

    public void deleteOutfit(){}

}
