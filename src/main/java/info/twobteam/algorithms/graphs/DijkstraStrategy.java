package info.twobteam.algorithms.graphs;

import info.twobteam.structures.graphs.Graph;
import info.twobteam.structures.graphs.GraphEdge;
import info.twobteam.structures.graphs.GraphNode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiFunction;

public class DijkstraStrategy<NodeData, EdgeData, AccumulatedData> {
	protected final BiFunction<AccumulatedData, GraphEdge<NodeData, EdgeData>, AccumulatedData> accumulator;
	protected final Comparator<AccumulatedData> comparator;

	public DijkstraStrategy(
		BiFunction<AccumulatedData, GraphEdge<NodeData, EdgeData>, AccumulatedData> accumulator,
		Comparator<AccumulatedData> comparator
	) {
		this.accumulator = accumulator;
		this.comparator = comparator;
	}

	public Map<GraphNode<NodeData>, AccumulatedData> process(
		Graph<NodeData, EdgeData> graph,
		GraphNode<NodeData> startNode,
		AccumulatedData startData
	) {
		Set<GraphNode<NodeData>> visited = new HashSet<>();
		Map<GraphNode<NodeData>, AccumulatedData> matrix = new HashMap<>();
		Queue<AccumulationQueueItem<NodeData, AccumulatedData>> queue = new PriorityQueue<>(
			(item1, item2) -> comparator.compare(item1.accumulatedData, item2.accumulatedData)
		);

		queue.add(new AccumulationQueueItem(startNode, startData));

		while (!queue.isEmpty()) {
			AccumulationQueueItem<NodeData, AccumulatedData> item = queue.poll();

			if (!visited.contains(item.node)) {
				if (!matrix.containsKey(item.node) || comparator.compare(matrix.get(item.node), item.accumulatedData) > 0) {
					matrix.put(item.node, item.accumulatedData);
				}

				graph.getAdjacent(item.node).forEach(edge -> {
					queue.add(new AccumulationQueueItem(edge.to, accumulator.apply(item.accumulatedData, edge)));
				});

				visited.add(item.node);
			}
		}

		return matrix;
	}}
