/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex.calendar;

import java.applet.Applet;
import java.awt.*;
import java.util.*;

/**
 *
 * @author badLagger
 */
public class CallendarApplet extends Applet implements Runnable{
    
    boolean stop;
    Thread  sec;
    Calendar date;
    int     secStatus;
    int     w, h;

    @Override
    public void init() {
        sec = null;
    }
    
    @Override
    public void start(){
        w = this.getWidth();
        h = this.getHeight();
        sec = new Thread(this);
        stop = false;
        secStatus = 0;
        sec.start();
    }
    
    @Override
    public void stop(){
        sec = null;
        stop = true;    
    }
    
    @Override
    public void paint(Graphics view){
        view.drawString(date.get(Calendar.DAY_OF_MONTH) + "/" + 
                                date.get(Calendar.MONTH) + "/" + 
                                date.get(Calendar.YEAR) + ", " + 
                                date.get(Calendar.HOUR) + ":" +
                                date.get(Calendar.MINUTE) + ":"+
                                date.get(Calendar.SECOND),  this.getWidth()/2 - 80, this.getHeight()/2);
        showStatus(secStatus + " секунд(-ы) работает аплет");
    }

    @Override
    public void run(){
        int Sec = 0;
        int x, y;
        for(;;){
            if(stop) break;
            try{
                if(this.getWidth() != w || this.getHeight() != h)
                {
                    this.setSize(w, h);
                }
                date = Calendar.getInstance();
                if(date.get(Calendar.SECOND) != Sec){
                    Sec = date.get(Calendar.SECOND);
                    secStatus++;
                    repaint();
                }
                Thread.sleep(1);
            }catch(InterruptedException exc){
            
            }
        }
    }
}
