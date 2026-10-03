package GUI;

import javax.swing.*;
import java.awt.*;

public class WardrobePanel extends JPanel {

    private CategoryPanel categoryPanel;
    private WardrobeContainerPanel wardrobeContainerPanel;

    public WardrobePanel(){

        setPreferredSize(new Dimension(280,0));
        setBackground(Color.GREEN);
        JLabel title = new JLabel("My Wardorbe");
        add(title);
        setLayout(new BorderLayout());


        categoryPanel = new CategoryPanel();
        wardrobeContainerPanel = new WardrobeContainerPanel();


        add(categoryPanel,BorderLayout.NORTH);
        add(wardrobeContainerPanel, BorderLayout.CENTER);
        setupListeners();
        showTestTops();

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

        wardrobeContainerPanel.addClothingCard("Pink Top");
        wardrobeContainerPanel.addClothingCard("Black Top");
        wardrobeContainerPanel.addClothingCard("White Top");
    }

    private void showTestBottoms() {

        wardrobeContainerPanel.clearClothes();

        wardrobeContainerPanel.addClothingCard("Blue Jeans");
        wardrobeContainerPanel.addClothingCard("Black Pants");
    }

    private void showTestShoes() {

        wardrobeContainerPanel.clearClothes();

        wardrobeContainerPanel.addClothingCard("White Shoes");
        wardrobeContainerPanel.addClothingCard("Black Shoes");
    }

    private void showTestAccessories() {

        wardrobeContainerPanel.clearClothes();

        wardrobeContainerPanel.addClothingCard("Hat");
        wardrobeContainerPanel.addClothingCard("Bag");
    }
}
