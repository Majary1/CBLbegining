package GUI;

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

    public CategoryPanel() {
        setLayout(new GridLayout(2,3,10,10));

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
        //Actions
        topButton.addActionListener(e -> {
            setActive(topButton);
        });
        bottomButton.addActionListener(e -> {
            setActive(bottomButton);
        });
        hatButton.addActionListener(e -> {
            setActive(hatButton);
        });
        shoesButton.addActionListener(e -> {
            setActive(shoesButton);
        });
        accessoriesButton.addActionListener(e -> {
            setActive(accessoriesButton);
        });
    }

    private JButton createCategoryButton(String text) {

        JButton button = new JButton(text);

        button.setFont(new Font("Monospaced", Font.PLAIN, 13));
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