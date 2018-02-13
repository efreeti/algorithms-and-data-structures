package info.twobteam.algorithms.graphs;

import info.twobteam.structures.graphs.GraphNode;

public class AccumulationQueueItem<NodeData, AccumulatedData> {
	public final GraphNode<NodeData> node;
	public final AccumulatedData accumulatedData;

	public AccumulationQueueItem(GraphNode<NodeData> node, AccumulatedData accumulatedData) {
		this.node = node;
		this.accumulatedData = accumulatedData;
	}
}
