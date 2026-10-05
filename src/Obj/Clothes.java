package Obj;

import java.awt.*;

public class Clothes {
    int id;
    String name;
    Category category;
    Color avarageColor;

    public Clothes(int id, String name, Category category, Color avarageColor) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.avarageColor = avarageColor;
    }
    public String getName(){
        return name;
    }
    public Color getAvarageColor(){
        return avarageColor;
    }
}
