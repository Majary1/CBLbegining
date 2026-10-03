package GUI;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    private JButton createButton;
    private JButton wardrobeButton;
    private JButton addClothingButton;
    private JButton settingsButton;

    public SidebarPanel(){
        setPreferredSize(new Dimension(190,0));
        setBackground(Theme.SIDEBAR);
        setBorder(BorderFactory.createEmptyBorder(30, 20, 25, 20));

        //initialize buttons
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        createButton = new JButton("Create");
         wardrobeButton = new JButton("Wardrobe");
         addClothingButton = new JButton("Add Clothing");
         settingsButton = new JButton("Settings");

        //Features
        Theme.setThemeButton(createButton);
        Theme.setThemeButton(wardrobeButton);
        Theme.setThemeButton(addClothingButton);
        Theme.setThemeButton(settingsButton);
        //set structure
        add(Box.createVerticalStrut(45));
        add(createButton);
        add(Box.createVerticalStrut(15));
        add(wardrobeButton);
        add(Box.createVerticalStrut(15));
        add(addClothingButton);
        add(Box.createVerticalGlue());
        add(settingsButton);

    }

}
