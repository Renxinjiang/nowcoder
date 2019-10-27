package offer.p18;

/**
 * @PackageName: offer.p18
 * @ClassName: Mirro
 * @Description:
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * @author: 呆呆
 * @date: 2019/10/27
 */
public class Mirro {
    //交换左右子树的节点，然后递归调用该方法
    public void mirror(TreeNode root) {
        if (root == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
    }
}


