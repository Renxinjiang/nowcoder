package offer.p10;

/**
 * @PackageName: offer.p10
 * @ClassName: RectCover
 * @Description:
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author: 呆呆
 * @date: 2019/10/1
 */
public class RectCover {
    /**
     * 思路：
     * 递归的思路，
     *
     * n = 1 的时候 只能横着覆盖，一种
     * n = 2 的时候 可以横着和竖着覆盖，两种
     * n = 3 的时候 第三级横着覆盖，用了一级，
     * 剩下 n = 2，有两种覆盖方法 第三季竖着覆盖，用了两级，剩下 n = 1，有一种覆盖方法 总共有 3 种
     * n = 4 的时候 第 4 级横着覆盖，用了一级，
     * 剩下 n = 3，有三种覆盖方法 第 4 级竖着覆盖，用了两级，
     * 剩下 n = 2，有两种覆盖方法 总共有 5 种方法
     * n = n 的时候 第 n 级横着覆盖，用了一级，
     * 剩下 n = n - 1，所以关注第 n - 1 种有几种覆盖方法 第 n 级竖着覆盖，用了两级，
     * 剩下 n = n - 2，所以关注第 n - 2 种有几种覆盖方法
     *
     * 涂掉最后一级矩形的时候，是用什么方式完成的？
     * 涂掉最后一级矩阵的时候，可以选择使用横向完成，也可以使用竖向完成，
     * 横向涂剩下 n - 1 阶，竖向涂剩下 n - 2 阶
     */

    //递归的思路
    public int rectCover(int target) {
        if (target <= 2){
            return target;
        }
        return rectCover(target-1)+rectCover(target-2);
    }

    //迭代的思路
    public int rectCover2(int target) {
        if (target <= 2) {
            return target;
        }
        int two = 1;
        int one = 2;
        int sum = 0;
        for (int i = 3;i <= target;i++){
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}
