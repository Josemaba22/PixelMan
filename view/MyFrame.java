package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.PixelManPorpertiesController;
import models.characters.PixelMan;

public class MyFrame extends JFrame{
    
    // Attributes
    JFrame frame;
    PixelMan pixelMan;
    JButton btnPixelManPropertiesVisible;
    PixelManPropertiesView pixelManPropertiesView;
    PixelManPorpertiesController pixelManPorpertiesController;

    // Constructor
    public MyFrame() {
        setTitle("PixelMan");
        setDefaultCloseOperation(3);
        setVisible(true);
        setLayout(null);
        getContentPane().setBackground(Color.RED);
        
        PixelMan pixelMan = new PixelMan(this);
        pixelMan.setBounds(0, 0, 300, 300);
        add(pixelMan);
        
        pixelManPropertiesView = new PixelManPropertiesView();
        btnPixelManPropertiesVisible = new JButton("Mostrar propiedades de PixelMan");
        pixelManPorpertiesController = new PixelManPorpertiesController(pixelManPropertiesView, pixelMan, btnPixelManPropertiesVisible);
        btnPixelManPropertiesVisible.setBounds(50, 150, 230, 30);
        
        add(btnPixelManPropertiesVisible);
        add(pixelManPropertiesView);
        pack();
        setSize(500, 500);
        setLocationRelativeTo(null);
        pixelMan.requestFocus();
    }

}
