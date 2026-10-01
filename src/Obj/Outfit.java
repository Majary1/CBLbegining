package Obj;
import ColorDB.*;

import java.util.EnumMap;

public class Outfit {
    int id;
    String name;
    EnumMap<Category, Clothes> Cateogry;

    public Outfit(int id, String name, EnumMap<Category, Clothes> cateogry) {
        this.id = id;
        this.name = name;
        Cateogry = cateogry;
    }
}
