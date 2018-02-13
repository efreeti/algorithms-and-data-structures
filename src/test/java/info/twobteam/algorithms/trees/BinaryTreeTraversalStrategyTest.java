package info.twobteam.algorithms.trees;

import info.twobteam.structures.trees.BinaryTree;
import info.twobteam.structures.trees.BinaryTreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeTraversalStrategyTest {
	private BinaryTree<Integer> createTestTree1() {
		/*
		                  42
		                 /  \
		              123   7
		              / \
		             12 2
		               /
		              4
		 */
		BinaryTreeNode<Integer> node4 = new BinaryTreeNode<>(4, Optional.empty(), Optional.empty());
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(2, Optional.of(node4), Optional.empty());
		BinaryTreeNode<Integer> node12 = new BinaryTreeNode<>(12, Optional.empty(), Optional.empty());
		BinaryTreeNode<Integer> node7 = new BinaryTreeNode<>(7, Optional.empty(), Optional.empty());
		BinaryTreeNode<Integer> node123 = new BinaryTreeNode<>(123, Optional.of(node12), Optional.of(node2));
		BinaryTreeNode<Integer> node42 = new BinaryTreeNode<>(42, Optional.of(node123), Optional.of(node7));
		return new BinaryTree<>(node42);
	}

	@Test
	public void shouldWalkInOrder() {
		List<Integer> result = new ArrayList<>();
		new BinaryTreeTraversalStrategy<Integer>().visitInOrder(
			createTestTree1(), node -> result.add(node.data)
		);

		assertThat(result.get(0), is(12));
		assertThat(result.get(1), is(123));
		assertThat(result.get(2), is(4));
		assertThat(result.get(3), is(2));
		assertThat(result.get(4), is(42));
		assertThat(result.get(5), is(7));
	}

	@Test
	public void shouldWalkPreOrder() {
		List<Integer> result = new ArrayList<>();
		new BinaryTreeTraversalStrategy<Integer>().visitPreOrder(
			createTestTree1(), node -> result.add(node.data)
		);

		assertThat(result.get(0), is(42));
		assertThat(result.get(1), is(123));
		assertThat(result.get(2), is(12));
		assertThat(result.get(3), is(2));
		assertThat(result.get(4), is(4));
		assertThat(result.get(5), is(7));
	}

	@Test
	public void shouldWalkPostOrder() {
		List<Integer> result = new ArrayList<>();
		new BinaryTreeTraversalStrategy<Integer>().visitPostOrder(
			createTestTree1(), node -> result.add(node.data)
		);

		assertThat(result.get(0), is(12));
		assertThat(result.get(1), is(4));
		assertThat(result.get(2), is(2));
		assertThat(result.get(3), is(123));
		assertThat(result.get(4), is(7));
		assertThat(result.get(5), is(42));
	}
}