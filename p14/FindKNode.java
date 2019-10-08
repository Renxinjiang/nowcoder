package offer.p14;

/**
 * @PackageName: offer.p14
 * @ClassName: FindKNode
 * @Description:
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author: 呆呆
 * @date: 2019/10/8
 */
public class FindKNode {
    /**
     * 思路：
     * 快指针先往前走k步，注意判断边界，然后快慢一起走，当快指针为null的时候，慢指针走到了倒数第k个节点
     */
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0;i < k;i++){
            if (fast == null){
                return null;
            }
            fast = fast.next;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
