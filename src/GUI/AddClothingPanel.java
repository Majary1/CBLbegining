package GUI;
import ColorDB.ColorWheelPanel;
import javax.swing.*;
import java.awt.*;

public class AddClothingPanel extends JPanel {
    private JTextField nameField;
    private JComboBox<String> categoryBox;
    private ColorWheelPanel colorWheelPanel;
    private JPanel colorPreview;
    private JSlider brightnessSlider;
    private JButton colorButton;
    private JButton addButton;
    private Color selectedColor;
    public AddClothingPanel(){
        //PROPERTIES
        setPreferredSize(new Dimension(320,0));
        setBackground(Theme.PANEL);
        setBorder(BorderFactory.createEmptyBorder(25, 20, 25, 20));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,2));
        //setBorder(BorderFactory.createEmptyBorder(0,5,0,5));

        //TITLE

        JLabel title = new JLabel("Add Clothing");
        title.setFont(Theme.TITLE_FONT);
        title.setForeground(Theme.TEXT);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        //NAME

        JLabel nameLabel = createLabel("Name");
        nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        nameField.setFont(Theme.NORMAL_FONT);
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);


        //CATEGORY

        JLabel categoryLabel = createLabel("Category");
        String[] categories = {
                "Tops",
                "Bottoms",
                "Shoes",
                "Accessories",
                "Hats"
        };
        categoryBox = new JComboBox<>(categories);
        categoryBox.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        categoryBox.setFont(Theme.NORMAL_FONT);
        categoryBox.setAlignmentX(Component.LEFT_ALIGNMENT);

        //COLOR Section

        JLabel colorLabel = createLabel("Color");
        colorWheelPanel = new ColorWheelPanel();
        colorWheelPanel.setPreferredSize(new Dimension(200, 200));
        colorWheelPanel.setMaximumSize(new Dimension(200, 200));


        //PREVIEW PLACE

        colorPreview = new JPanel();
        colorPreview.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,1));
        colorPreview.setPreferredSize(new Dimension(70, 70));
        colorPreview.setMaximumSize(new Dimension(70, 70));
        colorPreview.setBackground(Color.WHITE);

        colorWheelPanel.addPropertyChangeListener(
                "actualColor",
                e -> {
                    selectedColor = (Color) e.getNewValue();
                    colorPreview.setBackground(selectedColor);
                }
        );
        //BRIGHTNESS

        brightnessSlider = new JSlider(0, 100, 100);
        brightnessSlider.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
       brightnessSlider.setAlignmentX(Component.LEFT_ALIGNMENT);
        brightnessSlider.addChangeListener(e -> {
                    float brightness = brightnessSlider.getValue() / 100.0f;
                    colorWheelPanel.setBrightness(brightness);
                }
        );


        //MAIN COLOR PANEL
        JPanel colorSection = new JPanel();
        colorSection.setOpaque(false);
        colorSection.setLayout(new BoxLayout(colorSection,BoxLayout.X_AXIS));
        colorSection.setAlignmentX(Component.LEFT_ALIGNMENT);

        colorSection.add(colorWheelPanel);
        colorSection.add(Box.createHorizontalStrut(15));
        colorSection.add(colorPreview);


        //ADD BUTTON

        addButton = new JButton("+ Add to wardrobe");
        addButton.setBackground(Theme.ACCENT);
        addButton.setForeground(Color.WHITE);
        addButton.setFont(Theme.BUTTON_FONT);
        addButton.setFocusPainted(false);
        addButton.setBorderPainted(false);
        addButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        //STRUCTURE
        add(title);
        add(Box.createVerticalStrut(25));
        add(nameLabel);
        add(Box.createVerticalStrut(5));
        add(nameField);
        add(Box.createVerticalStrut(15));
        add(categoryLabel);
        add(Box.createVerticalStrut(5));
        add(categoryBox);
        add(Box.createVerticalStrut(15));
        add(colorLabel);
        add(Box.createVerticalStrut(10));
        add(colorSection);
        add(Box.createVerticalStrut(5));
        add(brightnessSlider);
        add(Box.createVerticalGlue());
        add(addButton);

    }
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Theme.BUTTON_FONT);
        label.setForeground(Theme.TEXT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }
}

