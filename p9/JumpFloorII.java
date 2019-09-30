package offer.p9;

import java.util.Arrays;

/**
 * @PackageName: offer.p9
 * @ClassName: JumpFloorII
 * @Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author: 呆呆
 * @date: 2019/9/29
 */
public class JumpFloorII {
    /**
     * 易知 f(n)=f(n-1)+f(n-2)+……f(1)
     * f(n-1)=f(n-2)+……f(1)
     * 两式相减得f(n)=2f(n-1)
     */

    //递归
    public int jumpFloorII(int target) {
        if (target <= 2){
            return target;
        }
        return jumpFloorII(target -1) * 2;
    }

    //循环

    public int jumpFloorII2(int target) {
        if (target <= 2){
            return target;
        }
        int[] array = new int[target+1];
        array[0] = 0;
        Arrays.fill(array,1); //1是指不管几阶，青蛙都是一步跳到。
        for (int i = 2;i <= target;i++){
            for (int j = i-1;j >= 1;j--){
                array[i] += array[j];
            }
        }
        return array[target] ;
    }
}
