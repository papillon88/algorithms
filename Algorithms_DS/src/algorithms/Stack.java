/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

import java.util.EmptyStackException;

/**
 *
 * @author papillon
 */
public interface Stack {
    
    public int size();
    public boolean empty();
    public Object top();
    public void push(Object O) throws Exception;
    public Object pop() throws Exception;
    
}
