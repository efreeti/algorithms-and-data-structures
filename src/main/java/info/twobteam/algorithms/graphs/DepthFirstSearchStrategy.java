package info.twobteam.algorithms.graphs;

import info.twobteam.structures.graphs.Graph;
import info.twobteam.structures.graphs.GraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiConsumer;

public class DepthFirstSearchStrategy<NodeData, EdgeData> {
	public void visit(
		Graph<NodeData, EdgeData> graph,
		BiConsumer<GraphNode<NodeData>, GraphNode<NodeData>> visitor
	) {
		Set<GraphNode<NodeData>> visited = new HashSet<>();
		Stack<AccumulationQueueItem<NodeData, GraphNode<NodeData>>> queue = new Stack<>();

		graph.getNodes().forEach(startNode -> {
			if (!visited.contains(startNode)) {
				queue.push(new AccumulationQueueItem<>(startNode, null));

				while (!queue.isEmpty()) {
					AccumulationQueueItem<NodeData, GraphNode<NodeData>> item = queue.pop();

					if (!visited.contains(item.node)) {
						visitor.accept(item.node, item.accumulatedData);
						visited.add(item.node);

						graph.getAdjacent(item.node).forEach(edge -> queue.push(
							new AccumulationQueueItem<>(edge.to, item.node)
						));
					}
				}
			}
		});
	}

	public boolean detectCycles(Graph<NodeData, EdgeData> graph) {
		Set<GraphNode<NodeData>> ancestors = new HashSet<>();
		boolean result = false;

		visit(graph, (node, parent) -> {
			//if ()
		});

		return true;
	}
}
