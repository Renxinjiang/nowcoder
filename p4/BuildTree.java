package offer.p4;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @PackageName: offer.p4
 * @ClassName: BuildTree
 * @Description: 构建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author: 呆呆
 * @date: 2019/9/29
 */
public class BuildTree {
    /**
     * 思路：
     * 1.找到前序第一个结点为根结点
     * 2.找到中序里对应前序根结点的下标leftCount，该下标值是左子树结点个数
     * 3.前序中左子树为[1，leftCount+1)
         中序中左子树为[0，leftCount)
     * 4.前序中右子树为[leftCount+1,前序.length)
         中序中右子树为[leftCount+1,中序.length)
     * 5.用数组拷贝将前序中序左右子树拷贝到新数组
     * 6.递归左子树构造二叉树
     * 7.递归右子树构造二叉树
     */

    // 注意copyOfRange 函数，左闭右开
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0){
            return null;
        }
        int leftCount = 0;
        int rootVal = pre[0];
        while (in[leftCount] != rootVal && leftCount < in.length){
            leftCount++;
        }
        TreeNode root = new TreeNode(rootVal);
        int[] leftPre = Arrays.copyOfRange(pre,1,leftCount+1);
        int[] rightPre = Arrays.copyOfRange(pre,leftCount+1,pre.length);
        int[] leftIn = Arrays.copyOfRange(in,0,leftCount);
        int[] rightIn = Arrays.copyOfRange(in,leftCount+1,in.length);

        root.left = reConstructBinaryTree(leftPre,leftIn);
        root.right = reConstructBinaryTree(rightPre,rightIn);

        return root;
    }
}
