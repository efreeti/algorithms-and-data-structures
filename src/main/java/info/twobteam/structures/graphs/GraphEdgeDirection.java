package info.twobteam.structures.graphs;

public class GraphEdgeDirection<T, U> {
	public final GraphEdge<T, U> edge;
	public final GraphNode<T> node;

	public GraphEdgeDirection(GraphEdge<T, U> edge, GraphNode<T> node) {
		this.edge = edge;
		this.node = node;
	}
}
