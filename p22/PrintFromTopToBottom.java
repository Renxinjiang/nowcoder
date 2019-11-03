package offer.p22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @PackageName: offer.p22
 * @ClassName: PrintFromTopToBottom
 * @Description:
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 即层序遍历二叉树。
 * @author: 呆呆
 * @date: 2019/11/1
 */
public class PrintFromTopToBottom {
    //1.根入队
    //2.持续下列操作直到队空
    //  2.1出队首结点
    //  2.2带所出结点的孩子入队
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null){
            return list;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return list;
    }
}
