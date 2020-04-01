package com.company;
import javax.swing.*;
import java.awt.*;

/**
 * extends JFrame which is a high-level container that allows you
 * to create a custom container
 * the same is for the other existing classes in the package, besides the Main class.
 * in this class the application interface is set, putting the elements at their place.
 */

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    DrawingPanel canvas;
    ControlPanel controlPanel;

    public MainFrame(String title)  {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //creez componentele
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        canvas = new DrawingPanel(this);

        getContentPane().setLayout(new BorderLayout());

        //aranjez componenetele in container
        add(configPanel,BorderLayout.NORTH); // TOP
        add(canvas,BorderLayout.CENTER);
        add(controlPanel,BorderLayout.SOUTH); //BOTTOM

        pack();

    }
}
