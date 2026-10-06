package ColorDB;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ColorChanger {
    public static BufferedImage colorChange(BufferedImage original, Color targetedColor){
        BufferedImage newImage = new BufferedImage(original.getWidth(),original.getHeight(),BufferedImage.TYPE_INT_ARGB);
        for(int x = 0 ; x<original.getWidth();x++){
            for(int y =0 ;y<original.getHeight();y++){
                int pixel = original.getRGB(x,y);
                Color oldColor = new Color(pixel,true);
                if(oldColor.getAlpha()==0){
                    newImage.setRGB(x,y,pixel);
                    continue;
                }
                float brightness = (oldColor.getBlue()+oldColor.getGreen()+oldColor.getRed())/(3.0f*255.0f);
                int newR = (int)((targetedColor.getRed())*brightness);
                int newG = (int)((targetedColor.getGreen())*brightness);
                int newB = (int)((targetedColor.getBlue())*brightness);
                Color newColor = new Color(newR,newG,newB);
                newImage.setRGB(x,y,newColor.getRGB());
            }
        }
        return newImage;
    }
}
