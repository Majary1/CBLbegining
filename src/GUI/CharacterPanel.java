package GUI;

import javax.swing.*;
import java.awt.*;

public class CharacterPanel extends JPanel {
    private Image character;
    private Image currentTop;
    private Image currentBottom;
    private Image currentShoes;
    private Image currentAccessories;
    private Image currentHat;
    public CharacterPanel(){

        setBackground(Theme.PANEL);
        character = new ImageIcon("src/AddFiles/assets/character_base_pixel.png").getImage();


    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = 500;
        int length = 700;
        int x = (getWidth()-width)/2;
        int y = (getHeight()-length)/2;

        g.drawImage(character,x,y,width,length,null);

        if(currentBottom!=null){
            g.drawImage(currentBottom,x,y,width,length,null);
        }
        if(currentShoes!=null){
            g.drawImage(currentShoes,x,y,width,length,null);
        }
       if(currentTop!=null){
           g.drawImage(currentTop,x,y,width,length,null);
       }
       if(currentHat!=null){
           g.drawImage(currentHat,x,y,width,length,null);
       }
       if(currentAccessories!=null){
           g.drawImage(currentAccessories,x,y,width,length,null);
       }



    }
    public void setTop(Image top){
        this.currentTop = top;
        repaint();
    }
    public void setBottom(Image bottom){
        this.currentBottom = bottom;
        repaint();
    }
    public void setHat(Image hat){
        this.currentHat = hat;
        repaint();
    }
    public void setShoes(Image shoes){
        this.currentShoes= shoes;
        repaint();
    }
    public void setAccessories(Image accessories){
        this.currentAccessories = accessories;
        repaint();
    }

}
