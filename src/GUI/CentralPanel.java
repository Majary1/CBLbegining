package GUI;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel {

    private WardrobePanel wardrobePanel;
    private CharacterPanel characterPanel;

    public CentralPanel(){
        setBackground(Theme.BACKGROUND);
        setLayout(new BorderLayout());
        characterPanel = new CharacterPanel();
        wardrobePanel = new WardrobePanel(characterPanel);

        wardrobePanel.setVisible(false);

        add(wardrobePanel, BorderLayout.WEST);
        add(characterPanel,BorderLayout.CENTER);
    }
    public  WardrobePanel getWardrobePanel(){
        return wardrobePanel;
    }
    public CharacterPanel getCharacterPanel(){
        return characterPanel;
    }
}
