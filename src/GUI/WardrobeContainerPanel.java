package GUI;

import javax.swing.*;
import java.awt.*;

public class WardrobeContainerPanel extends JPanel {

    private JPanel containerPanel;

    public WardrobeContainerPanel(){
        setLayout(new BorderLayout());

        containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0,2,10,10));
        JScrollPane scrollPane = new JScrollPane(containerPanel);

        add(scrollPane,BorderLayout.CENTER);
    }
    public void addClothingCard(String name){
        ClothingCard card = new ClothingCard(name);
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
