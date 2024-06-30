package Graph;
import java.util.*;

public class GraphNode<T> {
    private T value;
    private List<GraphNode<T>> neighbors;

    public GraphNode(T value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<GraphNode<T>> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(GraphNode<T> neighbor) {
        this.neighbors.add(neighbor);
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "value=" + value +
                ", neighbors=" + neighbors +
                '}';
    }

    public static void main(String[] args) {
        // Example usage
        GraphNode<String> nodeA = new GraphNode<>("A");
        GraphNode<String> nodeB = new GraphNode<>("B");
        GraphNode<String> nodeC = new GraphNode<>("C");

        nodeA.addNeighbor(nodeB);
        nodeA.addNeighbor(nodeC);

        System.out.println(nodeA);
    }
}
