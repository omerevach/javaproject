package algorithm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarSearchAlgoImpl<T extends GraphNode> implements ISearchAlgo<T> {
	private Graph<T> graph;
	private Scorer<T> nextNodeScorer;
	private Scorer<T> targetNodeScorer;
	
	public AStarSearchAlgoImpl(Graph<T> graph, Scorer<T> nextNodeScorer, Scorer<T> targetNodeScorer) {
		this.graph = graph;
		this.nextNodeScorer = nextNodeScorer;
		this.targetNodeScorer = targetNodeScorer;
	}

	@Override
	public List<T> findRoute(T from, T to) {
		Queue<RouteNode<T>> openSet = new PriorityQueue<>();
		Map<T, RouteNode<T>> allNodes = new HashMap<>();

		RouteNode<T> start = new RouteNode<>(from, null, targetNodeScorer.computeScore(from, to));
		openSet.add(start);
		allNodes.put(from, start);

		while (!openSet.isEmpty()) {
			RouteNode<T> next = openSet.poll();
			if (next.getCurrent().equals(to)) {
				List<T> route = new ArrayList<>();
				RouteNode<T> current = next;

				do {
					route.add(0, current.getCurrent());
					current = allNodes.get(current.getPrevious());
				} while (current != null);

				return route;
			}
			graph.getConnections(next.getCurrent()).forEach(connection -> {
				RouteNode<T> nextNode = allNodes.getOrDefault(connection, new RouteNode<T>(connection));
				allNodes.put(connection, nextNode);

				double newScore = next.getRouteScore() + nextNodeScorer.computeScore(next.getCurrent(), connection);
				if (newScore < nextNode.getRouteScore()) {
					nextNode.setPrevious(next.getCurrent());
					nextNode.setRouteScore(newScore);
					openSet.add(nextNode);
				}

			});
		}
		throw new IllegalStateException("No route found");
	}

}
