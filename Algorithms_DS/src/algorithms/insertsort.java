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
public class insertsort {
    
    public char[] c;
    
    public static void insertsort1(char[] c){
        //char[] n;
        int l = c.length;
        for(int k=1;k<l;k++){
        //System.out.println(c);
            int m = k;
            while (m>0){
             if (c[m]<c[m-1]){
                 char r;
                 //swap(c[m-1],c[m]);
                 r=c[m];
                 c[m]=c[m-1];
                 c[m-1]=r;
                 m=m-1;
             }
             System.out.println(c);
             
            }
            
        }
    }
    /*
    public static void swap(char c1, char c2){
        char c3 = 'c';
        c3=c2;
        c2=c1;
        c1=c3;
        System.out.println("calling swap");
    }
    */
    
}
