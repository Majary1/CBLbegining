package GUI;

import Obj.Clothes;

import javax.swing.*;
import java.awt.*;

public class WardrobeContainerPanel extends JPanel {

    private JPanel containerPanel;

    public WardrobeContainerPanel(){
        setLayout(new BorderLayout());
        setBorder(null);
        containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0,2,10,10));
        JScrollPane scrollPane = new JScrollPane(containerPanel);

        add(scrollPane,BorderLayout.CENTER);
    }
    public void addClothingCard(Clothes clothes){
        ClothingCard card = new ClothingCard(clothes);
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
