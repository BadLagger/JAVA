/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.appfirst;

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/**
 *
 * @author Vladimir Hrechko
 */
public class appfirst extends Applet implements Runnable, MouseListener, MouseMotionListener{
    String  author;
    String  title = "Пример апплета из книги Шилдта. ";
    String  mouseMsg = "";
    int     mouseLocalX = 0, mouseLocalY = 0;
    Thread  mainThread;
    int     seconds;
    boolean stop;
    
    @Override
    public void init(){
        mainThread = null;
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    @Override
    public void start(){
        mainThread = new Thread(this);
        author = getParameter("author");
        if(author == null) author = "not found";
        stop = false;
        seconds = 0;
        mainThread.start();
    }
    @Override
    public void stop(){
        stop = true;
        mainThread = null;
    }
    @Override
    public void destroy(){
    
    }
    @Override
    public void paint(Graphics g){
        char ch;
        ch = title.charAt(0);
        title = title.substring(1, title.length());
        title += ch;
        g.drawString(title, 50, 30);
        g.drawString("Автор: " + author, 50, 50);
        g.drawString(mouseMsg, mouseLocalX, mouseLocalY);
        //showStatus("Апплет работает " + (++seconds) + " секунд.");
    }
    @Override
    public void run(){
        for(;;){
            try{
                repaint();
                Thread.sleep(1000);
                if(stop)
                    break;
            }catch(InterruptedException exc){
            
            }
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent me){
        mouseLocalX = 0;
        mouseLocalY = 10;
        mouseMsg = "Mouse clicked";
        repaint();
    }
    
    @Override
    public void mouseEntered(MouseEvent me){
        mouseLocalX = 0;
        mouseLocalY = 10;
        mouseMsg = "Mouse entered";
        repaint();
    }
    @Override
    public void mouseExited(MouseEvent me){
        mouseLocalX = 0;
        mouseLocalY = 10;
        mouseMsg = "Mouse exited";
        repaint();
    }
    @Override
    public void mousePressed(MouseEvent me){
        mouseLocalX = me.getX();
        mouseLocalY = me.getY();
        mouseMsg = "Down";
        repaint();
    }
    @Override
    public void mouseReleased(MouseEvent me){
        mouseLocalX = me.getX();
        mouseLocalY = me.getY();
        mouseMsg = "Up";
        repaint();
    }
    @Override
    public void mouseDragged(MouseEvent me){
        mouseLocalX = me.getX();
        mouseLocalY = me.getY();
        mouseMsg = "*";
        showStatus("Мышь перетянула: " + mouseLocalX + "," + mouseLocalY);
        repaint();
    }
    @Override
    public void mouseMoved(MouseEvent me){
        //mouseLocalX = me.getX();
        //mouseLocalY = me.getY();
        //mouseMsg = "*";
        showStatus("Мышь движется: " + me.getX() + "," + me.getY());
        repaint();
    }
}
