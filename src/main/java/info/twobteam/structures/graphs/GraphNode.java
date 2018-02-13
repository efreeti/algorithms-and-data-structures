package info.twobteam.structures.graphs;

public class GraphNode<T> {
	public final long id;
	public final T data;

	public GraphNode(long id, T data) {
		this.id = id;
		this.data = data;
	}

	@Override
	public String toString() {
		return "GraphNode<" + this.id + ", " + (data instanceof Object ? data.toString() : "null") + ">";
	}
}
