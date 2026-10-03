package GUI;

import javax.swing.*;
import java.awt.*;

public class Theme {
    public static final Color BACKGROUND =
            new Color(245, 239, 235);

    public static final Color PANEL =
            new Color(252, 248, 245);

    public static final Color SIDEBAR =
            new Color(224, 196, 196);

    public static final Color ACCENT =
            new Color(205, 132, 145);

    public static final Color TEXT =
            new Color(45, 40, 40);
    public static final Dimension LBUTTONS = new Dimension(190,50);
    public static void setThemeButton(JButton button){
        button.setBackground(Theme.ACCENT);
        button.setForeground(Color.BLACK);
        button.setFocusPainted(false);
        button.setMaximumSize(Theme.LBUTTONS);
        button.setFont(new Font("Monospaced", Font.BOLD,18));
        button.setBorderPainted(false);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
