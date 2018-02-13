package info.twobteam.algorithms.graphs;

import info.twobteam.structures.graphs.Graph;
import info.twobteam.structures.graphs.GraphEdge;
import info.twobteam.structures.graphs.GraphNode;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BreadthFirstSearchStrategyTest {
	private Graph<Void, Void> createTestGraph1() {
		Graph<Void, Void> graph = new Graph<>();

		graph.addNode(new GraphNode<>(1, null));
		graph.addNode(new GraphNode<>(2, null));
		graph.addNode(new GraphNode<>(3, null));
		graph.addNode(new GraphNode<>(4, null));
		graph.addNode(new GraphNode<>(5, null));
		graph.addNode(new GraphNode<>(6, null));

		graph.addEdge(new GraphEdge<>(graph.getNodeById(1).get(), graph.getNodeById(2).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(1).get(), graph.getNodeById(3).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(1).get(), graph.getNodeById(4).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(2).get(), graph.getNodeById(5).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(2).get(), graph.getNodeById(4).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(3).get(), graph.getNodeById(6).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(4).get(), graph.getNodeById(6).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(4).get(), graph.getNodeById(5).get(), null));
		graph.addEdge(new GraphEdge<>(graph.getNodeById(5).get(), graph.getNodeById(6).get(), null));

		return graph;
	}

	private Graph<Void, Void> createTestGraph2() {
		Graph<Void, Void> graph = new Graph<>();

		graph.addNode(new GraphNode<>(1, null));
		graph.addNode(new GraphNode<>(2, null));

		graph.addEdge(new GraphEdge<>(graph.getNodeById(1).get(), graph.getNodeById(2).get(), null));

		return graph;
	}

	@Test
	public void shouldFindShortestWhenTwoNodes() {
		Graph<Void, Void> graph = createTestGraph2();
		BreadthFirstSearchStrategy<Void, Void> strategy = new BreadthFirstSearchStrategy<>();
		Map<GraphNode<Void>, Integer> matrix = strategy.process(
			graph, graph.getNodes().get(0)
		);

		assertThat(matrix.get(graph.getNodeById(2).get()), is(1));
	}

	@Test
	public void shouldFindShortestWhenManyNodes() {
		Graph<Void, Void> graph = createTestGraph1();
		BreadthFirstSearchStrategy<Void, Void> strategy = new BreadthFirstSearchStrategy<>();
		Map<GraphNode<Void>, Integer> matrix = strategy.process(
			graph, graph.getNodes().get(0)
		);

		assertThat(matrix.get(graph.getNodeById(6).get()), is(2));
	}
}