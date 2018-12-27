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
public class PaintApp extends Applet implements MouseListener{
    
    
    
    class ViewString{
        
        final   String  title;
        final   int     x, y;
        private int     count;
        private int     updt;
        
        ViewString(String title, int x, int y){
            this.title = title;
            this.x = x;
            this.y = y;
            count = 0;
            updt  = 0;
        }
        
        public void draw(Graphics view){
            //if(updt == 1){
                view.drawString(title + count, x, y);
                 updt = 0;
           // }
        }
        
        public void update(){
            count++;
            updt = 1;
        } 
    }
    
    ViewString mPressed;
    String     status;
    
    @Override
    public void init() {
      status = "Инициализация";
    }
    @Override 
    public void start(){
      mPressed = new ViewString("Событие нажатия: ", 100, 100);
      mPressed.update();
      status = "Старт";
      repaint();
    }
    
    @Override
    public void paint(Graphics view){
        mPressed.draw(view);
        showStatus(status);
    }
    // Runnable method overriding
    @Override
    public void mousePressed(MouseEvent me){
    
    }
    @Override
    public void mouseEntered(MouseEvent me){
    
    }
    @Override
    public void mouseExited(MouseEvent me){
    
    }
    @Override
    public void mouseReleased(MouseEvent me){
    
    }
    @Override
    public void mouseClicked(MouseEvent me){
    
    }
}
