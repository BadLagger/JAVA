/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex.paint;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author badLagger
 */
public class PaintApp extends Applet implements MouseListener, MouseMotionListener{
    String     status;
    int        xBgn, yBgn, xCur, yCur;
    boolean    drawing = false;
    Color      colorCur;
    
    @Override
    public void init() {
      status = "Инициализация ";
      addMouseListener(this);
      addMouseMotionListener(this);
      repaint();
    }
    @Override 
    public void start(){
      status = "Старт ";
      xBgn = yBgn = xCur = yCur = 0;
      colorCur = Color.BLACK;
      repaint();
    }
    
    @Override
    public void paint(Graphics view){
        if(drawing){
            view.setColor(colorCur);
            view.drawLine(xBgn, yBgn, xCur, yCur);
        }
        showStatus(status);
    }
    @Override
    public void mousePressed(MouseEvent me){
        if(me.getButton() == MouseEvent.BUTTON1)
        {
          drawing = true;
          xBgn = xCur = me.getX();
          yBgn = yCur = me.getY();
        }
        
        if(me.getButton() == MouseEvent.BUTTON3)
        {
            if(colorCur == Color.BLACK)
                colorCur = Color.BLUE;
            else if(colorCur == Color.BLUE){
                colorCur = Color.GREEN;
            }else if(colorCur == Color.GREEN){
                colorCur = Color.ORANGE;
            } else colorCur = Color.BLACK;
        }
        status = "Рисуем ";
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent me){
       if(me.getButton() == MouseEvent.BUTTON1)
       {
         status = "Ждём ";
         drawing = false;
       } 
       repaint();
    }
    @Override
    public void mouseDragged(MouseEvent me){
        xCur = me.getX();
        yCur = me.getY();
        status = "Рисуем ";
        repaint();
    }
    @Override
    public void mouseEntered(MouseEvent me){}
    @Override
    public void mouseExited(MouseEvent me){}
    @Override
    public void mouseClicked(MouseEvent me){}
    @Override
    public void mouseMoved(MouseEvent me){}
}
