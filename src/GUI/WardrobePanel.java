package GUI;

import javax.swing.*;
import java.awt.*;

public class WardrobePanel extends JPanel {

    private CategoryPanel categoryPanel;
    private WardrobeContainerPanel wardrobeContainerPanel;

    public WardrobePanel(){

        setPreferredSize(new Dimension(380,0));
        setBackground(Theme.PANEL);
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,2));
        JLabel title = new JLabel("My clothes");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TEXT);
        title.setBorder(BorderFactory.createEmptyBorder(20,15,10,10));
        add(title);
        setLayout(new BorderLayout());


        categoryPanel = new CategoryPanel();
        wardrobeContainerPanel = new WardrobeContainerPanel();
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Theme.PANEL);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(title,BorderLayout.NORTH);
        topPanel.add(categoryPanel, BorderLayout.CENTER);

        add(topPanel,BorderLayout.NORTH);
        add(wardrobeContainerPanel, BorderLayout.CENTER);
        setupListeners();

    }
    private void setupListeners() {

        categoryPanel.getTopsButton().addActionListener(e -> {
            showTestTops();
        });

        categoryPanel.getBottomsButton().addActionListener(e -> {
            showTestBottoms();
        });

        categoryPanel.getShoesButton().addActionListener(e -> {
            showTestShoes();
        });

        categoryPanel.getAccessoriesButton().addActionListener(e -> {
            showTestAccessories();
        });
    }

    private void showTestTops() {

        wardrobeContainerPanel.clearClothes();


    }

    private void showTestBottoms() {

        wardrobeContainerPanel.clearClothes();


    }

    private void showTestShoes() {

        wardrobeContainerPanel.clearClothes();


    }

    private void showTestAccessories() {

        wardrobeContainerPanel.clearClothes();


    }

}
