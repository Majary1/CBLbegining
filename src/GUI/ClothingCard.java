package GUI;

import Obj.Category;
import Obj.Clothes;

import javax.swing.*;
import java.awt.*;

public class ClothingCard extends JPanel {
    private JLabel image;
    private JLabel nameLabel;
    public ClothingCard(Clothes clothes){
        setLayout(new BorderLayout());

        image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.CENTER);
        ImageIcon icon = getImageforCategory(clothes.getCategory());
        Image scaledIcon = icon.getImage().getScaledInstance(120,160,Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(scaledIcon));
        nameLabel = new JLabel(clothes.getName());
        add(image, BorderLayout.CENTER);
        add(nameLabel, BorderLayout.SOUTH);
    }
    public ImageIcon getImageforCategory(Category category){
        return switch(category){
            case TOP -> new ImageIcon("src/AddFiles/assets/top_crop_sweater_pixel.png");
            case BOTTOM -> new ImageIcon("src/AddFiles/assets/pants_on.png");
            case HAT -> new ImageIcon("src/AddFiles/assets/hat_beret_bow_pixel.png");
            case SHOES -> new ImageIcon("src/AddFiles/assets/shoes_chunky_sneakers_pixel.png");
            case ACCESSORY-> new ImageIcon("src/AddFiles/assets/accessory_necklace_bow_gem_pixel.png");
        };
    }
}
