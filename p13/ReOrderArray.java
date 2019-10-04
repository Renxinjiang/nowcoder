package offer.p13;

/**
 * @PackageName: offer.p13
 * @ClassName: ReOrderArray
 * @Description:
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @author: 呆呆
 * @date: 2019/10/3
 */
public class ReOrderArray {
    /**
     * 思路：
     * i++往前走碰到偶数停下来，j = i+1
     * 若 a[j]为偶数，j++前进，
     * 直到碰到奇数 a[j]对应的奇数插到a[i]位置，j经过的j-i个偶数依次后移
     * 如果j==len-1时还没碰到奇数，证明i和j之间都为偶数了，完成整个移动
     */
    public void reOrderArray(int [] array) {
        if(array.length ==0){
            return ;
        }
        int m = 0;
        for(int i=0;i<array.length;i++){
            if((Math.abs(array[i]))%2!=0){
                int tmp = array[i];
                int j=i;
                while(j>m){
                    array[j] = array[j-1];
                    j--;
                }
                m=j+1;
                array[j] = tmp;
            }
        }
    }
}
