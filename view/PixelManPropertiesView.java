package view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import javax.swing.BorderFactory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.BasicStroke;
import java.awt.GradientPaint;


public class PixelManPropertiesView extends JPanel{
    
    public JSpinner x;
    public JSpinner y;
    public JSpinner width;
    public JSpinner height;
    public JSpinner pixelWidth;
    public JSpinner pixelHeight;

    public JLabel xLabel;
    public JLabel yLabel;
    public JLabel widthLabel;
    public JLabel heightLabel;
    public JLabel pixelWidthLabel;
    public JLabel pixelHeightLabel;

    public Color colorPrimario = new Color(0x666f7f);
    public Color colorSecundario = new Color(0x262d3d);
    public Color colorContorno = new Color(0x262d3d);
    public int arcw=20;
    public int arch=20;

    public int mouseX = 0;
    public int mouseY = 0;

    public PixelManPropertiesView(){
        setLayout(new GridLayout(3, 2, 10, 10));
        setBackground(Color.LIGHT_GRAY);
        setBounds(50, 200, 350, 150);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        x = new JSpinner();
        x.setPreferredSize(new Dimension(20, 20));
        y = new JSpinner();
        width = new JSpinner();
        height = new JSpinner();
        pixelWidth = new JSpinner();
        pixelHeight = new JSpinner();

        xLabel = new JLabel("X:");
        yLabel = new JLabel("Y:");
        widthLabel = new JLabel("Width:");
        heightLabel = new JLabel("Height:");
        pixelWidthLabel = new JLabel("Pixel Width:");
        pixelHeightLabel = new JLabel("Pixel Height:");

        add(xLabel);
        add(x);
        add(yLabel);
        add(y);
        add(widthLabel);
        add(width);
        add(heightLabel);
        add(height);
        add(pixelWidthLabel);
        add(pixelWidth);
        add(pixelHeightLabel);
        add(pixelHeight);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
       
       
         Paint oldPaint = g2.getPaint();
          RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(
                    0,0,getWidth(),getHeight()-1,getArcw(),getArch());
            g2.clip(r2d);
            g2.setPaint(new GradientPaint(0.0f, 0.0f,getColorPrimario().darker(),
                    0.0f, getHeight(),getColorSecundario().darker()));
            g2.fillRect(0,0,getWidth(),getHeight());
           
            g2.setStroke(new BasicStroke(4f));
            g2.setPaint(new GradientPaint(0.0f, 0.0f,getColorContorno(),
                    0.0f, getHeight(), getColorContorno()));
            g2.drawRoundRect(0, 0, getWidth()-2 , getHeight() -2, 18, 18);
       
        g2.setPaint(oldPaint);
        super.paintComponent(g);
    }

    public Color getColorPrimario() {
        return colorPrimario;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public Color getColorContorno() {
        return colorContorno;
    }

    public int getArcw() {
        return arcw;
    }

    public int getArch() {
        return arch;
    }

    // @Override
    // public void mouseDragged(java.awt.event.MouseEvent e) {
    //     setLocation(

    //             this.getX() + e.getX() - this.getWidth() / 2,

    //             this.getY() + e.getY() - this.getHeight() / 2

    //     );
    // }

    // @Override
    // public void mouseMoved(java.awt.event.MouseEvent e) {
    // }

    
}
