
public class AddTwoNumbers {

	// Definition for singly-linked list.
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// Add the number and store in List 1
		// If both the lists are null return null
		if (l1 == null && l2 == null) {
			return null;
		} else if (l1 == null && l2 != null) {
			// If one of the list is null and other not return that list
			return l2;
		} else if (l1 != null && l2 == null) {
			return l1;
		}
		ListNode prev1 = null;
		ListNode curr1 = l1;
		ListNode curr2 = l2;
		int carry = 0;

		while (curr1 != null && curr2 != null) {
			// Add both the values of curr1 and curr2 into curr1 also take into
			// account any previous carries
			// Do a mod 10 to keep the value from overflowing
			// i.e., Each value must contain only one digit
			int sum = curr1.val + curr2.val + carry;
			curr1.val = sum % 10;
			// Now decide the carry by dividing by 10 . Any number lesser than
			// 10 will give carry 0
			// anything more will give 1. The total can never be more than 19.
			// So carry can't exceed 1
			carry = sum / 10;
			// Update the list pointers
			// Set the current as previous
			// Update the current to next nodes
			prev1 = curr1;
			curr1 = curr1.next;
			curr2 = curr2.next;
		}
		// Now one of the list might be bigger than the other
		// In case curr2 is not null
		// attach the rest of the list to l1 and let it process as l1
		if (curr2 != null) {
			prev1.next = curr2;
			curr1 = curr2;
		}
		// If curr1 is bigger, just add any leftover carry to curr1 and we are
		// done
		// Carry might overflow to next node too
		while (curr1 != null) {
			if (carry == 0)
				break;
			int sum = curr1.val + carry;
			curr1.val = sum % 10;
			carry = sum / 10;
			// Update the list pointers
			// Set the current as previous
			// Update the current to next nodes
			prev1 = curr1;
			curr1 = curr1.next;
		}
		// Carry might have still overflowed
		if (carry == 1) {
			// Create a new node
			// Set the value to 1
			// Attach to prev1 since curr1 should be null
			ListNode node = new ListNode(1);
			prev1.next = node;
		}
		return l1;

	}
}
