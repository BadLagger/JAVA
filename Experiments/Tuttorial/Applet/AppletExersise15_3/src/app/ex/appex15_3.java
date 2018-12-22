/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.ex;

import java.applet.Applet;
import java.awt.*;

/**
 *
 * @author badLagger
 */
public class appex15_3 extends Applet implements Runnable{
    String  str;
    Integer ms;
    Thread  mainTh;
    boolean stop;
    
    @Override
    public void init() {
        mainTh = null;
    }
    
    @Override
    public void start(){
        str = getParameter("str");
        try{
            ms = Integer.parseInt(getParameter("ms"));
        } catch(NumberFormatException exc){
            ms = 100;
            str = "Исключение чтения параметров.";
        }
        stop = false;
        mainTh = new Thread(this);
        mainTh.start();
    }
    
    @Override
    public void stop(){
        stop   = true;
        mainTh = null;
    }
    
    @Override
    public void destroy(){
    
    }
    
    @Override
    public void paint(Graphics in){
        in.drawString(str, 20, 50);
    }
    
    @Override
    public void run(){
        for(;;){
            if(stop) break;
            char ch = str.charAt(0);
            String offset = str.substring(1);
            str = offset + ch;
            repaint();
            try{
                Thread.sleep(ms);
            }catch(InterruptedException exc){
            
            }
        }
    }
}
