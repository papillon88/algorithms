/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursera_algo_p1;
import java.util.Scanner;

/**
 *
 * @author papillon
 */
public class dijkstrastack {
    
    public static void main(String[] args){
        
        stacks nu = new stacks();
        stacks op = new stacks();
        Scanner scan = new Scanner(System.in);
        
        while(!scan.hasNext("quit")){
            String s = scan.next();
            
            if(s.equals("(")) ;
            else if(s.equals("+")) op.push(s);
            else if(s.equals("*")) op.push(s);
            else if(s.equals(")")) {
                
                String temp = op.pop().toString();
                if (temp.equals("+")){
                    nu.push(((int)nu.pop()+(int)nu.pop()));
                }
                if (temp.equals("*")){
                    nu.push(((int)nu.pop()*(int)nu.pop()));
                }
            }
            else
                nu.push(Integer.parseInt(s));
        }
        
        System.out.println((int)nu.pop());
    }
    
}
