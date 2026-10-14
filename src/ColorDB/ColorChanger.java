package ColorDB;

import java.awt.*;
import java.awt.image.BufferedImage;
//**
// Changes the colors of cloth icons and images, used in Character panel and clothing cards
// ex: every "original" buffered image is in cream color by default, so we take the color that we had
// set for the pice of clothing, and we change the color of the cloth in the image
// We use here buffered image, because it allows to modify the images
// *//
public class ColorChanger {
    public static BufferedImage colorChange(BufferedImage original, Color targetedColor){
        //TYPE_INT_ARGB defines the type in which the new image has to be saved
        BufferedImage newImage = new BufferedImage(original.getWidth(),original.getHeight(),BufferedImage.TYPE_INT_ARGB);
        for(int x = 0 ; x<original.getWidth();x++){
            for(int y =0 ;y<original.getHeight();y++){
                int pixel = original.getRGB(x,y);
                Color oldColor = new Color(pixel,true);
                if(oldColor.getAlpha()==0){
                    newImage.setRGB(x,y,pixel);
                    continue;
                }
                //**
                // calculates the brightness of the old color by taking every value (Red, Green, Blue),
                // which ranges from 0-255, and divides it by maximal possible sum
                // *//
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
