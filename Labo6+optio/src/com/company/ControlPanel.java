package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton LoadButton=new JButton("Load");
    JButton SaveButton=new JButton("Save");
    JButton ResetButton=new JButton("Reset");
    JButton ExitButton=new JButton("Exit");

    public ControlPanel(MainFrame frame)  {
        this.frame=frame;
        //change the default layout manager
        setLayout(new GridLayout(1, 4));

        //adaug butoanele
        add(LoadButton);
        add(SaveButton);
        add(ResetButton);
        add(ExitButton);

        //le configurez
        LoadButton.addActionListener(this::load);
        SaveButton.addActionListener(this::save);
        ResetButton.addActionListener(this::reset);
        ExitButton.addActionListener(this::exit);

    }

    private void load(ActionEvent e) {
        try {
            BufferedImage image=ImageIO.read(new File("Users\\adelinamihai\\IdeaProjects\\poza.jpg"));
            frame.canvas.graphics.drawImage(image,0,0,this);

        }catch(IOException ex){System.err.println(ex);}

    }

    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("Users\\adelinamihai\\IdeaProjects\\poza.jpg"));
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e)  {
        frame.canvas.clear();
    }

    private void exit(ActionEvent e) {
        System.exit(0);
    }
}