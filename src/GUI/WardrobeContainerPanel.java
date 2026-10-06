package GUI;

import Obj.Clothes;

import javax.swing.*;
import java.awt.*;

public class WardrobeContainerPanel extends JPanel {

    public JPanel containerPanel;
    private CharacterPanel characterPanel;
    public WardrobeContainerPanel(CharacterPanel characterPanel){
        this.characterPanel = characterPanel;
        setLayout(new BorderLayout());
        setBorder(null);
        containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0,2,10,10));
        JScrollPane scrollPane = new JScrollPane(containerPanel);

        add(scrollPane,BorderLayout.CENTER);
    }
    public void addClothingCard(Clothes clothes){
        ClothingCard card = new ClothingCard(clothes);
        card.addActionListener( e ->{
            characterPanel.setIconByCategory(clothes.getCategory(),clothes.getAvarageColor());
        });
        containerPanel.add(card);

        containerPanel.revalidate();
        containerPanel.repaint();

    }
    public void clearClothes() {
        containerPanel.removeAll();
        containerPanel.revalidate();
        containerPanel.repaint();
    }


}
