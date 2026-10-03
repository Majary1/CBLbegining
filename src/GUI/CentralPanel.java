package GUI;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel {
    public CentralPanel(){
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        WardrobePanel wardrobePanel = new WardrobePanel();
        CharacterPanel characterPanel = new CharacterPanel();
        add(wardrobePanel, BorderLayout.WEST);
        add(characterPanel,BorderLayout.CENTER);
    }
}
