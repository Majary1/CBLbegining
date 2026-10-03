package GUI;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends JPanel {

    private JButton shoesButton;
    private JButton topButton;
    private JButton bottomButton;
    private JButton accessoriesButton;
    private JButton hatButton;

    public CategoryPanel(){
        setLayout(new GridLayout(1,5,5,0));

        shoesButton = new JButton("Shoes");
        topButton = new JButton("Tops");
        bottomButton = new JButton("Bottoms");
        accessoriesButton = new JButton("Accessories");
        hatButton = new JButton("Hats");

        add(topButton);
        add(bottomButton);
        add(shoesButton);
        add(hatButton);
        add(accessoriesButton);
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
}
