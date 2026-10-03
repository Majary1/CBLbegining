package GUI;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {
    public SidebarPanel(){
        setPreferredSize(new Dimension(180,0));
        setBackground(Color.LIGHT_GRAY);

        //initialize buttons
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JButton createButton = new JButton("Create");
        JButton wardrobeButton = new JButton("Wardrobe");
        JButton addClothingButton = new JButton("Add Clothing");
        JButton settingsButton = new JButton("Settings");

        //set structure
        add(Box.createVerticalStrut(30));
        add(createButton);
        add(Box.createVerticalStrut(15));
        add(wardrobeButton);
        add(Box.createVerticalStrut(15));
        add(addClothingButton);
        add(Box.createVerticalGlue());
        add(settingsButton);
        add(Box.createVerticalStrut(20));
    }

}
