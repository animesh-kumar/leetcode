import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {
	// Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> levels = new ArrayList<List<Integer>>();
		Queue<TreeNode> current = new LinkedList<TreeNode>();
		Queue<TreeNode> children = new LinkedList<TreeNode>();
		current.add(root);
		List<Integer> levlVals = new ArrayList<Integer>();
		int i = 0;
		boolean ltor = false;
		while (current.peek() != null) {
			levlVals = new ArrayList<Integer>();
			children = new LinkedList<TreeNode>();

			if (i % 2 == 0)
				ltor = false;
			else
				ltor = true;
			while (current.peek() != null) {
				TreeNode node = current.poll();
				levlVals.add(node.val);
				if (node.left != null) {
					children.add(node.left);
				}
				if (node.right != null) {
					children.add(node.right);
				}
			}
			// Update the current with the children list
			current = children;
			// Put the list created into the list of level order values
			if (ltor)
				Collections.reverse(levlVals);
			levels.add(levlVals);
			i++;
		}
		return levels;
	}
}
