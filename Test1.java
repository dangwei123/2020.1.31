/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode before=head;
        ListNode afterHead=head.next;
        ListNode after=head.next;
        while(before.next!=null&&after.next!=null){
            before.next=after.next;
            if(before!=null){
                before=before.next;
            }           
            after.next=before.next;
            if(after!=null){
                after=after.next;
            }          
        }
        if(after!=null){
            after.next=null;
        } 
        if(before!=null){
             before.next=afterHead;
        }     
        return head;
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1=reverse(l1);
        ListNode head2=reverse(l2);
        int carry=0;
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        while(head1!=null||head2!=null||carry!=0){
            int a=head1==null?0:head1.val;
            int b=head2==null?0:head2.val;
            int sum=a+b+carry;
            ListNode node=new ListNode(sum%10);
            cur.next=node;
            cur=cur.next;
            carry=sum/10;
            head1=head1==null?null:head1.next;
            head2=head2==null?null:head2.next;
        }
        ListNode newHead=dummy.next;
        return reverse(newHead);
    }
    private ListNode reverse(ListNode head){
        ListNode cur=head;
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
        return newHead;
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null){
            return null;
        }
        int len=getLen(head);
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=pre.next;
        for(int i=0;i<len/k;i++){
            for(int j=0;j<k-1;j++){
                ListNode curNext=cur.next;
                cur.next=cur.next.next;
                curNext.next=pre.next;
                pre.next=curNext;
            }
            pre=cur;
            cur=pre.next;
        }
        return dummy.next;
    }
    private int getLen(ListNode head){
        ListNode cur=head;
        int len=0;
        while(cur!=null){
            len++;
            cur=cur.next;
        }
        return len;
    }
}