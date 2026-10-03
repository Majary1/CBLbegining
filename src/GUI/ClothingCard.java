package GUI;

import javax.swing.*;
import java.awt.*;

public class ClothingCard extends JPanel {
    private JLabel image;
    private JLabel nameLabel;
    public ClothingCard(String name){
        setLayout(new BorderLayout());
        image = new JLabel();
        image.setPreferredSize(new Dimension(100,100));
        nameLabel = new JLabel(name);
        add(image, BorderLayout.CENTER);
        add(nameLabel, BorderLayout.SOUTH);
    }
}
