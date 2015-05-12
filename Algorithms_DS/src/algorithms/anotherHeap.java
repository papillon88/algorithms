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
public class anotherHeap {
    
    public int array[];
    
    public anotherHeap(){array = new int[]{1,2,3,4,5,6,7,8,9,10,15,12,13,14,15};}
    
    
    public void heapify()
    {
        for(int i=this.array.length;i>=2;i--)
        {
            //System.out.print(this.array[i-1]+""+this.array[(i/2)-1]);
            
            //if (this.array[i-1]>this.array[(i/2)-1]){
                
               // swap(this.array[i-1],this.array[(i/2)-1]);
                
                /*
                int temp = this.array[i-1];
                this.array[i-1]=this.array[(i/2)-1];
                this.array[(i/2)-1]=temp;
                
                */
            percolate_up(i);
            
            //this.swap(this.array[i-1],this.array[(i/2)-1]);
            //System.out.println(" "+this.array[i-1]+""+this.array[(i/2)-1]);
            percolate_down(i,this.array.length); 
            
        }
    }
    
    
    public void percolate_up(int i)
    {
        if (this.array[i-1]>this.array[(i/2)-1]){
            int temp = this.array[i-1];
            this.array[i-1]=this.array[(i/2)-1];
            this.array[(i/2)-1]=temp;
        }
        
        /*
        int temp = a;
        a=b;
        b=temp;
        */
    }
    
    public void percolate_down(int i,int l)
    {
        if((2*i+1)<=l){
                if(this.array[2*i-1]<this.array[2*i]){
                //swap(array[2*i],array[i-1]);
                    if(this.array[2*i]>this.array[i-1]){
                        int temp = this.array[2*i];
                        this.array[2*i]=this.array[i-1];
                        this.array[i-1]=temp;
                        percolate_down(2*i+1,l);
                    }
                }
                else{
                    if(this.array[2*i-1]>this.array[i-1]){
                        int temp = this.array[2*i-1];
                        this.array[2*i-1]=this.array[i-1];
                        this.array[i-1]=temp;
                        percolate_down(2*i,l);
                    }
                }
            }
        }
    
    public void heapsort()
    {
        for(int i=this.array.length-1;i>=2;i--){
            int temp=this.array[0];
            this.array[0]=this.array[i];
            this.array[i]=temp;
            percolate_down(1,i);
            this.printHeap();
        }
        /*
        
        int temp=this.array[0];
        this.array[0]=this.array[array.length-1];
        this.array[array.length-1]=temp;
        percolate_down(1,this.array.length-1);
        this.printHeap();
        
        temp=this.array[0];
        this.array[0]=this.array[array.length-2];
        this.array[array.length-2]=temp;
        percolate_down(1,this.array.length-2);
        this.printHeap();
        
        temp=this.array[0];
        this.array[0]=this.array[array.length-3];
        this.array[array.length-3]=temp;
        percolate_down(1,this.array.length-3);
        this.printHeap();
        
        temp=this.array[0];
        this.array[0]=this.array[array.length-4];
        this.array[array.length-4]=temp;
        percolate_down(1,this.array.length-4);
        this.printHeap();
        
        temp=this.array[0];
        this.array[0]=this.array[array.length-5];
        this.array[array.length-5]=temp;
        percolate_down(1,this.array.length-5);
        this.printHeap();
        */
    }
    
    public void insert(int n)
    {
        int[] ary = new int[this.array.length + 1];
        for(int i=0;i<this.array.length;i++)
            ary[i]=this.array[i];
        ary[this.array.length]=n;
        this.array=ary;
    }
    
    public void deletemax()
    {
      //assuming the heap is heapified
        int temp=this.array[0];
        this.array[0]=this.array[array.length-1];
        this.array[array.length-1]=temp;
        percolate_down(1,this.array.length-1);
        
        int[] ary = new int[this.array.length -1];
        for(int i=0;i<this.array.length-1;i++)
            ary[i]=this.array[i];
        this.array=ary;
    }
    
    public void printHeap()
    {
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
    
    
    
    public static void main(String[] args)
    {   
        anotherHeap someHeap = new anotherHeap();
        someHeap.heapify(); //heapify implements percolate up and prcolate down.
        someHeap.printHeap();
        someHeap.heapsort(); 
        someHeap.printHeap();
        
        someHeap.insert(21);
        someHeap.printHeap();
        someHeap.heapify();
        someHeap.printHeap();
        
        someHeap.deletemax();
        someHeap.printHeap();
        
        someHeap.deletemax();
        someHeap.printHeap();
        
    }
    
}
