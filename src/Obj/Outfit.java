package Obj;
import ColorDB.*;

import java.util.ArrayList;
import java.util.EnumMap;

public class Outfit {
    int id;
    String name;
    Category category;
    public Clothes[] partsOfOutfit;

    int current;
    public Outfit(int id, String name, Category category, Clothes[] clothes) {
        this.id = id;
        this.name = name;
        this.category = category;
        partsOfOutfit = clothes;
        current = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCateogry() {
        return category;
    }

    public Clothes[] getPartsOfOutfit() {
        return partsOfOutfit;
    }
}
