package ColorDB;

import Obj.Outfit;

import java.awt.*;

public class ColorTheory {


    public void check(Outfit outfit){
        int length = outfit.partsOfOutfit.length;
        for(int i = 0; i<length;i++){
            for(int j = 0;j<length;j++){

            }
        }

    }
    public boolean isMatching(Color i, Color j){
         ColorAnalyze infoI = new ColorAnalyze(i);
         ColorAnalyze infoJ = new ColorAnalyze(j);

         if(infoI.getSaturation()<0.15 || infoJ.getSaturation()<0.15){
             return true;
         }

         float distance = Math.min(Math.abs(infoI.getHue()-infoJ.getHue()),360-Math.abs(infoI.getHue()-infoJ.getHue()));
         if(distance<=60){
             return true;
         }
         if(distance>=160 && distance<=180){
             return true;
         }
         return false;
    }


}
