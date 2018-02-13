package info.twobteam.structures.graphs;

import java.util.*;

public class Graph<T, U> {
	private final List<GraphNode<T>> nodes = new ArrayList<>();
	private final List<GraphEdge<T, U>> edges = new ArrayList<>();
	private final Map<GraphNode<T>, List<GraphEdge<T, U>>> adjacency = new HashMap<>();

	public Graph() {}

	public List<GraphNode<T>> getNodes() {
		return nodes;
	}

	public Optional<GraphNode<T>> getNodeById(int id) {
		return nodes.stream().filter(node -> node.id == id).findFirst();
	}

	public List<GraphEdge<T, U>> getAdjacent(GraphNode node) {
		return adjacency.getOrDefault(node, Collections.emptyList());
	}

	public void addNode(GraphNode<T> node) {
		nodes.add(node);
	}

	public void addEdge(GraphEdge<T, U> edge) {
		edges.add(edge);

		if (!adjacency.containsKey(edge.from)) {
			adjacency.put(edge.from, new ArrayList<>());
		}
		adjacency.get(edge.from).add(edge);
	}
}
