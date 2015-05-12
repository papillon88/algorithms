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
public class span {
    
    public static void main(String[] args){
        
        int[] span = {25,5,83,99};
        for(int x=0;x<span.length;x++){
            System.out.print(span[x] +" ");
        }
        System.out.println();
        
        for(int i=0;i<span.length;i++){
            int c=0;
           for(int j=0;j<=i;j++){
               if(span[j]<=span[i]){
                   c=c+1;
               }
               else
                   c=0;
           }
           System.out.print(c+" ");
        }
        System.out.println();
    }   
}
