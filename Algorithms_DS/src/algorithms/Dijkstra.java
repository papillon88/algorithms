package algorithms;    
import java.util.*;     
import java.util.Queue;

/* main Dijkstra class*/
public class Dijkstra
    {
        private int vector[];
        private Queue<Integer> queue;
        private Set<Integer> settled;
        private int nodesNumber;
        private int adjMat[][];

        /*
        dijkstra constructor that initializes the
        number of nodes,distances between the nodes
        in an adjacency matrix.
        */
        public Dijkstra(int nodesNumber)
        {
            this.nodesNumber = nodesNumber;
            vector = new int[nodesNumber + 1];
            settled = new HashSet<Integer>();
            queue = new LinkedList<Integer>();
            adjMat = new int[nodesNumber + 1][nodesNumber + 1];
        }
        
        /*
        describes the movement from the source
        to each node based on neighbour discovery.
        */
        private void neighbourDisc(int testNode)
        {
            int edgeDistance = -1;
            int newDistance = -1;

            for (int destiNode = 1; destiNode <= nodesNumber; destiNode++)
            {
                if (!settled.contains(destiNode))
                {
                    if (adjMat[testNode][destiNode] != Integer.MAX_VALUE)
                    {
                        edgeDistance = adjMat[testNode][destiNode];
                        newDistance = vector[testNode] + edgeDistance;
                        if (newDistance < vector[destiNode])
                        {
                            vector[destiNode] = newDistance;
                        }
                        queue.add(destiNode);
                    }
                }
            }
        }

        /*calculate the minimum distance
        between each nodes based on edge
        weights.        
        */
        private int minDist()
        {
            int min ;
            int node = 0;
            Iterator<Integer> iterator = queue.iterator();
            node = iterator.next();
            min = vector[node];

            for (int i = 1; i <= vector.length; i++)
            {
                if (queue.contains(i))
                {
                    if (vector[i] <= min)
                    {
                        min = vector[i];
                        node = i;			
                    }
                }
            }
            queue.remove(node);
            return node;
        }
        
        /*
        implements the main dijkstras algorithm
        */
        public void dijkalgo(int adjamat[][], int source)
        {
            int testNode;
            for (int i = 1; i <= nodesNumber; i++)
                for (int j = 1; j <= nodesNumber; j++)
                    adjMat[i][j] = adjamat[i][j];
  
            for (int i = 1; i <= nodesNumber; i++)
            {
                vector[i] = Integer.MAX_VALUE;
            }

            queue.add(source);
            vector[source] = 0;
    
            while (!queue.isEmpty())
            {
                testNode = minDist();
                settled.add(testNode);
                neighbourDisc(testNode);
            }
        }

        /*
        main function that implements all the methods
        and the main class.
        */
        public static void main(String[] args)
        {
            int adjamat[][];
            int verticesNumber;
            int source = 0;
            Scanner scan = new Scanner(System.in);
            
            try
            {
                System.out.println("Number of vertices");
                verticesNumber = scan.nextInt();
                adjamat = new int[verticesNumber + 1][verticesNumber + 1];

                System.out.println("Adjacency Matrix for the graph");
        
                while (true)
                {
                    int c=0;
                    for (int i = 1; i <= verticesNumber; i++)
            {
                for (int j = 1; j <= verticesNumber; j++)
                {
                    if (i==j)
                    {
                        adjamat[i][j]=0;
                        continue;
                    }
                    if (adjamat[i][j] == 0)
                        {
                            adjamat[i][j] = Integer.MAX_VALUE;
                        }
                    adjamat[i][j] = (int)(Math.random()*10);
                    if (adjamat[i][j]>=1)
                        c++;
                }
                
            }
            if (c>75)
                break;
            else
                continue;
        }
        for (int i = 1; i <= verticesNumber; i++)
        {
            for (int j = 1; j <= verticesNumber; j++)
            {
                System.out.print(adjamat[i][j]+" ");  
            }
            System.out.println();
        }
                System.out.println("source ");
                source = scan.nextInt();
                Dijkstra queueObject = new Dijkstra(verticesNumber);
                queueObject.dijkalgo(adjamat, source);

                System.out.println("shortest path to all nodes are ");
                for (int i = 1; i <= queueObject.vector.length - 1; i++)
                {
                    System.out.println(source + " to " + i + " is " + queueObject.vector[i]);
                }
            } catch (InputMismatchException inputMismatch)
            {
                System.out.println("Wrong Input Format");
            }
            scan.close();
        }
    }