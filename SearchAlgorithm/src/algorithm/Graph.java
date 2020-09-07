package algorithm;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph<T extends GraphNode> implements Serializable {
	private Set<T> nodes;
	private Map<String, Set<String>> connections;

	public Graph() {
		connections = new HashMap<String, Set<String>>();
		nodes = new HashSet<T>();
	}

	public T getNode(String name) {
		return nodes.stream().filter(node -> node.getName().equals(name)).findFirst()
				.orElseThrow(() -> new IllegalArgumentException("No node found with this name"));
	}

	public Set<T> getConnections(T node) {
		return connections.get(node.getName()).stream().map(this::getNode).collect(Collectors.toSet());
	}

	private boolean addNode(T node) {
		if (!nodes.add(node))
			return false;
		return true;
	}

	public void addConnection(T from, T to) {
		Set<String> neighbours = connections.get(from.getName());

		if (neighbours == null) {
			neighbours = new HashSet<String>();
		}
		addNode(from);
		addNode(to);
		if (neighbours.add(to.getName()))
			//throw new RuntimeException("Connection Already Exist");
		connections.put(from.getName(), neighbours);

	}
}
