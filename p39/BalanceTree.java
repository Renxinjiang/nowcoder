package offer.p39;

/**
 * @PackageName: offer.p39
 * @ClassName: BalanceTree
 * @Description:
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * @author: 呆呆
 * @date: 2019/11/5
 */
public class BalanceTree {
    /**
     * 平衡二叉搜索树又被称为AVL树（有别于AVL算法），
     * 且具有以下性质：
     * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
     * 并且左右两个子树都是一棵平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        if (!IsBalanced_Solution(root.left)){
            return false;
        }
        if (!IsBalanced_Solution(root.right)){
            return false;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if (diff >= -1 && diff <= 1){
            return true;
        }
        return false;
    }
    public int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
