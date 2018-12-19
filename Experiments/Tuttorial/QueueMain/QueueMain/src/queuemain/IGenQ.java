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
public interface IGenQ<T> {
    void put(T element) throws QueueFullException;
    T    get()          throws QueueEmptyException;
}
