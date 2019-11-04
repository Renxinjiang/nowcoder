package offer.p38;

/**
 * @PackageName: offer.p38
 * @ClassName: TreeDepth
 * @Description:
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * @author: 呆呆
 * @date: 2019/11/4
 */
public class TreeDepth {
    public int treeDepth(TreeNode root) {
        //求二叉树的高
            if (root == null){
                return 0;
            }
            int left = treeDepth(root.left);
            int right = treeDepth(root.right);
            return Math.max(left,right) + 1;
    }
}
