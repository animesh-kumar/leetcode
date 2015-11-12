import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	// Definition for a binary tree node.
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> right = new ArrayList<Integer>();
		// Polulate the nodes using a list
		// the last entry in the list will be right most element
		// i.e., the top of stack
		if (root == null)
			return right;
		List<TreeNode> current = new ArrayList<TreeNode>();
		List<TreeNode> children = new ArrayList<TreeNode>();
		// Add the root to current
		current.add(root);
		// Get children of each current element and put it onto children
		while (current != null && current.size() > 0) {
			children = new ArrayList<TreeNode>();
			int i = 0;
			while (i < current.size()) {
				TreeNode node = current.get(i);
				if (node.left != null) {
					children.add(node.left);
				}
				if (node.right != null) {
					children.add(node.right);
				}
				i++;
			}

			// Get the last element in the current list
			TreeNode rightNode = current.get(current.size() - 1);
			// Put the last element in the current to the list
			right.add(rightNode.val);
			// Replace the current list with children list
			current = children;
			// All leaf nodes were parsed and hence the current is now empty
			// exit the loop
			if (current.size() == 0) {
				break;
			}
		}
		return right;
	}
}