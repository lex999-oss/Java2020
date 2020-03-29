package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;         // we’re drawing regular polygons
    JSpinner sidesField;  // number of sides
    JSpinner sizeField;
    JComboBox colorCombo; // the color of the shape
    JComboBox shapeCombo; // the shape
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner sides
        JLabel sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        sizeField = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
        sidesField.setValue(6); //default number of sides
        sizeField.setValue(10);
        // create the colorCombo, containing the values: Random and Black
        String[] colors ={"Random","Black"};
        String[] shapes={"Triangle","Square","Regular Polygon"};
        shapeCombo=new JComboBox(shapes);
        colorCombo =new JComboBox(colors);
        add(new Label("Size:"));
        add(sizeField);
         add(sidesLabel); //JPanel uses FlowLayout by default
         add(sidesField);
         add(new Label("Color:"));
         add(colorCombo);
         add(new Label("Shape"));
         add(shapeCombo);
    }
}
