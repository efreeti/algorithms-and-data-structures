package info.twobteam.algorithms.graphs;

import info.twobteam.structures.graphs.Graph;
import info.twobteam.structures.graphs.GraphNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearchStrategy<NodeData, EdgeData> {
	public Map<GraphNode<NodeData>, Integer> process(Graph<NodeData, EdgeData> graph, GraphNode<NodeData> startNode) {
		Map<GraphNode<NodeData>, Integer> matrix = new HashMap<>();
		Queue<AccumulationQueueItem<NodeData, Integer>> queue = new LinkedList<>();

		queue.add(new AccumulationQueueItem(startNode, 0));

		while (!queue.isEmpty()) {
			AccumulationQueueItem<NodeData, Integer> item = queue.poll();

			if (!matrix.containsKey(item.node)) {
				matrix.put(item.node, item.accumulatedData);

				graph.getAdjacent(item.node).forEach(edge -> {
					queue.add(new AccumulationQueueItem(edge.to, item.accumulatedData + 1));
				});
			}
		}

		return matrix;
	}
}
