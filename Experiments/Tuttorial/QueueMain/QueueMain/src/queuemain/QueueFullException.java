/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemain;

/**
 *
 * @author Vladimir Hrechko
 */
public class QueueFullException extends Exception {

    int size;
    /**
     * Creates a new instance of <code>QueueFullException</code> without detail
     * message.
     * @param s
     */
    public QueueFullException(int s) { size = s;}
    
    @Override
    public String toString(){
        return "\nОчередь заполнена. Максимальный размер очереди: " + size;
    }
}
