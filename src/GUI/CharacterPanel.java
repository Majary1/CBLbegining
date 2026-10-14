package GUI;
import Obj.Category;
import Obj.Clothes;
import Obj.Outfit;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ColorDB.ColorChanger.colorChange;

public class CharacterPanel extends JPanel {
    //**
    // Panel for displaying character and clothes
    // *//
    final int WIDTH = 500;
    final int LENGTH = 700;
    private BufferedImage character;
    private BufferedImage currentTop;
    private BufferedImage currentBottom;
    private BufferedImage currentShoes;
    private BufferedImage currentAccessories;
    private BufferedImage currentHat;
    private Outfit currentOutfit;
    private BufferedImage characterClosed;
    private Image background;
    private int[][] dimensions;
    public CharacterPanel(){
        currentOutfit = new Outfit(0);
        setOpaque(false);
        character = loadImage("src/AddFiles/assets/character_base_pixel.png");
        characterClosed = loadImage("src/AddFiles/assets/blink.png");
        background = new ImageIcon("src/AddFiles/assets/room.png").getImage();
        startBlinking();

    }
    //Paints clothes on character
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
           g.drawImage(currentAccessories, x, y, WIDTH, LENGTH, null);
       }


    }
    //Blink Animation
    private void startBlinking(){
        BufferedImage save = character;
        Timer blink = new Timer(6000,e->{
            //Changes from open to closed eyes
            character=characterClosed;
            revalidate();
            repaint();
            //And again for open
            Timer reopen = new Timer(150,ev->{
                character=save;
                revalidate();
                repaint();
            });
            reopen.setRepeats(false);
            reopen.start();
        });
        blink.start();

    }
    //Depending on category and color, it returns correct image
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

//Loading for images
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
//Removes all clothes from character
public void Reset(){
        currentHat=null;
        currentAccessories = null;
        currentShoes = null;
        currentBottom = null;
        currentTop = null;
        currentOutfit.partsOfOutfit.clear();
}

    public void removeClothingById(int clothingId) {

        Category categoryToRemove = null;

        for (Clothes clothes : currentOutfit.getPartsOfOutfit()) {

            if (clothes.getId() == clothingId) {
                categoryToRemove = clothes.getCategory();
                break;
            }
        }

        if (categoryToRemove == null) {
            return;
        }

        currentOutfit.getPartsOfOutfit().removeIf(
                clothes -> clothes.getId() == clothingId
        );

        switch (categoryToRemove) {

            case TOP -> currentTop = null;

            case BOTTOM -> currentBottom = null;

            case HAT -> currentHat = null;

            case SHOES -> currentShoes = null;

            case ACCESSORY -> currentAccessories = null;
        }
        repaint();
    }
}

