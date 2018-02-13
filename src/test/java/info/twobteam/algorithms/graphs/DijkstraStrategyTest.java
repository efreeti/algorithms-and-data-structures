package info.twobteam.algorithms.graphs;

import info.twobteam.structures.graphs.Graph;
import info.twobteam.structures.graphs.GraphEdge;
import info.twobteam.structures.graphs.GraphNode;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DijkstraStrategyTest {
	private Graph<Void, Integer> createTestGraph1() {
		Graph<Void, Integer> graph = new Graph<>();

		GraphNode<Void> node1 = new GraphNode<>(1, null);
		GraphNode<Void> node2 = new GraphNode<>(2, null);
		GraphNode<Void> node3 = new GraphNode<>(3, null);
		GraphNode<Void> node4 = new GraphNode<>(4, null);
		GraphNode<Void> node5 = new GraphNode<>(5, null);
		GraphNode<Void> node6 = new GraphNode<>(6, null);

		graph.addNode(node1);
		graph.addNode(node2);
		graph.addNode(node3);
		graph.addNode(node4);
		graph.addNode(node5);
		graph.addNode(node6);

		graph.addEdge(new GraphEdge<>(node1, node2, 10));
		graph.addEdge(new GraphEdge<>(node1, node3, 25));
		graph.addEdge(new GraphEdge<>(node1, node4, 20));
		graph.addEdge(new GraphEdge<>(node2, node5, 15));
		graph.addEdge(new GraphEdge<>(node2, node4, 15));
		graph.addEdge(new GraphEdge<>(node3, node6, 40));
		graph.addEdge(new GraphEdge<>(node4, node6, 20));
		graph.addEdge(new GraphEdge<>(node4, node5, 15));
		graph.addEdge(new GraphEdge<>(node5, node6, 20));

		return graph;
	}

	private Graph<Void, Integer> createTestGraph2() {
		Graph<Void, Integer> graph = new Graph<>();

		GraphNode<Void> node1 = new GraphNode<>(1, null);
		GraphNode<Void> node2 = new GraphNode<>(2, null);

		graph.addNode(node1);
		graph.addNode(node2);

		graph.addEdge(new GraphEdge<>(node1, node2, 10));

		return graph;
	}

	@Test
	public void shouldFindShortestWhenTwoNodesStartingAtFirst() {
		Graph<Void, Integer> graph = createTestGraph2();
		DijkstraStrategy<Void, Integer, Integer> strategy = new DijkstraStrategy<>(
			(accumulatedDistance, edge) -> accumulatedDistance + edge.data,
			(distance1, distance2) -> distance1.compareTo(distance2)
		);
		Map<GraphNode<Void>, Integer> matrix = strategy.process(
			graph, graph.getNodes().get(0), 0
		);

		assertThat(matrix.get(graph.getNodeById(2).get()), is(10));
	}

	@Test
	public void shouldFindShortestWhenManyNodes() {
		Graph<Void, Integer> graph = createTestGraph1();
		DijkstraStrategy<Void, Integer, Integer> strategy = new DijkstraStrategy<>(
			(accumulatedDistance, edge) -> accumulatedDistance + edge.data,
			(distance1, distance2) -> distance1.compareTo(distance2)
		);
		Map<GraphNode<Void>, Integer> matrix = strategy.process(
			graph, graph.getNodes().get(0), 0
		);

		assertThat(matrix.get(graph.getNodeById(6).get()), is(40));
	}
}