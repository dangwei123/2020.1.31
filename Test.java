/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null){
            return null;
        }
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val);
            node.next=cur.next;
            cur.next=node;
            cur=cur.next.next;
        }
        cur=head;
        while(cur!=null&&cur.next!=null){
            if(cur.random!=null){
                cur.next.random=cur.random.next;
            }
            cur=cur.next.next;
        }
        Node newHead=head.next;
        cur=head;
        while(cur.next!=null){
            Node curNext=cur.next;
            cur.next=cur.next.next;
            cur=curNext;
        }
        return newHead;
    }
}

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
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast!=slow){
            return null;
        }
        fast=dummy;
        while(fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
        return fast;
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
           fast=fast.next.next;
           slow=slow.next; 
        }
        ListNode cur=slow.next;
        slow.next=null;
        ListNode pre=null;
        ListNode newHead=null;
        while(cur!=null){
            ListNode curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=curNext;
        }
        cur=head;
        while(newHead!=null){
            ListNode newnext=newHead.next;
            newHead.next=cur.next;
            cur.next=newHead;
            if(cur.next!=null){
                cur=cur.next.next;
            } 
            newHead=newnext;
        }
        
    }
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(Integer.MIN_VALUE);
        ListNode cur1=head;
        while(cur1!=null){
            ListNode curNext=cur1.next;
            ListNode cur2=dummy;
            while(cur2!=null){
                if(cur2.next!=null&&cur2.next.val>cur1.val){
                cur1.next=cur2.next;
                cur2.next=cur1;
                break;
                }
                if(cur2.next==null){
                cur2.next=cur1;
                cur2=cur2.next;
                cur2.next=null;
                break;
                }
                cur2=cur2.next;
            }
            cur1=curNext;
        }
        return dummy.next;
    }
}