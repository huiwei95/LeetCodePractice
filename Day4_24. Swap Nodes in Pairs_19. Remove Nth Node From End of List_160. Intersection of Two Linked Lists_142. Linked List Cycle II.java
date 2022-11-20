/**
24. Swap Nodes in Pairs

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;   // Node 1
            ListNode temp1 = cur.next.next.next;    // Node 3
            cur.next = cur.next.next;   // dummy -> Node 2
            cur.next.next = temp;   // Node 2 -> Node 1
            cur.next.next.next = temp1;     // Node 1 -> Node 3
            cur = cur.next.next;    // cur dummy move to Node 2
        }
        return dummy.next;
    }
}





/**
19. Remove Nth Node From End of List

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        // fast ListNode goes n + 1 step;
        for (int i = 0; i < n + 1; i ++) {
            fast = fast.next;  
        }
        
        // slow and fast ListNode goes together
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}





/**
160. Intersection of Two Linked Lists
*
*
*/
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        
        while (p != q) {
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }
        return p; // return q also is ok.
    }
}





/**
142. Linked List Cycle II
*
*
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                ListNode index1 = fast;  // meetPoint
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1; // also can return index2
            }
        }
        return null;
    }
}