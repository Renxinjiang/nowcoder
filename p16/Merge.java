package offer.p16;

/**
 * @PackageName: offer.p16
 * @ClassName: Merge
 * @Description:
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author: 呆呆
 * @date: 2019/10/28
 */
public class Merge {
    /**
     * 思路：
     * 方法一：
     * 定义一个cur1，一个cur2，用来分别遍历两个链表
     * 依次比较两个链表的结点值
     * 插入新的链表中
     *
     * 方法二：
     * 定义一个cur1，一个cur2，用来分别遍历两个链表
     * 将list2往list1中插
     *      1.比较cur1和cur2值大小
     *      2.若cur2小于cur1，则插到cur1前面，并让cur2指向下一个元素
     *      否则，cur1指向下一个元素
     *      3.循环直到cur1或者cur2为空
     *      4.判断是哪个链表空了，如果是list2则说明list2已全部插入直接返回头结点即可。
     *      如果是list1，则将剩下的list2结点直接连到list1尾部，返回头结点即可。
     */
    public ListNode merge1(ListNode list1,ListNode list2) {
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode cur1 = list1;
        ListNode cur2 = list2;
        ListNode cur = head;
        while (cur1 != null && cur2 != null){
            if (cur1.val < cur2.val){
                cur.next = cur1;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur2 = cur2.next;
            }
            cur = cur.next;
        }
        while (cur1 != null){
            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }
        while (cur2 != null){
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;
        }
        return head.next;
    }

    public ListNode merge2(ListNode list1,ListNode list2) {
        if(list1 == null ){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1 == null && list2 == null){
            return null;
        }
        ListNode prev1 = new ListNode(-1);
        ListNode cur2 = null;
        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
        }else{
            head = list2;
        }
        while (list1 != null && list2 != null){
            if (list2.val <= list1.val){
                cur2 = list2.next;
                list2.next = list1;
                prev1.next = list2;  //让list1的前一个结点指向list2
                prev1 = list2;       //此时list1的前一个结点变成list，更新pre1
                list2 = cur2;
            }else{
                prev1 = list1;
                list1 = list1.next;
            }
        }
        if (list2 != null){
            prev1.next = list2;
        }
        return head;
    }
}
