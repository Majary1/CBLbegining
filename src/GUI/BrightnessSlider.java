package GUI;

import javax.swing.*;
import java.awt.*;

public class BrightnessSlider extends JSlider{

    public BrightnessSlider(){
         super(JSlider.VERTICAL,0, 100, 100);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
         setAlignmentX(Component.LEFT_ALIGNMENT);
         setOpaque(false);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int trackWidth = 16;
        int x =( getWidth()-trackWidth)/2;
        int y = 0;

        int heigh = getHeight();
        GradientPaint gradient = new GradientPaint(x,y,Color.WHITE,x,y+heigh,Color.BLACK);

        g2.setPaint(gradient);
        g2.fillRoundRect(x,y,trackWidth,heigh,16,16);
        g2.setColor(Color.DARK_GRAY);
        g2.drawRoundRect(x,y,trackWidth,heigh,16,16);

        int thumbSize = 14;
        float percentage = (float) (getValue() - getMinimum()) / (getMaximum() - getMinimum());

        int minY = y + thumbSize / 2;
        int maxY = y + heigh - thumbSize / 2;
        int thumbY = minY + (int) ((1 - percentage) * (maxY-minY));
        int thumbX = (getWidth() - thumbSize) / 2;
        g2.setColor(Color.WHITE);
        g2.fillOval(thumbX, thumbY - thumbSize / 2, thumbSize, thumbSize);
        g2.setColor(Color.DARK_GRAY);
        g2.drawOval(thumbX, thumbY - thumbSize / 2, thumbSize, thumbSize);

    }


}
