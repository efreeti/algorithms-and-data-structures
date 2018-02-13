package info.twobteam.structures.trees;

import java.util.Optional;

public class BinaryTreeNode<NodeData> {
	public final NodeData data;
	public final Optional<BinaryTreeNode<NodeData>> left;
	public final Optional<BinaryTreeNode<NodeData>> right;

	public BinaryTreeNode(NodeData data, Optional<BinaryTreeNode<NodeData>> left, Optional<BinaryTreeNode<NodeData>> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
