/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

public class dfsgraph
{
    private Queue1 queue;
    
    public dfsgraph()
    {
       this.queue = new Queue1();
    }
    
/**
 * The dfs method that implements the dfs algorithm.
 */
        
    public void dfs(int matrix[][], int origin)
    {
        int vertices_number = matrix[origin].length;
        int[] located = new int[vertices_number];
        int i, y;
        located[origin] = 1;
        this.queue.add(origin);
        while (!this.queue.empty())
        {
            y = this.queue.showhead();
            i=0;
            //System.out.print(y + " ");
            while (i < vertices_number)
            {
                if (matrix[y][i] == 1 && located[i] == 0)
                {
                    this.queue.add(i);
                    located[i] = 1;
                    //System.out.print(i + " ");
                    y=i;i=0;
                }
                else
                    i++;
            }
            System.out.print(this.queue.showhead() + " ");
            this.queue.remove();
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
                    matrix[i][j] = ((int)(Math.random()*10))%2;
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
        System.out.println("Corresponding DFS traversal from the first root is ");
        dfsgraph dfs1 = new dfsgraph();
        dfs1.dfs(matrix, origin);
        
/**
 * graph traversal from another root.
 */
        System.out.println();
        System.out.println();
        origin = 13;
        System.out.println("Second root for the graph :"+origin);
        System.out.println("Corresponding DFS traversal from the second root is ");
        dfsgraph dfs2 = new dfsgraph();
        dfs2.dfs(matrix, origin);
        System.out.println();
        
    }
}

/**
 * Implementation of FIFO queue using Queue1 class,a
 * this class implements 3 methods - empty,add and remove.
 * @author Debaspreet Chowdhury
 */

class Queue1
{
    public int n;
    public Queue1 next;
    
    public Queue1(int n)
    {
        this.n=n;
        this.next=null;
    }
    
    public Queue1()
    {
        this.n=0;
        this.next=null;
    }
    
    public void add(int n)
    {
        if (this.empty())
            this.next = new Queue1(n);
        else
        {
            Queue1 temp = this.next;
            this.next = new Queue1(n);
            this.next.next = temp;
            
        }
    }
    
    public void remove()
    {
        if (this.empty())
            return;
        else
        {
            this.next=this.next.next;
            return;            
        }
    }
    
    public int showhead()
    {
        if (this.empty())
            return 0;
        else
            return this.next.n;  
    }    
    
    public boolean empty()
    {
        if (this.next==null)
            return true;
        else
            return false;
    }
}