package models.characters;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

public class MatrixPlotter extends JPanel {
    
    private int x;   
    private int y;         
    private int width;          
    private int height;
    private int pixelWidth;
    private int pixelHeight;

    private HashMap<Color, Integer> colors;
    private int matrix[][];

    public MatrixPlotter(){
        new JPanel();
        setBackground(new Color(0,0,0,0));
    }

    public MatrixPlotter(int xPosition, int yPositon, int width, int height, int pixelWidth, int pixelHeight, HashMap<Color, Integer> colors, int[][] matrix){
        this.x = xPosition;
        this.y = yPositon;
        this.width = width;
        this.height = height;
        this.pixelWidth = pixelWidth;
        this.pixelHeight = pixelHeight;
        this.colors = colors;
        this.matrix = matrix;
    }

    public void drawCharacter(Graphics g){
        int dx = pixelWidth;
        int dy = pixelHeight;
        for (int i = 0; i < matrix.length; i++) { // i rows
            for (int j = 0; j < matrix[i].length; j++){ // j colums
                for (Map.Entry<Color, Integer> entry : colors.entrySet()) {
                    Color key = entry.getKey();
                    Integer value = entry.getValue();
                    if (value == matrix[i][j]){
                        g.setColor(key);
                        g.fillRect(dx * j, dy * i, pixelHeight, pixelHeight);
                        break;
                    }
                }
                // colors.entrySet().stream()
                // .filter(entry -> entry.getValue() == matrix[i][j])
                // .forEach(entry -> {
                //     g.setColor(entry.getKey());
                //     g.fillRect(x + dx * j, y + dy * i, width/10, height/10);
                // });
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics g2d = (Graphics) g;
        drawCharacter(g2d);

    }

    public int getX() {
        return x;
    }

    public void setX(int xPosition) {
        this.x = xPosition;
    }

    public int getY() {
        return y;
    }

    public void setY(int yPositon) {
        this.y = yPositon;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public HashMap<Color, Integer> getColors() {
        return colors;
    }

    public void setColors(HashMap<Color, Integer> colors) {
        this.colors = colors;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getPixelWidth() {
        return pixelWidth;
    }

    public void setPixelWidth(int pixelWidth) {
        this.pixelWidth = pixelWidth;
    }

    public int getPixelHeight() {
        return pixelHeight;
    }

    public void setPixelHeight(int pixelHeight) {
        this.pixelHeight = pixelHeight;
    }
     
}
