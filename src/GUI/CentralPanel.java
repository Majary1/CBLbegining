package GUI;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel {

    private WardrobePanel wardrobePanel;
    private CharacterPanel characterPanel;

    public CentralPanel(){
        setBackground(Color.BLUE);
        setLayout(new BorderLayout());
        wardrobePanel = new WardrobePanel();
        characterPanel = new CharacterPanel();
        add(wardrobePanel, BorderLayout.WEST);
        add(characterPanel,BorderLayout.CENTER);
    }
}
