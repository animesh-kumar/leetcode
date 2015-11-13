import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
	
	// Definition for a binary tree node.
		class TreeNode {
			int val;
			TreeNode left;
			TreeNode right;

			TreeNode(int x) {
				val = x;
			}
		}

		
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderLists = new ArrayList<List<Integer>>();
        Queue<TreeNode> current = new LinkedList<TreeNode>();
        Queue<TreeNode> children = new LinkedList<TreeNode>();
        if (root == null){
            return levelOrderLists;
        }else{
          // Push the root to Queue
          current.add(root);
          // Run the loop till the queue is empty
          while (current.peek() != null){
              List<Integer> level = new ArrayList<Integer>();
              children = new LinkedList<TreeNode>();
              while (current.peek() != null){
                  // Using peek() because it checks for head of queue without removing and also returns null on empty and no exception
                  TreeNode head = current.poll();
                  level.add(head.val);
                  if(head.left != null){
                      children.add(head.left);
                  }
                  if(head.right != null){
                      children.add(head.right);
                  }
              }
              current = children;
              levelOrderLists.add(level);
          }
        }
        return levelOrderLists;
    }
}
