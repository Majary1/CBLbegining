package GUI;

import javax.swing.*;
import java.awt.*;

public class CentralPanel extends JPanel {

    private WardrobePanel wardrobePanel;
    private CharacterPanel characterPanel;
    private Image background;

    public CentralPanel(){

        this.background = new ImageIcon("src/AddFiles/assets/room.png").getImage();

        setLayout(new BorderLayout());
        characterPanel = new CharacterPanel();
        wardrobePanel = new WardrobePanel(characterPanel);

        wardrobePanel.setVisible(false);

        add(wardrobePanel, BorderLayout.WEST);
        add(characterPanel,BorderLayout.CENTER);


    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background,0,0,getWidth(),getHeight(),this);
    }
    public  WardrobePanel getWardrobePanel(){
        return wardrobePanel;
    }
    public CharacterPanel getCharacterPanel(){
        return characterPanel;
    }
}
