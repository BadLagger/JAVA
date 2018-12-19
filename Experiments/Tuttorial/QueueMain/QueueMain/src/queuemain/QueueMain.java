/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemain;
import rand.*;


interface Out{
    void show(String in);
}
/**
 *
 * @author Vladimir Hrechko
 */
public class QueueMain {
    
    static String getRandStr(){
        String ret = "";
        int size = Rand.getInt(3, 10);
       
        //char [] chArr = new char[];
        
        for(int i = 0; i < size; i++){
            Character ch = (char)Rand.getInt((int)'a', (int)'z');
            String concat = ret.concat(ch.toString());
            ret = concat;
        }
        
        return ret;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer iStore[] = new Integer[10];
        GenQueue<Integer> q = new GenQueue<>(iStore);
        Out out = n -> System.out.println(n);
        
        Integer iVal;
        out.show("Демонстрация очереди типа Integer: ");
        try{
            for(int i = 0; i < 11; i++){
                out.show("Добавление " + i + " в очередь.");
                q.put(i);
            }
        } catch(QueueFullException exc){
            out.show(exc.toString());
        }
        
        try{
            for(int i = 0; i < 11; i++){
                out.show("Получение " + i + " элемента из очереди: ");
                iVal = q.get();
                out.show(iVal.toString());
            }
        } catch(QueueEmptyException exc){
            out.show(exc.toString());
        }
        
        //String ex = getRandStr();
        
        String sStore[] = new String[10];
        GenQueue<String> sq = new GenQueue<>(sStore);
        String sVal;
        
        out.show("Демонстрация очереди типа String: ");
        try{
            for(int i = 0; i < 11; i++)
            {
                sVal = getRandStr();
                out.show("Добавление " + sVal + " в очередь.");
                sq.put(sVal);
            }
        }catch(QueueFullException exc){
            out.show(exc.toString());
        }
        
        try{
            for(int i = 0; i < 11; i++){
                sVal = sq.get();
                out.show("Получение " + sVal + " элемента из очереди");
            }
        } catch(QueueEmptyException exc){
            out.show(exc.toString());
        }
    }
    
}
