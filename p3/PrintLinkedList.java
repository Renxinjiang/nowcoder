package offer.p3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @PackageName: offer.p3
 * @ClassName: FrontPrintLinkedList
 * @Description: 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 相当于链表逆置
 * @author: 呆呆
 * @date: 2019/9/27
 */
public class PrintLinkedList {
    //方法一：迭代的方法

    //初始化三个结点prev为null，cur为head，next为null。
    //prev记录当前节点的前驱，方便cur.next = cur;next用来保存cur的后继，防止找不到后续链表

    // 在循环中，执行以下操作。
    // 在更改当前节点的下一个节点之前，
    // 存储下一个节点next = cur.next
    // 现在改变当前节点的下一节点
    // 这是实际逆转发生的地方cur.next = prev
    // 将prev和curr向前移动一步prev = cur ,curr = next

    // 总结为：先存储当前节点的下一节点，再反转当前节点的pnext指针，最后重置head头部。
    // 注意：若head指向Null而不放数据，则prev、curr、next应相应改变
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ListNode prev = null;
        ListNode cur = listNode;
        ListNode next = null;
        int size = 0;
        while (cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            size++;
        }
        for (int i = 0;i < size;i++){
            arrayList.add(prev.val);
            prev = prev.next;
        }
        return arrayList;
    }

    //方法二：
    //定义一个栈，利用栈先入后出的原理，将链表中的元素压入栈，再将栈内元素出到数组中
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }
        return arrayList;
    }
}
