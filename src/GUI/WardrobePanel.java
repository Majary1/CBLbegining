package GUI;
import ColorDB.DbController;
import Obj.Category;
import Obj.Clothes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WardrobePanel extends JPanel {

    private CategoryPanel categoryPanel;
    private WardrobeContainerPanel wardrobeContainerPanel;
    private DbController db;

    public WardrobePanel(CharacterPanel characterPanel){

        db = new DbController();
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
        wardrobeContainerPanel = new WardrobeContainerPanel(characterPanel,categoryPanel);
        JPanel topPanel = new JPanel();
        topPanel.setBackground(Theme.PANEL);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(title,BorderLayout.NORTH);
        topPanel.add(categoryPanel, BorderLayout.CENTER);

        add(topPanel,BorderLayout.NORTH);
        add(wardrobeContainerPanel, BorderLayout.CENTER);
        setupListeners();
        showClothesFromCategory(Category.TOP);

    }
    public WardrobeContainerPanel getWardrobeContainerPanel(){
        return wardrobeContainerPanel;
    }
    private void setupListeners() {

        categoryPanel.getTopsButton().addActionListener(e -> {
            showClothesFromCategory(Category.TOP);
        });

        categoryPanel.getBottomsButton().addActionListener(e -> {
            showClothesFromCategory(Category.BOTTOM);
        });

        categoryPanel.getShoesButton().addActionListener(e -> {
            showClothesFromCategory(Category.SHOES);
        });

        categoryPanel.getAccessoriesButton().addActionListener(e -> {
            showClothesFromCategory(Category.ACCESSORY);
        });
        categoryPanel.getHatButton().addActionListener(e->{
            showClothesFromCategory(Category.HAT);
        });
    }

    private void showClothesFromCategory(Category category) {

        wardrobeContainerPanel.clearClothes();
        List<Clothes> allClothes = db.showClothesByCategory(category);
        for(Clothes clothes:allClothes){
            wardrobeContainerPanel.addClothingCard(clothes);
        }


    }

}
