package Obj;
import ColorDB.*;

import java.util.ArrayList;
import java.util.EnumMap;

public class Outfit {
    int id;
    String name;
    EnumMap<Category, Clothes> Cateogry;
    public ArrayList<Integer> partsOfOutfit;
    int current;
    public Outfit(int id, String name, EnumMap<Category, Clothes> cateogry) {
        this.id = id;
        this.name = name;
        Cateogry = cateogry;
        partsOfOutfit = new ArrayList<>();
        current = 0;
    }
    public void addToCurrentOutfit(Clothes cloth){
        partsOfOutfit.add(cloth.id);

    }
    public void removeFromCurrentOutfit(Clothes cloth){
        partsOfOutfit.remove(cloth.id);
    }
}
