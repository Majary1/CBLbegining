package GUI;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JDialog {
    public SettingsPanel(Window owner){
        super ((Frame) owner,"Help", false);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Getting started", createPage(
                "<h2>Welcome to Dress yourself!</h2>"
                        + "<p>Build outfits from your virtual wardrobe, put them on your "
                        + "character and check whether the colours match.</p>"
                        + "<ol>"
                        + "<li>Add clothes to your wardrobe.</li>"
                        + "<li>Put clothes on the character.</li>"
                        + "<li>Press <b>Check</b> to see if the outfit matches.</li>"
                        + "<li>Save outfits you like.</li>"
                        + "</ol>"));

        tabs.addTab("Clothes", createPage(
                "<h2>Adding clothes</h2>"
                        + "<ul>"
                        + "<li>Give the item a name and choose a category "
                        + "(e.g. top, bottom, shoes).</li>"
                        + "<li>Pick the colour of an item on the color wheel and add the item to the wardrobe</li>"
                        + "</ul>"));

        tabs.addTab("Outfits", createPage(
                "<h2>Saving outfits</h2>"
                        + "<ul>"
                        + "<li>Put the items you want on the character.</li>"
                        + "<li>Give the outfit a name and press <b>Save</b>.</li>"
                        + "<li>Saved outfits are stored in the database, so they are "
                        + "still there the next time you start the app.</li>"
                        + "</ul>"));

        tabs.addTab("Colour check", createPage(
                "<h2>How does \"Check\" work?</h2>"
                        + "<p>The app compares the colours of the chosen items using "
                        + "colour theory and tells you whether they match.</p>"
                        + "<p>The result is a suggestion, not a rule &ndash; "
                        + "trust your own taste too.</p>"));

        JButton close = new JButton("Close");
        close.addActionListener(e -> dispose());

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(close);

        setLayout(new BorderLayout());
        add(tabs, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        setSize(480, 360);
        setLocationRelativeTo(owner); // centre over the main window
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private Component createPage(String s) {
        JEditorPane pane = new JEditorPane("text/html", "<html><body style='font-family:sans-serif'>" //! font to be changed
                + s + "</body></html>");
        pane.setEditable(false);
        pane.setCaretPosition(0);
        pane.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        return new JScrollPane(pane);
    }
}
