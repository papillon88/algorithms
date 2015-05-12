/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

public class bfsgraph
{
    private Queue queue;
    
    public bfsgraph()
    {
       this.queue = new Queue();
    }
    
/**
 * The bfs method that implements the bfs algorithm.
 */
        
    public void bfs(int matrix[][], int origin)
    {
        int vertices_number = matrix[origin].length;
        int[] located = new int[vertices_number];
        int i, y;
        located[origin] = 1;
        this.queue.add(origin);
        while (!this.queue.empty())
        {
            y = this.queue.remove();
            i=0;
            System.out.print(y + " ");
            while (i < vertices_number)
            {
                if (matrix[y][i] == 1 && located[i] == 0)
                {
                    this.queue.add(i);
                    located[i] = 1;
                }
                i++;
            }
        }
    }

    public static void main(String[] args)
    {
        int vertices_number = 15, origin;
        System.out.println("Number of nodes in the directed graph :"+vertices_number);
        System.out.println();
        int matrix[][] = new int[vertices_number][vertices_number];
        
/**
 * generation of a random graph having edges more than
 * 100, the loop iterates till a graph with edges
 * more than 100 is not obtained.
 */
        while (true)
        {
            int c=0;
            for (int i = 0; i < vertices_number; i++)
            {
                for (int j = 0; j < vertices_number; j++)
                {
                    if (i==j)
                    {
                        matrix[i][j]=0;
                        continue;
                    }
                    matrix[i][j] = (int)(Math.random()*10);
                    if (matrix[i][j]==1)
                        c++;
                }
                
            }
            if (c>100)
                break;
            else
                continue;
        }
        
        for (int i = 0; i < vertices_number; i++)
        {
            for (int j = 0; j < vertices_number; j++)
            {
                System.out.print(matrix[i][j]+" ");
                
            }
            System.out.println();
        }
       
/**
 * graph traversal from one root.
 */
        System.out.println();
        System.out.println();
        origin = 6;
        System.out.println("First root for the graph :"+origin);
        System.out.println("Corresponding BFS traversal from the first root is ");
        bfsgraph bfs1 = new bfsgraph();
        bfs1.bfs(matrix, origin);
        
/**
 * graph traversal from another root.
 */
        System.out.println();
        System.out.println();
        origin = 13;
        System.out.println("Second root for the graph :"+origin);
        System.out.println("Corresponding BFS traversal from the second root is ");
        bfsgraph bfs2 = new bfsgraph();
        bfs2.bfs(matrix, origin);
        System.out.println();
        
    }
}

/**
 * Implementation of FIFO queue using Queue class,
 * this class implements 3 methods - empty,add and remove.
 * @author Debaspreet Chowdhury
 */

class Queue
{
    public int n;
    public Queue next;
    
    public Queue(int n)
    {
        this.n=n;
        this.next=null;
    }
    
    public Queue()
    {
        this.n=0;
        this.next=null;
    }
    
    public void add(int n)
    {
        if (this.empty())
            this.next = new Queue(n);
        else
        {
            Queue temp = this.next;
            while (temp.next!=null)
            {
                temp = temp.next;
            }
            temp.next = new Queue(n);      
        }
    }
    
    public int remove()
    {
        if (this.empty())
        {
            return 0;
        }
        else
        {
            int temp = this.next.n;
            this.next=this.next.next;
            return temp;            
        }
    }
    
    public boolean empty()
    {
        if (this.next==null)
            return true;
        else
            return false;
    }
}