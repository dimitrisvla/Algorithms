import java.util.Stack;

public class TopologicalSorting {
	
	private int[][] adjacencyMatrix; 
	private boolean[] visited; // we must know if a node is visited
	private int N; // Number of vertices
	
	
	public TopologicalSorting(int N) {
        this.N =N;
        adjacencyMatrix = new int[N][N];
        visited = new boolean[N];
    }
	
	// Topological Sort functionality. 
    void topologicalSort() {
        Stack<Integer> stack = new Stack<Integer>();

        // Mark all the vertices as not visited
        for (int i = 0; i < N; i++) {
            visited[i] = false;
        }

        // Call the recursive helper method to store our Topological Sort. 
        // We start from all vertices and we move on one by one
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
            	topologicalSortHelper(stack, i, visited);
            }
        }

        // Print content of stack
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
	
	
	private void topologicalSortHelper(Stack<Integer> stack, int u, boolean[] visited)  {
		// Mark the current node as visited.
        visited[u] = true;

        // Recursive function for all the nodes adjacent to this node
        for (int i = 0; i < N; i++) {
            if (adjacencyMatrix[u][i] == 1 && !visited[i]) {
            	topologicalSortHelper(stack, i, visited);
            }
        }

        // Push current node to the stack which will store the final result
        stack.push(u);
	}

	// Add an edge into the graph
    void addAnEdge(int u, int v) {
    	adjacencyMatrix[u][v] = 1; // u & v are now adjacent
    }

	public static void main(String[] args) {
		// Create a graph with adding edges to the nodes
		TopologicalSorting graph = new TopologicalSorting(6);
		graph.addAnEdge(5, 0);
		graph.addAnEdge(5, 2);
		graph.addAnEdge(5, 3);
		graph.addAnEdge(4, 0);
		graph.addAnEdge(4, 1);
		graph.addAnEdge(3, 1);
		graph.addAnEdge(2, 3);
		graph.addAnEdge(1, 0);
		
        System.out.println("Topological sort of the given graph:");
        graph.topologicalSort();
	}

}
