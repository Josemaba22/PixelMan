package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import models.characters.PixelMan;
import view.PixelManPropertiesView;

public class PixelManPorpertiesController implements MouseMotionListener, KeyListener{

    PixelManPropertiesView pixelManPropertiesView;
    PixelMan pixelMan;
    JButton btnPixelManPropertiesVisible;

    public PixelManPorpertiesController(PixelManPropertiesView pixelManPropertiesView, PixelMan pixelMan, JButton btnPixelManPropertiesVisible) {
        this.pixelManPropertiesView = pixelManPropertiesView;
        this.pixelMan = pixelMan;
        this.btnPixelManPropertiesVisible = btnPixelManPropertiesVisible;
        btnPixelManPropertiesVisibleAction(btnPixelManPropertiesVisible);
        pixelManPropertiesView.addMouseMotionListener(this);
        pixelMan.addKeyListener(this);

        spinnersInit();
        spinners();
        //focusOnClickToPixelMan();
    }

    public void btnPixelManPropertiesVisibleAction(JButton btnPixelManPropertiesVisible) {
        this.btnPixelManPropertiesVisible = btnPixelManPropertiesVisible;
        btnPixelManPropertiesVisible.setText("Mostrar propiedades de PixelMan");
        btnPixelManPropertiesVisible.addActionListener(e -> {
            if (pixelManPropertiesView.isVisible()) { 
                btnPixelManPropertiesVisible.setText("Mostrar propiedades de PixelMan");
                pixelManPropertiesView.setVisible(false);
                pixelManPropertiesView.repaint();
                pixelMan.requestFocus();

            } else {
                btnPixelManPropertiesVisible.setText("Ocultar propiedades de PixelMan");
                pixelManPropertiesView.setVisible(true);
                pixelManPropertiesView.repaint();
                pixelMan.requestFocus();

            }
            btnPixelManPropertiesVisible.setVisible(true);
            pixelMan.requestFocus();
        });
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        pixelManPropertiesView.setLocation(

            pixelManPropertiesView.getX() + e.getX() - pixelManPropertiesView.getWidth() / 2,

            pixelManPropertiesView.getY() + e.getY() - pixelManPropertiesView.getHeight() / 2

        );
    }

    @Override
    public void mouseMoved(MouseEvent e) {    }


    public void spinnersInit(){
        SpinnerNumberModel model;
        pixelManPropertiesView.x.setValue(pixelMan.getX());
        model = (SpinnerNumberModel) pixelManPropertiesView.x.getModel();
        model.setStepSize(pixelMan.getPixelWidth());
        
        pixelManPropertiesView.y.setValue(pixelMan.getY());
        model = (SpinnerNumberModel) pixelManPropertiesView.y.getModel();
        model.setStepSize(pixelMan.getPixelHeight());

        pixelManPropertiesView.width.setValue(pixelMan.getWidth());
        model = (SpinnerNumberModel) pixelManPropertiesView.width.getModel();
        model.setStepSize(pixelMan.getPixelWidth());

        pixelManPropertiesView.height.setValue(pixelMan.getHeight());
        model = (SpinnerNumberModel) pixelManPropertiesView.height.getModel();
        model.setStepSize(pixelMan.getPixelHeight());

        pixelManPropertiesView.pixelSize.setValue(pixelMan.getPixelHeight());
        model = (SpinnerNumberModel) pixelManPropertiesView.pixelSize.getModel();
        model.setStepSize(1);
    }

    public void spinners(){
        pixelManPropertiesView.x.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pixelMan.setX(Integer.parseInt(pixelManPropertiesView.x.getValue().toString()));
                pixelMan.getMyFrame().repaint();
            }
        });

        pixelManPropertiesView.y.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pixelMan.setY(Integer.parseInt(pixelManPropertiesView.y.getValue().toString()));
                pixelMan.getMyFrame().repaint();
            }
        });

        pixelManPropertiesView.width.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pixelMan.setWidth(Integer.parseInt(pixelManPropertiesView.width.getValue().toString()));
                pixelMan.setBounds(pixelMan.getX(), pixelMan.getY(), pixelMan.getWidth(), pixelMan.getHeight());
                pixelMan.getMyFrame().repaint();
            }
        });

        pixelManPropertiesView.height.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pixelMan.setHeight(Integer.parseInt(pixelManPropertiesView.height.getValue().toString()));
                pixelMan.setBounds(pixelMan.getX(), pixelMan.getY(), pixelMan.getWidth(), pixelMan.getHeight());
                pixelMan.getMyFrame().repaint();
            }
        });

        pixelManPropertiesView.pixelSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                pixelMan.setPixelHeight(Integer.parseInt(pixelManPropertiesView.pixelSize.getValue().toString()));
                pixelMan.setPixelWidth(Integer.parseInt(pixelManPropertiesView.pixelSize.getValue().toString()));
                pixelMan.getMyFrame().repaint();
            }
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'w':
                pixelMan.setY(pixelMan.getY() - 10); // Mover hacia arriba
                pixelManPropertiesView.y.setValue(pixelMan.getY());
                break;
            case 'a':
                pixelMan.setX(pixelMan.getX() - 10); // Mover a la izquierda
                pixelManPropertiesView.x.setValue(pixelMan.getX());
                break;
            case 's':
                pixelMan.setY(pixelMan.getY() + 10); // Mover hacia abajo
                pixelManPropertiesView.y.setValue(pixelMan.getY());
                break;
            case 'd':
                pixelMan.setX(pixelMan.getX() + 10); // Mover a la derecha
                pixelManPropertiesView.x.setValue(pixelMan.getX());
                break;
        }
        pixelMan.requestFocus();
        pixelMan.getMyFrame().repaint(); // Repintar para reflejar los cambios
    }

    
    public void focusOnClickToPixelMan(){
        pixelMan.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Cuando se hace clic en PixelMan, solicita el foco
                pixelMan.requestFocus();
            }
        });
    }

    @Override
    public void keyReleased(KeyEvent e) {
    } 



    
}
