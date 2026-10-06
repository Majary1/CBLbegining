package GUI;
import GUI.Theme;
import Obj.Category;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.BatchUpdateException;

import static ColorDB.ColorChanger.colorChange;
import static Obj.Category.*;

public class CharacterPanel extends JPanel {

    private BufferedImage character;
    private BufferedImage currentTop;
    private BufferedImage currentBottom;
    private BufferedImage currentShoes;
    private BufferedImage currentAccessories;
    private BufferedImage currentHat;
    public CharacterPanel(){

        setBackground(Theme.PANEL);
        character = loadImage("src/AddFiles/assets/character_base_pixel.png");


    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = 500;
        int length = 700;
        int x = (getWidth()-width)/2;
        int y = (getHeight()-length)/2;

        g.drawImage(character,x,y,width,length,null);
        if(currentShoes!=null){
            g.drawImage(currentShoes,x,y,width,length,null);
        }
        if(currentBottom!=null){
            g.drawImage(currentBottom,x,y,width,length,null);
        }

       if(currentTop!=null){
           g.drawImage(currentTop,x,y,width,length,null);
       }
       if(currentHat!=null){
           g.drawImage(currentHat,x,y,width,length,null);
       }
       if(currentAccessories!=null){
           g.drawImage(currentAccessories,x,y,width,length,null);
       }



    }
    public void setIconByCategory(Category category,Color selectedColor){
        switch (category) {
            case TOP -> this.currentTop = colorChange(loadImage("src/AddFiles/assets/top_on.png"),selectedColor);
            case BOTTOM -> this.currentBottom = colorChange(loadImage("src/AddFiles/assets/pants_on.png"),selectedColor);
            case HAT -> this.currentHat = colorChange(loadImage("src/AddFiles/assets/hat_on.png"),selectedColor);
            case SHOES -> this.currentShoes = colorChange(loadImage("src/AddFiles/assets/shoes_on.png"),selectedColor);
            case ACCESSORY-> this.currentAccessories = colorChange(loadImage("src/AddFiles/assets/neckless_on.png"),selectedColor);
        }
        repaint();
    }


private BufferedImage loadImage(String path) {
    try {
        return ImageIO.read(new File(path));
    } catch (IOException e) {
        throw new RuntimeException("Could not load image: " + path, e);
    }
}
}

