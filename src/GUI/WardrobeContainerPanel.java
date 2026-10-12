package GUI;

import ColorDB.DbController;
import Obj.Category;
import Obj.Clothes;
import ColorDB.DbController.*;

import javax.swing.*;
import java.awt.*;

public class WardrobeContainerPanel extends JPanel {

    public JPanel containerPanel;
    private CharacterPanel characterPanel;
    private JButton currentTopButton = null;
    private CategoryPanel categoryPanel;
    private DbController db = new DbController();

    public WardrobeContainerPanel(CharacterPanel characterPanel, CategoryPanel categoryPanel) {
        this.characterPanel = characterPanel;
        this.categoryPanel = categoryPanel;
        setLayout(new BorderLayout());
        setBackground(Theme.SIDEBAR);
        setBorder(null);
        containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(0, 2, 5, 5));
        JScrollPane scrollPane = new JScrollPane(containerPanel);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void addClothingCard(Clothes clothes) {
        ClothingCard card = new ClothingCard(clothes, getWidth());
        card.addActionListener(e -> {

            characterPanel.setIconByCategory(clothes.getCategory(), clothes.getAvarageColor());
            if (characterPanel.getCurrentOutfit().isThisCategoryInOutfit(clothes)) {
                characterPanel.getCurrentOutfit().removeByCategory(clothes.getCategory());
            }
            characterPanel.getCurrentOutfit().addClothToOutfit(clothes);

            card.getDeleteButton().addActionListener(_ -> {
                int answer = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete "
                                + clothes.getName() + "?",
                        "Delete clothing",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                if (answer == JOptionPane.YES_OPTION) {
                    card.getDeleteButton().setEnabled(false);
                    new SwingWorker<Boolean, Void>() {

                        @Override
                        protected Boolean doInBackground() {
                            return db.deleteClothing(clothes.getId());
                        }

                        @Override
                        protected void done() {

                            try {
                                boolean deleted = get();

                                if (deleted) {
                                    characterPanel.removeClothingById(
                                            clothes.getId()
                                    );
                                    containerPanel.remove(card);
                                    containerPanel.revalidate();
                                    containerPanel.repaint();

                                } else {
                                    JOptionPane.showMessageDialog(
                                            WardrobeContainerPanel.this,
                                            "Could not delete clothing.",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE
                                    );

                                    card.getDeleteButton().setEnabled(true);
                                }

                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(
                                        WardrobeContainerPanel.this,
                                        "Database error: " + ex.getMessage(),
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE
                                );

                                card.getDeleteButton().setEnabled(true);
                            }
                        }
                    }.execute();
                }
            });
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
