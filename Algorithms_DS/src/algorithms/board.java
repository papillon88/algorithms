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
public class board {
    
    public scores[] sc;
    public int entry = 0;
    
    public board(int c){
        
        sc = new scores[c];
    }
    
    public void add(scores s){
        
        for (int j=0;j<sc.length;j++){
            if (sc[j]!=null){
               if (s.s >= sc[j].s){
                   
                   //shift to right
                   for (int k = sc.length-1;k>j;k--){
                       if (k==j){
                           //no shifting, only inserting
                           sc[j]=s;
                           break;
                       }
                       else
                           sc[k]=sc[k-1]; 
                   }
                   //insert @ sc[j]
                   sc[j]=s;
                   break;
                   
               }
               else
                   continue;
            }
            else {
                //insert
                sc[j]=s;
                entry++;
                break;
            }
        }
    }
    
}
