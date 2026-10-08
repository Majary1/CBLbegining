package GUI;
import ColorDB.ColorWheelPanel;
import Obj.Category;
import Obj.Clothes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ColorDB.*;

import static ColorDB.ColorChanger.colorChange;

public class AddClothingPanel extends JPanel {
    private JTextField nameField;
    private JComboBox<Category> categoryBox;
    private ColorWheelPanel colorWheelPanel;
    private JPanel colorPreview;
    private JSlider brightnessSlider;
    private JButton addButton;
    private Color selectedColor;

    public int order = 0;

    private DbController db = new DbController();
    private WardrobeContainerPanel wardrobeContainerPanel;
    private JLabel clothingPreview;


    public AddClothingPanel(WardrobeContainerPanel wardrobeContainerPanel) {
        this.wardrobeContainerPanel = wardrobeContainerPanel;

        // MAIN PANEL
        setPreferredSize(new Dimension(380, 0));
        setBackground(Theme.PANEL);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2), BorderFactory.createEmptyBorder(25, 25, 25, 25)));

        // TITLE

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setOpaque(false);
        titlePanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        JLabel title = new JLabel("Add Clothing");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TEXT);
        titlePanel.add(title);

        // CATEGORY BOX

        categoryBox = new JComboBox<>(Category.values());
        categoryBox.setFont(Theme.NORMAL_FONT);
        categoryBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        categoryBox.setPreferredSize(new Dimension(170, 38));
        categoryBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        // CLOTHING DETAILS SECTION
        JPanel second = new JPanel(new BorderLayout(20, 0));
        second.setOpaque(false);
        second.setAlignmentX(Component.LEFT_ALIGNMENT);
        second.setMaximumSize(new Dimension(Integer.MAX_VALUE, 19));

        // CLOTHING PREVIEW

        JPanel preview = new JPanel(new FlowLayout(FlowLayout.CENTER));
        preview.setOpaque(false);
        preview.setPreferredSize(new Dimension(145, 175));
        clothingPreview = setPreview((Category) categoryBox.getSelectedItem(), Color.WHITE);
        preview.add(clothingPreview);

        // NAME + CATEGORY PANLE
        JPanel nameCategory = new JPanel();
        nameCategory.setLayout(new BoxLayout(nameCategory, BoxLayout.Y_AXIS));
        nameCategory.setOpaque(false);

        JLabel nameLabel = createLabel("Name");
        nameField = new JTextField();
        nameField.setFont(Theme.NORMAL_FONT);
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 38));
        nameField.setPreferredSize(new Dimension(170, 38));
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel categoryLabel = createLabel("Category");

        nameCategory.add(Box.createVerticalStrut(10));
        nameCategory.add(nameLabel);
        nameCategory.add(Box.createVerticalStrut(7));
        nameCategory.add(nameField);
        nameCategory.add(Box.createVerticalStrut(20));
        nameCategory.add(categoryLabel);
        nameCategory.add(Box.createVerticalStrut(7));
        nameCategory.add(categoryBox);
        second.add(preview, BorderLayout.WEST);
        second.add(nameCategory, BorderLayout.CENTER);

        JLabel colorLabel = createLabel("Choose color:");
        colorLabel.setFont(Theme.NORMAL_FONT.deriveFont(12f));

        colorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        // COLOR WHEEL
        colorWheelPanel = new ColorWheelPanel();
        colorWheelPanel.setPreferredSize(new Dimension(200, 200));
        colorWheelPanel.setMaximumSize(new Dimension(200, 200));

        // COLOR PREVIEW
        colorPreview = new JPanel();
        colorPreview.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        colorPreview.setPreferredSize(new Dimension(Integer.MAX_VALUE, 55));
        colorPreview.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        colorPreview.setBackground(Color.WHITE);
        colorPreview.setAlignmentX(Component.LEFT_ALIGNMENT);

        // BRIGHTNESS SLIDER
        brightnessSlider = new BrightnessSlider();
        brightnessSlider.addChangeListener(e -> {
            float brightness = brightnessSlider.getValue() / 100.0f;
            colorWheelPanel.setBrightness(brightness);
            repaint();
         }
        );
        JLabel selectedColorLabel = createLabel("Selected color:");
        selectedColorLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        // MAIN COLOR SECTION
        JPanel colorSection = new JPanel(new BorderLayout(20, 0));
        colorSection.setOpaque(false);
        colorSection.setAlignmentX(Component.LEFT_ALIGNMENT);
        colorSection.setMaximumSize(new Dimension(Integer.MAX_VALUE, 220));
        colorSection.add(colorWheelPanel, BorderLayout.CENTER);
        colorSection.add(brightnessSlider, BorderLayout.EAST);

        // COLOR CHANGE LISTENER

        colorWheelPanel.addPropertyChangeListener("actualColor", e -> {
                selectedColor = (Color) e.getNewValue();
                colorPreview.setBackground(selectedColor);

                preview.removeAll();
                clothingPreview = setPreview((Category) categoryBox .getSelectedItem(), selectedColor);
                preview.add(clothingPreview);
                preview.revalidate();
                preview.repaint();
            }
        );

        // CATEGORY CHANGE LISTENER
        categoryBox.addActionListener(e -> {
            Color previewColor;
                    if (selectedColor != null) {
                        previewColor = selectedColor;
                    } else {
                        previewColor = Color.WHITE;
                    }
                    preview.removeAll();

                    clothingPreview = setPreview((Category) categoryBox.getSelectedItem(), previewColor);
                    preview.add(clothingPreview);
                    preview.revalidate();
                    preview.repaint();
                }
        );
        // ADD BUTTON
        addButton = new JButton("+ Add to wardrobe");
        addButton.setBackground(Theme.ACCENT);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(Theme.BUTTON1_FONT);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        addButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        addButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 55));
        addButton.setPreferredSize(new Dimension(300, 55));
        addButton.addActionListener(e -> {
                    Clothes clothes = new Clothes(order, nameField.getText(), (Category) categoryBox.getSelectedItem(), selectedColor);
                    order++;
                    boolean saved = db.saveClothes(clothes);
                    if (saved) {
                        JOptionPane.showMessageDialog(this, "Clothing saved!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Could not save clothing.");
                    }
                }
        );

        // STRUCTURE

        add(titlePanel);

        add(second);
        add(Box.createVerticalStrut(10));
        add(colorLabel);
        add(Box.createVerticalStrut(12));
        add(colorSection);
        add(Box.createVerticalStrut(10));
        add(selectedColorLabel);
        add(Box.createVerticalStrut(5));
        add(colorPreview);
        add(Box.createVerticalGlue());
        add(Box.createVerticalStrut(25));
        add(addButton);
        add(Box.createVerticalStrut(10));
    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Theme.BUTTON_FONT);
        label.setForeground(Theme.TEXT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }
    public BufferedImage getImageforCategory(Category category,Color selectedColor){
        return switch(category){
            case TOP ->
                    colorChange(loadImage("src/AddFiles/assets/top_crop_sweater_pixel.png"),selectedColor);
            case BOTTOM ->
                    colorChange(loadImage("src/AddFiles/assets/Kremowe jeansy w stylu pixel art.png"),selectedColor);
            case HAT ->
                    colorChange(loadImage("src/AddFiles/assets/hat_beret_bow_pixel.png"), selectedColor);
            case SHOES ->
                    colorChange(loadImage("src/AddFiles/assets/shoes_chunky_sneakers_pixel.png"), selectedColor);
            case ACCESSORY ->
                    colorChange(loadImage("src/AddFiles/assets/accessory_necklace_bow_gem_pixel.png"), selectedColor);
        };
    }
    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException("Could not load image: " + path, e);
        }
    }
    private JLabel setPreview(Category categorry, Color color){
        BufferedImage bufferedImage = getImageforCategory(categorry,color);
        Image previewCloth = bufferedImage.getScaledInstance(120,160,Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(previewCloth);
        JLabel image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.CENTER);
        image.setIcon(icon);

        return image;
    }

}