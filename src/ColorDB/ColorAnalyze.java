package ColorDB;

import java.awt.*;

public class ColorAnalyze {
    private float hue;
    private float saturation;
    private float brightness;
    public ColorAnalyze(Color color){
        float[] hsb = Color.RGBtoHSB(color.getRed(),color.getGreen(),color.getBlue(),null);
        hue = hsb[0]*360;
        saturation= hsb[1];
        brightness = hsb[2];
    }
    public float getHue(){
        return hue;
    }
    public float getSaturation(){
        return saturation;
    }
    public float getBrightness(){
        return brightness;
    }

}
