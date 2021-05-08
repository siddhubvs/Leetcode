class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
  ListNode a, b;
	ListNode c = new ListNode(0);
	c.next = head;
	b = c;
	a = head;
	for (int i = 0; i < n; i++) {
		a = a.next;
	}
	while (a != null) {
		a = a.next;
		b = b.next;
	}
	b.next = b.next.next;
	return c.next;
    }
}
