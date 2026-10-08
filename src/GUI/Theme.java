package GUI;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class Theme {

    //COlORS

    public static final Color BACKGROUND =
            new Color(245, 239, 235);

    public static final Color PANEL =
            new Color(252, 248, 245);

    public static final Color SIDEBAR =
            new Color(224, 196, 196);

    public static final Color ACCENT =
            new Color(205, 132, 145);

    public static final Color ACCENT_LIGHT =
            new Color(239, 211, 207);

    public static final Color TEXT =
            new Color(45, 40, 40);

    public static final Color BORDER =
            new Color(220, 205, 195);

    //FONTS

    public static final Font TITLE_FONT =
           loadFont(20f);

    public static final Font BUTTON_FONT =
           loadFont(10f);

    public static final Font NORMAL_FONT =
            loadFont(9f);

    public static final Font BUTTON1_FONT =
            loadFont(15f);

    //Dimensions

    public static final Dimension LBUTTONS =
            new Dimension(190,55);

    //BUTTONS

    public static void setThemeButton(JButton button){
        button.setBackground(SIDEBAR);
        button.setForeground(TEXT);
        button.setFont(BUTTON_FONT);

        button.setFocusPainted(false);
        button.setBorderPainted(false);

        button.setPreferredSize(LBUTTONS);
        button.setMaximumSize(LBUTTONS);

        button.setHorizontalAlignment(SwingConstants.CENTER);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public static void activeButton(JButton button){
        button.setBackground(ACCENT);
        button.setForeground(Color.WHITE);
    }
    public static Font loadFont(float size){
        try{
            InputStream is = Theme.class.getResourceAsStream("/AddFiles/font.ttf");
            if (is == null) {
                throw new RuntimeException("Nie znaleziono czcionki");
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT,is);
            return font.deriveFont(size);
        } catch (Exception e){
            e.printStackTrace();
            return new Font("Monospaced", Font.PLAIN, (int)size);
        }
    }
}
