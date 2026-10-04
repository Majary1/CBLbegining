package GUI;

import javax.swing.*;
import java.awt.*;

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
            new Font("Monospaced", Font.BOLD, 26);

    public static final Font BUTTON_FONT =
            new Font("Monospaced", Font.BOLD, 16);

    public static final Font NORMAL_FONT =
            new Font("Monospaced", Font.PLAIN, 15);



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

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    public static void activeButton(JButton button){
        button.setBackground(ACCENT);
        button.setForeground(Color.WHITE);
    }
}
