/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlightmain;
enum TrafficLightColor{
  RED(1000), GREEN(5000), YELLOW(2000);
  private int delay;
  
  TrafficLightColor(int delay){
    this.delay = delay;
  }
  public int getDelay(){
    return delay;
  }
}

class TrafficLightSimulator implements Runnable{
    private Thread thrd;
    private TrafficLightColor tlc;
    boolean stop = false;
    boolean changed  = false;
    
    TrafficLightSimulator(TrafficLightColor init){
        tlc = init;
        thrd = new Thread(this);
        thrd.start();
    }
    
    TrafficLightSimulator(){
        tlc = TrafficLightColor.RED;
        thrd = new Thread(this);
        thrd.start();
    }
    
    @Override
    public void run(){
        while(!stop){
          try{
              for(TrafficLightColor i:TrafficLightColor.values()){
                if(tlc == i){
                  Thread.sleep(tlc.getDelay());
                  break;
                }
              }
          }catch(InterruptedException exc){
              System.out.println(exc);
          }
          changeColor();
        }
        
    }
    
    synchronized void waitForChange(){
        try{
            while(!changed)
                wait();
            changed = false;
        }catch(InterruptedException exc){
            System.out.println(exc);
        }
    }
    
    synchronized void changeColor(){
        switch(tlc){
            case RED:
                tlc = TrafficLightColor.GREEN;
                break;
            case YELLOW:
                tlc = TrafficLightColor.RED;
                break;
            case GREEN:
                tlc = TrafficLightColor.YELLOW;
                break;
        }
        changed = true;
        notify();
    }
    
    TrafficLightColor getColor(){
        return tlc;
    }
    
    void cancel(){
        stop = true;
    }
}
/**
 *
 * @author Vladimir Hrechko
 */
public class TrafficLightMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TrafficLightSimulator t1 = new TrafficLightSimulator(TrafficLightColor.GREEN);
        
        for(int i = 0; i < 9; i++){
            System.out.println(t1.getColor());
            t1.waitForChange();
        }
        
        t1.cancel();
    }
    
}
