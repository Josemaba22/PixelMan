package models.characters;

import java.awt.Color;

import java.util.HashMap;

import javax.swing.JFrame;

import view.MyFrame;

public class PixelMan extends MatrixPlotter{
    
    private MyFrame myFrame;

    public PixelMan(JFrame myFrame){
        super();
        this.myFrame = (MyFrame) myFrame;
         int[][] pixelManMatrix = {
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0,0,0,0,0},
            {0,1,2,2,2,2,2,2,1,0,0,0,0,0},
            {0,1,2,2,3,3,2,3,1,0,0,0,0,0},
            {0,1,2,2,3,3,2,3,1,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0,1,1,1,0},
            {0,0,1,2,2,2,2,1,0,0,1,0,0,0},
            {0,0,1,2,2,2,2,1,0,0,0,0,0,0},
            {0,0,1,1,1,1,1,1,0,0,0,0,0,0},
        };

        HashMap<Color, Integer> colors = new HashMap<Color, Integer>();
        colors.put(new Color(255,255,255,100), 0);
        colors.put(new Color(0, 0, 0), 1);
        colors.put(Color.CYAN, 2);
        colors.put(new Color(50,140,0), 3);
        colors.put(Color.MAGENTA, 4);
        
        int pixelSize = 10;
        setPixelHeight(pixelSize);
        setPixelWidth(pixelSize);
        setMatrix(pixelManMatrix);
        setColors(colors);
        setX(0);
        setY(0);
        // setWidth(getMatrix()[0].length * 10);
        // setHeight(getMatrix().length * 10);
        setWidth(getMatrix()[0].length * pixelSize);
        setHeight(getMatrix().length * pixelSize);

        setVisible(true);
        setFocusable(true);
        requestFocus();
         
    }

    public void setMyFrame(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public MyFrame getMyFrame() {
        return myFrame;
    }

}
