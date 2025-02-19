package graphs;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {

    /*
    Complexity Analysis

Time Complexity : O(N+M), where N is a number of nodes (vertices) and M is a number of edges.

Space Complexity : O(N). This space is occupied by the visited dictionary and in addition to that, space would also be occupied by the queue since we are adopting the BFS approach here. The space occupied by the queue would be equal to O(W) where W is the width of the graph. Overall, the space complexity would be O(N).
*/
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap<>();
        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList<>()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Pop a node say "n" from the from the front of the queue.
            Node n = queue.remove();
            // Iterate through all the neighbors of the node "n"
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put in the visited, if not present already
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    // Add the newly encountered node to the queue.
                    queue.add(neighbor);
                }
                // Add the clone of the neighbor to the neighbors of the clone node "n".
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        // Return the clone of the node from visited.
        return visited.get(node);
    }

    public static void main(String[] args) {

        // Create all four nodes
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        // List of nodes in order of their values (1, 2, 3, 4)
        List<Node> nodes = Arrays.asList(node1, node2, node3, node4);

        // Adjacency list representing neighbors for each node
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(2, 4), // Neighbors for node1 (value 1)
                Arrays.asList(1, 3), // Neighbors for node2 (value 2)
                Arrays.asList(2, 4), // Neighbors for node3 (value 3)
                Arrays.asList(1, 3)  // Neighbors for node4 (value 4)
        );

        // Link each node to its neighbors
        for (int i = 0; i < nodes.size(); i++) {
            Node currentNode = nodes.get(i);
            List<Integer> neighborValues = edges.get(i);
            for (int value : neighborValues) {
                // Convert value to index (value - 1)
                Node neighborNode = nodes.get(value - 1);
                currentNode.neighbors.add(neighborNode);
            }
        }
        Node newNode = new CloneGraph().cloneGraph(node1);
        System.out.println(newNode);
    }
}
