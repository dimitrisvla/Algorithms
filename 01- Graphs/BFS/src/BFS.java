import java.util.Queue;
import java.util.LinkedList;


public class BFS {

	// Perform BFS
    public void bfsMethod(int[][] graph, int sourceNode) {
        int numNodes = graph.length;
        
        // Boolean array to keep track of visited nodes
        boolean[] visited = new boolean[numNodes];
        
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        
        // Enqueue the source(starting) node
        queue.add(sourceNode);
        // Mark it as visited
        visited[sourceNode] = true;
        
        while (!queue.isEmpty()) {
            // Dequeue a node from Queue 
            int node = queue.poll();
            // Print the node
            System.out.println("Visited node: " + node);
            
            // Get all adjacent vertices of the dequeued vertex node (Layer i)
            // If an adjacent vertex has not been visited, then mark it visited and enqueue it
            for (int i = 0; i < numNodes; i++) {
                // Check if the nodes are adjacent and if the specific node is visited
                if (graph[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
	
	public static void main(String[] args) {
		// Test bfsMethod with an example.
		// we use an adjacency matrix
        int[][] graph = {
            {0, 1, 1, 0, 0},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
        };
        
        BFS bfs = new BFS();
        // Starting BFS from node 0 
        System.out.println("For the given graph:\n ");
        printAdjacencyMatrix(graph);
        System.out.println("Traversal from source node 0: ");
        bfs.bfsMethod(graph, 0);
	}
	
	 public static void printAdjacencyMatrix(int[][] array) {
		 for (int i = 0; i < array.length; i++) { 
			 for (int j = 0; j < array[i].length; j++) { 
				 System.out.print(array[i][j] + " "); 
	         }
	         System.out.println(); 
	     }
		 System.out.println();
	 }

}
