package algorithm;

public interface Scorer<T extends GraphNode> {
	double computeScore(T from, T to);

}
