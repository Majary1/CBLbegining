package GUI;

import Obj.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryPanel extends JPanel {

    private JButton shoesButton;
    private JButton topButton;
    private JButton bottomButton;
    private JButton accessoriesButton;
    private JButton hatButton;
    private Category currentCategory;

    public CategoryPanel() {
        setLayout(new GridLayout(2,3,10,10));
        setBackground(Theme.PANEL);
        shoesButton = createCategoryButton("Shoes");
        topButton = createCategoryButton("Tops");
        bottomButton = createCategoryButton("Bottoms");
        accessoriesButton = createCategoryButton("Accessories");
        hatButton = createCategoryButton("Hats");

        add(topButton);
        add(bottomButton);
        add(shoesButton);
        add(hatButton);
        add(accessoriesButton);
        setActive(topButton);
        //Actions
        topButton.addActionListener(e -> {
            setActive(topButton);
            currentCategory = Category.TOP;
        });
        bottomButton.addActionListener(e -> {
            setActive(bottomButton);
            currentCategory = Category.BOTTOM;
        });
        hatButton.addActionListener(e -> {
            setActive(hatButton);
            currentCategory = Category.HAT;
        });
        shoesButton.addActionListener(e -> {
            setActive(shoesButton);
            currentCategory = Category.SHOES;
        });
        accessoriesButton.addActionListener(e -> {
            setActive(accessoriesButton);
            currentCategory = Category.ACCESSORY;
        });
    }
    public Category getCurrentCategory(){
        return currentCategory;
    }
    private JButton createCategoryButton(String text) {

        JButton button = new JButton(text);
        button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
        button.setFont(Theme.BUTTON_FONT);
        button.setForeground(Theme.TEXT);
        button.setBackground(Theme.ACCENT_LIGHT);


        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setPreferredSize(new Dimension(88, 38));

        button.setCursor(new Cursor(Cursor.HAND_CURSOR));


        return button;
    }

    public JButton getTopsButton() {
        return topButton;
    }

    public JButton getBottomsButton() {
        return bottomButton;
    }

    public JButton getShoesButton() {
        return shoesButton;
    }

    public JButton getAccessoriesButton() {
        return accessoriesButton;
    }
    public JButton getHatButton(){
        return hatButton;
    }


    public void setActive(JButton activeButton) {

        JButton[] buttons = {
                topButton,
                bottomButton,
                shoesButton,
                accessoriesButton,
                hatButton
        };

        for (JButton button : buttons) {

            button.setBackground(
                    Theme.ACCENT_LIGHT
            );

            button.setForeground(
                    Theme.TEXT
            );
        }

        activeButton.setBackground(
                Theme.ACCENT
        );

        activeButton.setForeground(
                Color.WHITE
        );
    }
}