package info.twobteam.algorithms.trees;

import info.twobteam.structures.trees.BinaryTree;
import info.twobteam.structures.trees.BinaryTreeNode;

import java.util.function.Consumer;

public class BinaryTreeTraversalStrategy<NodeData> {
	public void visitInOrder(BinaryTreeNode<NodeData> node, Consumer<BinaryTreeNode<NodeData>> visitor) {
		node.left.ifPresent(left -> visitInOrder(left, visitor));
		visitor.accept(node);
		node.right.ifPresent(right -> visitInOrder(right, visitor));
	}

	public void visitInOrder(BinaryTree<NodeData> tree, Consumer<BinaryTreeNode<NodeData>> visitor) {
		visitInOrder(tree.root, visitor);
	}

	public void visitPreOrder(BinaryTreeNode<NodeData> node, Consumer<BinaryTreeNode<NodeData>> visitor) {
		visitor.accept(node);
		node.left.ifPresent(left -> visitPreOrder(left, visitor));
		node.right.ifPresent(right -> visitPreOrder(right, visitor));
	}

	public void visitPreOrder(BinaryTree<NodeData> tree, Consumer<BinaryTreeNode<NodeData>> visitor) {
		visitPreOrder(tree.root, visitor);
	}

	private void visitPostOrder(BinaryTreeNode<NodeData> node, Consumer<BinaryTreeNode<NodeData>> visitor) {
		node.left.ifPresent(left -> visitPostOrder(left, visitor));
		node.right.ifPresent(right -> visitPostOrder(right, visitor));
		visitor.accept(node);
	}

	public void visitPostOrder(BinaryTree<NodeData> tree, Consumer<BinaryTreeNode<NodeData>> visitor) {
		visitPostOrder(tree.root, visitor);
	}
}
