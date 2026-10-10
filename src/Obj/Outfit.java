package Obj;
import ColorDB.*;

import java.util.ArrayList;
import java.util.EnumMap;

public class Outfit {
    int id;
    String name;
    Category category;
    public ArrayList<Clothes> partsOfOutfit;
    private final int numberOfElements =5;
    int current;
    public Outfit(int id) {
        this.id = id;
        partsOfOutfit = new ArrayList<>();


        current = 0;
    }
    public void addClothToOutfit(Clothes clothes){
        partsOfOutfit.add(clothes);
    }
    public void removeClothFromOutfit(Clothes clothes){
        partsOfOutfit.remove(clothes);
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

    public ArrayList<Clothes> getPartsOfOutfit() {
        return partsOfOutfit;
    }
    public boolean isThisCategoryInOutfit(Clothes clothes){
        for(int i=0;i<partsOfOutfit.size();i++){
            if(partsOfOutfit.get(i).getCategory()==clothes.getCategory()){
                return true;
            }
        }
        return false;
    }
    public void removeByCategory(Category category){
        for(int i=0;i<partsOfOutfit.size();i++){
            if(partsOfOutfit.get(i).getCategory()==category){
                removeClothFromOutfit(partsOfOutfit.get(i));
            }
        }

    }

}
