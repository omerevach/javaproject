package algorithm;

public class RouteNode<T extends GraphNode> implements Comparable<RouteNode>

{
	private T current;
	private T previous;
	private double routeScore;

	public RouteNode(T current) {
		this(current, null, Double.POSITIVE_INFINITY);

	}

	public RouteNode(T current, T previous, double routeScore) {
		this.current = current;
		this.previous = previous;
		this.routeScore = routeScore;
	}

	@Override
	public int compareTo(RouteNode o) {
		if (this.routeScore > o.routeScore)
			return 1;

		else if (this.routeScore < o.routeScore)
			return -1;
		return 0;
	}

	public T getCurrent() {
		return current;
	}

	public T getPrevious() {
		return previous;
	}

	public void setPrevious(T previous) {
		this.previous = previous;
	}

	public double getRouteScore() {
		return routeScore;
	}

	public void setRouteScore(double routeScore) {
		this.routeScore = routeScore;
	}

}
