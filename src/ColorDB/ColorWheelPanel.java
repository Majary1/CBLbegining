package ColorDB;
import GUI.Theme;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//**
// Creates the color circle mathematically by using Graphics type
// Navigates where the user has clicked on the color wheel and sends this information to rest of classes
// *//
public class ColorWheelPanel extends JPanel {

    private float selectedHue = 0.0f;
    private float selectedSaturation = 0.0f;
    private float selectedBrightness = 1.0f;
    private int selectedX = -1;
    private int selectedY = -1;
    private Color actualcolor;

    public ColorWheelPanel() {

        //Calculates the color depending on which pixel did the user clicked
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //Get a point //
                int x = e.getX();
                int y = e.getY();

                //Check if point is in the circle//
                if (!isInside(x, y)) {
                    return;
                }
                Point center = new Point();
                center.x = getWidth() / 2;
                center.y = getHeight() / 2;
                int radius = Math.min(center.x, center.y) - 10;
                int dx = x - center.x;
                int dy = y - center.y;
                double distance = Math.sqrt(dx * dx + dy * dy);

                // Get a distance of a point from center from interval <0.0,1.0>//
                float saturation = (float) (distance / radius);
                double angle = Math.atan2(-dy, dx);

                // Calculate the degree on which is our point located, starting form OX oasis//
                double hueDegree = Math.toDegrees(angle);
                if (hueDegree < 0) {
                    hueDegree += 360;
                }

                // Get a hue which is in <0.0 , 1.0> interval//
                float hue = (float) (hueDegree / 360.0);
                selectedX = x;
                selectedY = y;
                selectedHue=hue;
                selectedSaturation=saturation;
                setactualColor(hue,saturation);
                repaint();
            }
        });
    }
    // Gets information form brightness slider and updates the current color, so it matches the users input
    public void setBrightness(float brightness) {
        this.selectedBrightness = brightness;
        if(selectedX>=0 && selectedY>=0){
            setactualColor(selectedHue,selectedSaturation);
        }
    }
    //Gets information about new change of selected color and sets new actual color with new properties
    public void setactualColor(float hue, float saturation) {
        Color oldcolor = actualcolor;
        int rgb = Color.HSBtoRGB(hue, saturation, selectedBrightness);
        actualcolor = new Color(rgb);
        firePropertyChange(
                "actualColor", oldcolor,actualcolor
        );

    }
    public Color getActualColor(){
        return actualcolor;
    }
    // Checks if point (x,y) is in the circle (important in making a color circle in method above)
    private boolean isInside(int x, int y) {
        Point center = new Point();
        center.x = getWidth() / 2;
        center.y = getHeight() / 2;

        // Selects which radius is more appropriate depending on how big is the panel
        int radius = Math.min(center.x, center.y);

        radius -= 10;
        Point pixel = new Point();

        pixel.x = x - center.x;
        pixel.y = y - center.y;

        //Calculates the distance form the center of the circle
        double distance = Math.sqrt(pixel.x * pixel.x + pixel.y * pixel.y);

        //Checks if the pixel is inside or on the circle
        if (radius >= distance) {
            return true;
        }
        return false;

    }

    //Paints the color circle
    @Override
    protected void paintComponent(Graphics g) {
        Point center = new Point();
        center.x = getWidth() / 2;
        center.y = getHeight() / 2;

        // Selects which radius is more appropriate depending on how big is the panel
        int radius = Math.min(center.x, center.y) - 10;

        Point pixel = new Point();

        super.paintComponent(g);
        for (int x = 0; x <= getWidth(); x++) {
            for (int y = 0; y <= getHeight(); y++) {
                if (isInside(x, y)) {
                    pixel.x = x - center.x;
                    pixel.y = y - center.y;

                    //Calculates the distance from the center
                    double distance = Math.sqrt(pixel.x * pixel.x + pixel.y * pixel.y);

                    //Calculates how much saturation is in the color depending on how far it is from the center
                    float saturation = (float) (distance / radius);

                    //Calculates the hue of a pixel depending on which angle it lies
                    double angle = Math.atan2(-(pixel.y), pixel.x);
                    double hueDegree = Math.toDegrees(angle);
                    if (hueDegree < 0) {
                        hueDegree += 360;
                    }
                    float hue = (float) (hueDegree / 360.0);

                    float brigtness = 1.0f;
                    int rgb = Color.HSBtoRGB(hue, saturation, brigtness);
                    Color pixelColour = new Color(rgb);
                    g.setColor(pixelColour);
                    g.fillRect(x, y, 1, 1);
                }else {
                    g.setColor(Theme.PANEL);
                    g.fillRect(x,y,1,1);
                }
            }
        }

        //Draws a white circle around picked pixel
        if (selectedX >= 0 && selectedY >= 0) {
            g.setColor(Color.WHITE);

            g.drawOval(selectedX, selectedY, 10, 10);
        }

    }
}

