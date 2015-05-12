/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera_algo_p1;

/**
 *
 * @author papillon
 */
public class stacks<Item> {
    
    Box b;
    
    public stacks(){b=null;}
    
    public void push(Item s){
    
        Box n = new Box(s);
        Box temp = this.b;
        this.b=n;
        n.next=temp;
    
    }
    public Item pop(){
        
        if (this.b!=null){
            
            Item some = (Item)this.b.s;
            this.b=this.b.next;
            return some;
            
        }
        else return null;
        
    }
    
    public static void main(String[] args){
        
        stacks<Integer> stack = new stacks<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
    
    
}

class Box<Item> {
    
    public Item s;
    public Box next;
        
    public Box(Item s){
        this.s=s;
        this.next=null;
    }
    
}
