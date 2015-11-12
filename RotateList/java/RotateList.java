/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class RotateList {
   public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return head;
		if (k == 0) return head;
		// Find out size of list so that k can be validated
		int size = 0;
		ListNode current = head;
		while(current != null){
		    size++;
		    current = current.next;
		}
		k = k % size;
		// Run two pointers to separate each other by k places
		int count = 0;
		ListNode fast = null;
		// Advance the first pointer by k places
		while (count < k) {
			count++;
			if (fast == null) {
				fast = head;
			} else {
				fast = fast.next;
				// In case fast pointer goes out bring it back to head
				// this might happen when k > size of list
				if (fast == null){
					fast = head;
				}
			}
		}
		ListNode slow = null;
		// Now advance the slow and fast pointer till fast reaches end of the
		// list
		while (fast != null && fast.next != null) {
			if (slow == null) {
				slow = head;
			} else {
				slow = slow.next;
			}
			fast = fast.next;
		}
		// If slow is null that means the array is rotated to same state
		// Hence no changes are neede
		if(slow != null){
			// Now set the node next to slow as new head
			// and put the old head behind the fast
			fast.next = head;
			head = slow.next;
			// Break the link by pointing next of slow to null
			// otherwise cycle will get created
			slow.next = null;
		}
		return head;

	}
}