package GUI;
import Obj.Category;
import Obj.Outfit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ColorDB.ColorChanger.colorChange;

public class CharacterPanel extends JPanel {

    final int WIDTH = 500;
    final int LENGTH = 700;
    private BufferedImage character;
    private BufferedImage currentTop;
    private BufferedImage currentBottom;
    private BufferedImage currentShoes;
    private BufferedImage currentAccessories;
    private BufferedImage currentHat;
    private Outfit currentOutfit;
    private Image background;
    public CharacterPanel(){
        currentOutfit = new Outfit(0);
        setOpaque(false);
        character = loadImage("src/AddFiles/assets/character_base_pixel.png");
        background = new ImageIcon("src/AddFiles/assets/room.png").getImage();


    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int x = (getWidth()- WIDTH)/2;
        int y = (getHeight()- LENGTH)/2;

        g.drawImage(character,x,y, WIDTH, LENGTH,null);
        if(currentShoes!=null){
            g.drawImage(currentShoes,x,y, WIDTH, LENGTH,null);
        }
        if(currentBottom!=null){
            g.drawImage(currentBottom,x,y, WIDTH, LENGTH,null);
        }

       if(currentTop!=null){
           g.drawImage(currentTop,x,y, WIDTH, LENGTH,null);
       }
       if(currentHat!=null){
           g.drawImage(currentHat,x,y, WIDTH, LENGTH,null);
       }
       if(currentAccessories!=null){
           g.drawImage(currentAccessories,x,y, WIDTH, LENGTH,null);
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
public Outfit getCurrentOutfit(){
        return currentOutfit;
}
}

