package info.twobteam.structures.graphs;

public class GraphEdge<T, U> {
	public final GraphNode<T> from;
	public final GraphNode<T> to;
	public final U data;

	public GraphEdge(GraphNode<T> from, GraphNode<T> to, U data) {
		this.from = from;
		this.to = to;
		this.data = data;
	}
}
