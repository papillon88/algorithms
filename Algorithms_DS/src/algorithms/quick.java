/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Debaspreet Chowdhury
 */
public class quick
{
    /**
     * the main quick sort function
     * this function divides the array into 2 sub arrays
     * and then calls the quicksort on each sub arrays.
     */
    public static void quicksort(int begining,int end,int array[])
    {
      int i = dividearray(begining,end,array);
        printarray(array);
      if (begining<(i-1))
            quicksort(begining,i-1,array);
      if (i<end)
            quicksort(i,end,array);
    }
    
    /**
     * the main partioning function
     * that apparently partitions the
     * array into 2 sub arrays.
     */
    public static int dividearray(int begining,int end,int array[])
{
      int i = begining, j = end;
      int temp;
      int p = array[(begining + end) / 2];
      while (i <= j)
      {
            while (array[i]<p)
                  i++;
            while (array[j] >p)
                  j--;
            if(i<=j)
            {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
      }
      return i;
}
    /**
     * prints the array. 
     */
    public static void printarray(int[] array)
    {
        for(int i=0;i<array.length;i++)
        {
           System.out.print(array[i]); 
        } 
        System.out.println();
    }
    
    public static void main(String[] args)
    {
        /**
         * calling the method quicksort from the class
         */
        int[] array = {4,5,6,2,4,8,9,0,2,3,5,6,9,7,6,8};
        quicksort(0,15,array);
    }
    
}
