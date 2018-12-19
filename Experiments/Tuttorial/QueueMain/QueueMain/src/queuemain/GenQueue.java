/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queuemain;

/**
 *
 * @author Vladimir Hrechko
 * @param <T>
 */
public class GenQueue<T> implements IGenQ<T> {
    final   T q[];
    private int putloc, getloc;
    
    public GenQueue(T[] aRef){
        q = aRef;
        putloc = getloc = 0;
    }
    
    @Override
    public void put(T obj) throws QueueFullException{
        if(putloc == q.length - 1) throw new QueueFullException(q.length);
        q[putloc++] = obj;
    }
    
    @Override
    public T get() throws QueueEmptyException{
        if(getloc == putloc) throw new QueueEmptyException();
        
        return q[getloc++];
    }
}
