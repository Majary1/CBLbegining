package GUI;

import javax.swing.*;
import java.awt.*;

public class WardrobePanel extends JPanel {
    public WardrobePanel(){
        setPreferredSize(new Dimension(280,0));
        setBackground(Color.GREEN);
        JLabel title = new JLabel("My Wardorbe");
        add(title);
        setLayout(BorderLayout);
        CategoryPanel categoryPanel = new CategoryPanel();

    }
}
