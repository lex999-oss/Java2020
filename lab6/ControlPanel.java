package com.company;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    final JFileChooser fc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
    JButton saveBtn = new JButton("Save");//create all buttons (Load, Reset, Exit)
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    public ControlPanel(MainFrame frame) {
        super();
        this.frame = frame;
        init();
    }

    private void init() {        
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        //add all buttons...TODO
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);
        // configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        loadBtn.addActionListener(this::load);
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
    }

    private void save(ActionEvent e) {
        try {
            int returnValue = fc.showSaveDialog(null);
            File selectedFile = new File("./");
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                selectedFile = fc.getSelectedFile();
            }
            ImageIO.write(frame.canvas.image, "PNG", new FileOutputStream(selectedFile.getAbsolutePath()));
        }
        catch (IOException ex) { System.err.println(ex); }
    }
    private void load(ActionEvent e){
        int returnValue = fc.showOpenDialog(null);
        File selectedFile = new File("./");
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fc.getSelectedFile();
        }
        try{
            frame.canvas.image=ImageIO.read(new FileInputStream(selectedFile.getAbsolutePath()));
            frame.canvas.graphics=frame.canvas.image.createGraphics();
        }catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e) {
        frame.canvas.graphics.setColor(Color.WHITE);  //fill the image with white
        frame.canvas.graphics.fillRect(0, 0, frame.canvas.W, frame.canvas.H);

    }

    private void exit(ActionEvent e){
       System.exit(0);
    }

}
