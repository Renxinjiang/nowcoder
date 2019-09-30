package offer.p8;

/**
 * @PackageName: offer.p8
 * @ClassName: JumpFloor
 * @Description:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * @author: 呆呆
 * @date: 2019/9/29
 */
public class JumpFloor {
    /**
     * 跳n阶台阶跳发相当于跳（n-2）跳法+（n-1）跳法
     * 因为n级台阶就相当于n-1级再跳一次一阶的和n-2级再跳一次2阶的
     */
    //递归
    public int jumpFloor(int target) {
        if (target == 0 || target == 1){
            return 1;
        }else{
            return jumpFloor(target - 2) + jumpFloor(target -1);
        }
    }

    //非递归
    public int jumpFloor2(int target) {
        if (target <= 2){
            return target;
        }
        int two = 1;
        int one = 2;
        int sum = 0;
        for (int i = 3;i <= target;i++){
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}
