package offer.p7;

/**
 * @PackageName: offer.p7
 * @ClassName: Fibonacci
 * @Description:
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * @author: 呆呆
 * @date: 2019/9/29
 */
public class Fibonacci {
    /**
     *思路:
     * 斐波那契数列：0\1、1、2、3、5、8、13、21、34、
     * F(0) = 0
     * F(1) = 1
     * F(2) = 1
     * F(n) = F(n-1)+F(n-2)
     */

    //递归
    public int fibonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    //非递归
    public int fibonacci2(int n) {
        int[] array = new int[40];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2;i < array.length;i++){
            array[i] = array[i-1] + array[i-2];
        }
        return array[n];
    }

    //优化存储，只保存最近的两个数
    public int fibonacci3(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1 || n == 2){
            return 1;
        }
        int sum = 0;
        int two = 0;
        int one = 1;
        for (int i = 2;i <= n;i++){
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}
