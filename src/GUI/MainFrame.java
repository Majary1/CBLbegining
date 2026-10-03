package GUI;

import javax.swing.*;
import java.awt.*;
import static GUI.AddClothing.*;
import static GUI.CreateOutfit.*;
import ColorDB.ColorWheelPanel;

public class MainFrame extends JFrame {

    public void mainFrame(){
        final JFrame frame = new JFrame("Dress yourself");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        SidebarPanel sidebarPanel = new SidebarPanel();
        CentralPanel centralPanel = new CentralPanel();
        AddClothingPanel addclothingPanel = new AddClothingPanel();

        frame.add(sidebarPanel,BorderLayout.WEST);
        frame.add(centralPanel,BorderLayout.CENTER);
        frame.add(addclothingPanel,BorderLayout.EAST);


        ImageIcon icon = new ImageIcon("src\\AddFiles\\images.jpg");
        frame.setIconImage(icon.getImage());


        frame.pack();
        frame.setVisible(true);



    }
}
