package GUI;

import Obj.Category;
import Obj.Clothes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static ColorDB.ColorChanger.colorChange;

public class ClothingCard extends JButton {
    //**
    // Creates the Clothing cards in Wardorbe Container Panel
    // *//
    private JLabel image;
    private JLabel nameLabel;
    private CharacterPanel characterPanel;
    private final int clothesID;
    private final JButton deleteButton;
    public ClothingCard(Clothes clothes, int width){
        clothesID = clothes.getId();
        deleteButton = new JButton("X");

        setLayout(new BorderLayout());
        setBackground(Theme.PANEL);
        setBorder(BorderFactory.createLineBorder(Theme.BORDER,1));
        width-=20;
        setPreferredSize(new Dimension((width/2),150));

        //Adding image
        BufferedImage bufferedImage = getImageforCategory(clothes);
        Image scaledImage = bufferedImage.getScaledInstance(120,160,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);

        //And its features
        image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.CENTER);

        image.setIcon(icon);
        nameLabel = new JLabel(clothes.getName());

        add(image, BorderLayout.CENTER);


        deleteButton.setPreferredSize(new Dimension(25, 25));

        deleteButton.setBackground(Theme.ACCENT);
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.setMargin(new Insets(0, 0, 0, 0));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 5));
        topPanel.setOpaque(false);

        topPanel.add(deleteButton);

        add(topPanel, BorderLayout.NORTH);
    }

//Depending on category of the clothes, it returns given type of image.
    public BufferedImage getImageforCategory(Clothes clothes){
        return switch(clothes.getCategory()){
            case TOP ->
                    colorChange(loadImage("src/AddFiles/assets/top_crop_sweater_pixel.png"),clothes.getAvarageColor());
            case BOTTOM ->
                    colorChange(loadImage("src/AddFiles/assets/Kremowe jeansy w stylu pixel art.png"),clothes.getAvarageColor());
            case HAT ->
                    colorChange(loadImage("src/AddFiles/assets/hat_beret_bow_pixel.png"), clothes.getAvarageColor());
            case SHOES ->
                    colorChange(loadImage("src/AddFiles/assets/shoes_chunky_sneakers_pixel.png"), clothes.getAvarageColor());
            case ACCESSORY ->
                    colorChange(loadImage("src/AddFiles/assets/accessory_necklace_bow_gem_pixel.png"), clothes.getAvarageColor());
        };
    }

    //Loads a buffered image
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException("Could not load image: " + path, e);
        }
    }

    public int getID() {
        return clothesID;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }
}
