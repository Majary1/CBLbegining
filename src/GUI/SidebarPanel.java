package GUI;

import javax.swing.*;
import java.awt.*;

public class SidebarPanel extends JPanel {

    private JButton createButton;
    private JButton wardrobeButton;
    private JButton addClothingButton;
    private JButton settingsButton;

    public SidebarPanel(){
        setPreferredSize(new Dimension(180,0));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,2));
        setBackground(Theme.SIDEBAR);

        //setBorder(BorderFactory.createEmptyBorder(30, 15, 25, 15));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        JLabel title = new JLabel("Virtual");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TEXT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel title2 = new JLabel("Wardrobe");
        title2.setFont(Theme.TITLE_FONT);
        title2.setForeground(Theme.TEXT);
        title2.setAlignmentX(Component.CENTER_ALIGNMENT);
        //initialize buttons

        createButton = new JButton("♧ Create");
         wardrobeButton = new JButton("▣ Wardrobe");
         addClothingButton = new JButton("＋ Add Clothing");
         settingsButton = new JButton("⚙ Settings");

        //Features
        Theme.setThemeButton(createButton);
        Theme.setThemeButton(wardrobeButton);
        Theme.setThemeButton(addClothingButton);
        Theme.setThemeButton(settingsButton);

        Theme.activeButton(createButton);
        //set structure
        add(title);
        add(Box.createVerticalStrut(3));
        add(title2);
        add(Box.createVerticalStrut(50));
        add(createButton);
        add(Box.createVerticalStrut(10));
        add(wardrobeButton);
        add(Box.createVerticalStrut(10));
        add(addClothingButton);
        add(Box.createVerticalGlue());
        add(settingsButton);

    }
    public JButton getAddClothingButton(){
        return addClothingButton;
    }
    public JButton getWardrobeButton(){
        return wardrobeButton;
    }
    public JButton setActiveAddClothingButton(){
        Theme.activeButton(addClothingButton);
        return addClothingButton;
    }
    public  JButton deActiveAddClothingButton(){
        Theme.setThemeButton(addClothingButton);
        return addClothingButton;
    }
    public JButton setActiveWardrobeButton(){
        Theme.activeButton(wardrobeButton);
        return wardrobeButton;
    }
    public  JButton deActiveWardrobeButton(){
        Theme.setThemeButton(wardrobeButton);
        return wardrobeButton;
    }

}
