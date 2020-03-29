package com.company;

//import com.sun.deploy.panel.ControlPanel;

import javax.swing.*;


import java.awt.*;

import static javax.swing.SwingConstants.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        this.setBounds(100,100,700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);//create the components
        canvas = new DrawingPanel(this);
        configPanel=new ConfigPanel(this);
        controlPanel=new ControlPanel(this);
        // TODO//arrange the components in the container (frame)//JFrame uses a BorderLayout by default
        setLayout(new BorderLayout());
        add(configPanel,BorderLayout.NORTH);
        add(canvas,BorderLayout.CENTER);//this is BorderLayout.CENTER...
        add(controlPanel,BorderLayout.SOUTH);
        //TODO//invoke the layout manager;
        pack();
    }
}