package ColorDB;


import Obj.Outfit;

import javax.swing.*;
import java.awt.*;

public class ColorTheory {

    // Checks in which percent the outfit is matching

    public void check(Outfit outfit){
        int length = outfit.partsOfOutfit.size();
        if(length<2){
            switch (length){
                case 0->JOptionPane.showMessageDialog(null,"Maybe first try putting something on ;) ");
                case 1 ->JOptionPane.showMessageDialog(null,"Add something more!!!");
            }

            return;
        }
        boolean isFit = true;
        float operations = 0;
        float sum = 0;
        for(int i = 0; i<length;i++){
            for(int j = i+1;j<length;j++){
                 Color color1 = outfit.partsOfOutfit.get(i).getAvarageColor();
                Color color2 = outfit.partsOfOutfit.get(j).getAvarageColor();
                operations++;
                if(isMatching(color1,color2)){
                    sum+=100;

                }
            }
        }
        float result =  (float)(sum/operations);
        JOptionPane.showMessageDialog(null,"Your fit is a match in " + String.format("%.1f",result) + "%.");


    }

    //Application of color theory (checks in mathematical way)

    public boolean isMatching(Color i, Color j){
         ColorAnalyze infoI = new ColorAnalyze(i);
         ColorAnalyze infoJ = new ColorAnalyze(j);

         if(infoI.getSaturation()<0.15 || infoJ.getSaturation()<0.15){
             return true;
         }
         // Calculates the accurate distance between two colors on the color wheel
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
