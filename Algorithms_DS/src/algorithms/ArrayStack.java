/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author papillon
 */
public class ArrayStack implements Stack {
    
    private static final int capacity = 5;
    private Object[] O;
    private int t=-1;
    
    public ArrayStack(){this(capacity);}
    public ArrayStack(int n){
        O=new Object[n];
    }
    
    public int size(){return (t+1);}
    public boolean empty(){return (t<0);}
    
    public Object top(){
        if(!empty()){
           return O[t]; 
        }
        return null;
    }
    
    public void push(Object some) throws Exception {
        if(size()!=capacity){
            O[++t]=some;
        }
        else
            throw new Exception("stack full");
    }
    public Object pop() throws Exception {
        if(empty()){throw new Exception("stack empty");}
        else{
            return O[t--];
        }
    }
    
    public static void main(String args[]){
        
        ArrayStack somestack = new ArrayStack();
        
        try {
            
            System.out.println(somestack.size());
            System.out.println(somestack.empty());
            System.out.println(somestack.top());
        
            somestack.push(new Object());
            System.out.println(somestack.top());
            somestack.push(new Object());
            System.out.println(somestack.top());
            somestack.push(new Object());
            System.out.println(somestack.top());
        
            System.out.println(somestack.size());
            System.out.println(somestack.empty());
            System.out.println(somestack.pop());
            System.out.println(somestack.pop());
            System.out.println(somestack.pop());
        
            System.out.println(somestack.size());
            System.out.println(somestack.empty());
            System.out.println(somestack.top());
            System.out.println(somestack.pop());
        }
        catch(Exception e){
            System.out.println("empty st");
        }
        
        
        
    }
    
}
