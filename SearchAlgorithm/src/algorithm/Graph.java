package algorithm;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph<T extends GraphNode> {
	private Set<T> nodes;
	private Map<String, Set<String>> connections;

	public T getNode(String name) {
		return nodes.stream().filter(node -> node.getName().equals(name)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No node found with this name"));
	}

	public Set<T> getConnections(T node) {
		return connections.get(node.getName()).stream().map(this::getNode).collect(Collectors.toSet());
	}
}
