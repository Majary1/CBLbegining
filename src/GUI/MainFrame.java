package GUI;

import javax.swing.*;
import java.awt.*;
import static GUI.AddClothing.*;
import static GUI.CreateOutfit.*;
import ColorDB.ColorWheelPanel;

public class MainFrame extends JFrame {

    public void mainFrame(){

        //PROPERTIES
        final JFrame frame = new JFrame("Dress yourself");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Theme.BACKGROUND);

        //PANELS
        SidebarPanel sidebarPanel = new SidebarPanel();
        CentralPanel centralPanel = new CentralPanel();
        AddClothingPanel addclothingPanel = new AddClothingPanel();

        frame.add(sidebarPanel,BorderLayout.WEST);
        frame.add(centralPanel,BorderLayout.CENTER);
        frame.add(addclothingPanel,BorderLayout.EAST);

        //ICON
        ImageIcon icon = new ImageIcon("src\\AddFiles\\images.jpg");
        frame.setIconImage(icon.getImage());


        //WINDOW SIZE
        frame.setSize(1400,850);
        frame.setMinimumSize(new Dimension(1100,700));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



    }
}
