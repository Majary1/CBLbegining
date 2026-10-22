package ColorDB;


import Obj.Outfit;

import javax.swing.*;
import java.awt.*;

public class ColorTheory {


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
        for(int i = 0; i<length;i++){
            for(int j = 0;j<length;j++){
                 Color color1 = outfit.partsOfOutfit.get(i).getAvarageColor();
                Color color2 = outfit.partsOfOutfit.get(j).getAvarageColor();
                if(!isMatching(color1,color2)){
                    isFit = false;

                }
            }
        }
        if(isFit){
            JOptionPane.showMessageDialog(null,"Great Outfit!");
        } else {
            JOptionPane.showMessageDialog(null,"This is not the best match :(");
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
