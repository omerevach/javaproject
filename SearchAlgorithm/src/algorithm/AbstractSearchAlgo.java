package algorithm;

public class AbstractSearchAlgo<T extends GraphNode> {
	private ISearchAlgo<T> searchAlgo;

	public AbstractSearchAlgo(ISearchAlgo<T> searchAlgo) {
		this.searchAlgo = searchAlgo;
	}

	public ISearchAlgo<T> getSearchAlgo() {
		return searchAlgo;
	}

	public void setSearchAlgo(ISearchAlgo<T> searchAlgo) {
		this.searchAlgo = searchAlgo;
	}
	
	public void findRoute(T from, T to) {
		searchAlgo.findRoute(from, to);
	}
	
}
