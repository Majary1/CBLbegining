package GUI;

import Obj.Category;
import Obj.Clothes;

import javax.swing.*;
import java.awt.*;

public class WardrobeContainerPanel extends JPanel {

    public JPanel containerPanel;
    private CharacterPanel characterPanel;
    private JButton currentTopButton=null;
    private CategoryPanel categoryPanel;
    public WardrobeContainerPanel(CharacterPanel characterPanel, CategoryPanel categoryPanel){
        this.characterPanel = characterPanel;
        this.categoryPanel = categoryPanel;
        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR);
        setBorder(null);
        containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0,2,5,5));
        JScrollPane scrollPane = new JScrollPane(containerPanel);

        add(scrollPane,BorderLayout.CENTER);
    }
    public void addClothingCard(Clothes clothes){
        ClothingCard card = new ClothingCard(clothes,getWidth());
        card.addActionListener( e ->{

            characterPanel.setIconByCategory(clothes.getCategory(),clothes.getAvarageColor());
            if(characterPanel.getCurrentOutfit().isThisCategoryInOutfit(clothes)){
                characterPanel.getCurrentOutfit().removeByCategory(clothes.getCategory());
            }
            characterPanel.getCurrentOutfit().addClothToOutfit(clothes);



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
