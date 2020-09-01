package algorithm;
import java.util.List;

public interface ISearchAlgo<T extends GraphNode> {
	List<T> findRoute(T from, T to);
}
