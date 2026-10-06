package GUI;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel {

    private WardrobePanel wardrobePanel;
    private CharacterPanel characterPanel;

    public CentralPanel(){
        setBackground(Theme.BACKGROUND);
        setLayout(new BorderLayout());
        wardrobePanel = new WardrobePanel();
        characterPanel = new CharacterPanel();
        wardrobePanel.setVisible(false);

        add(wardrobePanel, BorderLayout.WEST);
        add(characterPanel,BorderLayout.CENTER);
    }
    public  WardrobePanel getWardrobePanel(){
        return wardrobePanel;
    }
}
