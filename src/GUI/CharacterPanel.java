package GUI;

import javax.swing.*;
import java.awt.*;

public class CharacterPanel extends JPanel {
    public CharacterPanel(){

        setBackground(Theme.PANEL);
        JLabel title = new JLabel("Character");
        add(title);
    }
}
