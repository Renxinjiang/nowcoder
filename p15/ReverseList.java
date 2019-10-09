package offer.p15;

/**
 * @PackageName: offer.p15
 * @ClassName: ReverseList
 * @Description:
 * 输入一个链表，反转链表后，输出新链表的表头。
 * @author: 呆呆
 * @date: 2019/10/8
 */
public class ReverseList {
    /**
     * 思路：
     * 初始化三个结点prev为null，cur为head，next为null。
     * prev记录当前节点的前驱，方便cur.next = prev;next用来保存cur的后继，防止找不到后续链表
     *
     * 在循环中，执行以下操作。
     * // 在更改当前节点的下一个节点之前，
     * // 存储下一个节点next = cur.next
     * // 现在改变当前节点的下一节点
     * // 这是实际逆转发生的地方cur.next = prev
     * // 将prev和curr向前移动一步prev = cur ,curr = next
     *
     * 总结为：先存储当前节点的下一节点，再反转当前节点的pnext指针，最后重置head头部。
     * 注意：若head指向Null而不放数据，则prev、curr、next应相应改变
     */
    public ListNode ReverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
