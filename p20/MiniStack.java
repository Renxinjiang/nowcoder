package offer.p20;

import java.util.Stack;

/**
 * @PackageName: offer.p20
 * @ClassName: MiniStack
 * @Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * @author: 呆呆
 * @date: 2019/10/30
 */
public class MiniStack {
    /**
     * 思路：
     * 用两个栈实现MiniStack
     *
     */
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> miniStack = new Stack<>();
    int curMin = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(curMin > node){
            curMin = node;
        }
        miniStack.push(curMin);
    }

    public void pop() {
        stack.pop();
        miniStack.pop();
        curMin = miniStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return curMin;
    }
}
