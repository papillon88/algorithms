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
public class nodereverse {
    
    public nodereverse head;
    public int n;
    public int m=0;
    
    public nodereverse(){
        head=null;
        n=0;
    }
    
    public nodereverse reverse(nodereverse no){
        
        /*
        if (no.head==null){
            System.out.println(no);
            return no;
        }
        System.out.println(no);
        return reverse(no.head);
        */
        
        //if (no==this)
          //  no=this;
        if (no.head.head==null){
            no.head.head=no;
            nodereverse c = no.head;
            System.out.println(c);
            System.out.println(c.head);
            return c;
        }
        nodereverse d = reverse(no.head);
        no.head.head=no;
        if (no==this)
            no.head=null;
        System.out.println(no);
        return d;
        
        
        
        /*
        m=m+1;
        System.out.println(m);
        if (no.head==null){
            System.out.println("end");
            return;
        }
        reverse(no.head);
        m=m-1;
        System.out.println(m);
       */
        
        
        
        /*
        nodereverse a;
        nodereverse b = this;
        a=b.head.head.head;
        a.head = b.head.head;
        a.head.head=b.head;
        a.head.head.head=b;
        a.head.head.head.head=null;
        return a;
                */
                
    }
    
    public static void main(String args[]){
        
        nodereverse no1 = new nodereverse();
        nodereverse no2 = new nodereverse();
        nodereverse no3 = new nodereverse();
        nodereverse no4 = new nodereverse();
        
        no1.head=no2;
        no2.head=no3;
        no3.head=no4;
        
        System.out.println(no1);
        System.out.println(no2);
        System.out.println(no3);
        System.out.println(no4);
        System.out.println(no4.head);
        
        nodereverse temp=no1.reverse(no1);
   
        System.out.println(temp);
        System.out.println(temp.head);
        System.out.println(temp.head.head);
        System.out.println(temp.head.head.head);
        System.out.println(temp.head.head.head.head);
        
    }
    
}
