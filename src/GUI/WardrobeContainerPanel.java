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

                // NEW: Ask for confirmation
                int answer = JOptionPane.showConfirmDialog(
                        this,
                        "Are you sure you want to delete "
                                + clothes.getName() + "?",
                        "Delete clothing",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE
                );

                // NEW: Only delete if user clicks YES
                if (answer == JOptionPane.YES_OPTION) {

                    // NEW: Prevent clicking delete twice
                    card.getDeleteButton().setEnabled(false);

                    // NEW: Delete from SQLite in a background thread
                    new SwingWorker<Boolean, Void>() {

                        @Override
                        protected Boolean doInBackground() {

                            // This method already exists in DbController
                            return db.deleteClothing(clothes.getId());
                        }

                        @Override
                        protected void done() {

                            try {
                                boolean deleted = get();

                                if (deleted) {

                                    // NEW: Remove deleted clothing
                                    // from the current outfit
                                    characterPanel.removeClothingById(
                                            clothes.getId()
                                    );

                                    // NEW: Remove the card from the wardrobe
                                    containerPanel.remove(card);

                                    // NEW: Refresh the display
                                    containerPanel.revalidate();
                                    containerPanel.repaint();

                                } else {

                                    // NEW: Show error if database deletion fails
                                    JOptionPane.showMessageDialog(
                                            WardrobeContainerPanel.this,
                                            "Could not delete clothing.",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE
                                    );

                                    card.getDeleteButton().setEnabled(true);
                                }

                            } catch (Exception ex) {

                                // NEW: Handle unexpected errors
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
