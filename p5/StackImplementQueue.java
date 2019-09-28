package offer.p5;

import java.util.Stack;

/**
 * @PackageName: offer.p5
 * @ClassName: StackImplementQueue
 * @Description:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型。
 * @author: 呆呆
 * @date: 2019/9/28
 */
public class StackImplementQueue {
    /**
     * 1. 两个栈实现
     * 2. 一个栈用来入队，定义1为入队的栈
     * 3. 一个栈用来出队，定义2为出队的栈
     */
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() == 0 && stack1.size() == 0){
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
