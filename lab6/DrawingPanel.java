package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image;  //the offscreen
    Graphics2D graphics;  //the "tools" needed to draw in the image

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);  //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }

    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        this.addMouseListener(new MouseAdapter() { @Override public void mousePressed(MouseEvent e) {drawShape(e.getX(), e.getY()); repaint();} //Can’t use lambdas, JavaFX does a better job in these cases
            });
        }

    private void drawShape(int x, int y) {
        int radius=(int)frame.configPanel.sizeField.getValue();//generate a random number
        int sides= (int) frame.configPanel.sidesField.getValue();   //get the value from UI (in ConfigPanel)
        Color random= new Color(getRandomNumberInRange(0,1),getRandomNumberInRange(0,1),getRandomNumberInRange(0,1),1f);
        //Color Black=new Color(0,0,0);
        Color color=new Color(0,0,0);
        if(frame.configPanel.colorCombo.getSelectedIndex()==0) {
            color=random;
        } else if(frame.configPanel.colorCombo.getSelectedIndex()==1){
            color=Color.black;
        }
         graphics.setColor(color);
         if(frame.configPanel.shapeCombo.getSelectedIndex()==0) graphics.fill(new Triangle(x,y,radius,sides));
        if(frame.configPanel.shapeCombo.getSelectedIndex()==1) graphics.fill(new Square(x,y,radius,sides));
        if(frame.configPanel.shapeCombo.getSelectedIndex()==2) graphics.fill(new RegularPolygon(x,y,radius,sides));
    }

    @Override public void update(Graphics g) { } //Why did I do that?
    @Override protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}


