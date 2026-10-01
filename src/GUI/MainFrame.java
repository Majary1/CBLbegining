package GUI;

import javax.swing.*;
import java.awt.*;
import static GUI.AddClothing.*;
import static GUI.CreateOutfit.*;

public class MainFrame extends JFrame {

    public void mainFrame(){
        final JFrame frame = new JFrame("Dress yourself");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton exit = new JButton("EXIT");
        exit.setBounds(80, 80, 460, 460);
        exit.addActionListener(_ -> frame.dispose());

        JButton newOutfit = new JButton("CREATE NEW OUTFIT");
        newOutfit.setBounds(100,100,460, 460);
        newOutfit.addActionListener( _ -> createOutfit());

        JButton addClothing = new JButton("ADD NEW CLOTHES");
        addClothing.setBounds(100,100,460, 460);
        addClothing.addActionListener(_ -> addClothes());

        ImageIcon icon = new ImageIcon("src\\AddFiles\\images.jpg");
        frame.setIconImage(icon.getImage());

        JPanel panel = new JPanel();
        panel.add(addClothing);
        panel.add(newOutfit);
        panel.add(exit);
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);



    }
}
