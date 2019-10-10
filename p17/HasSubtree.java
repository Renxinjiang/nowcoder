package offer.p17;

/**
 * @PackageName: offer.p17
 * @ClassName: HasSubtree
 * @Description:
 * 输入两棵二叉树A，B，判断B是不是A的子结构。                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             （ps：我们约定空树不是任意一个树的子结构）
 * @author: 呆呆
 * @date: 2019/10/10
 */
public class HasSubtree {
    /**
     * 思路：
     * 递归的写法
     */
    public boolean hasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return judgeSubtree(root1,root2) || judgeSubtree(root1.left,root2) || judgeSubtree(root1.right,root2);
    }

    private boolean judgeSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null ){
            return true;
        }
        if (root1 == null ){
            return false;
        }
        if (root1.val == root2.val) {
            return judgeSubtree(root1.left, root2.left) && judgeSubtree(root1.right, root2.right);
        }else {
            return judgeSubtree(root1.right,root2)||judgeSubtree(root1.right,root2);
        }
    }
}
