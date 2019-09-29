package offer.p6;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @PackageName: offer.p6
 * @ClassName: MinNumberInRotateArray
 * @Description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个升序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * @author: 呆呆
 * @date: 2019/9/29
 */
public class MinNumberInRotateArray {
    /**
     *思路：
     * 方法一：利用Arrays.sort排序，第一个就是最小（这是一个投机取巧的方法）
     *
     * 方法二：
     * 可以发现旋转后的数组前半部分{3,4,5}和后半部分{1,2}都是升序的
     * 要找到最小的值，只要找到第一个降序的数即可
     *
     * 方法三：
     * 将元素依次放入优先队列
     * 出第一个数即最小数
     *
     * 方法四：
     * 二分查找变种。
     * 没有具体的值用来比较，那么用中间值和高低位进行比较，
     * 看处于递增还是递减序列，进行操作缩小范围。
     * 处于递增：low上移  处于递减：high下移
     * （如果是high-1，则可能会错过最小值，因为找的就是最小值）  其余情况：low++缩小范围
     * 需要考虑特殊情况:子数组都是非递减的
     * 例如：[1,0,1,1],当low<high时，return array[low];
     */

    public int minNumberInRotateArray1(int [] array) {
        if (array.length == 0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    public int minNumberInRotateArray2(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int i;
        for (i = 0;i < array.length;i++){
            if (array[i + 1] < array[i]){
                break;
            }
        }
        return array[i + 1];
    }

    public int minNumberInRotateArray3(int [] array) {
        if (array.length == 0){
            return 0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0;i < array.length;i++){
            priorityQueue.add(array[i]);
        }
        return priorityQueue.poll();
    }

    public int minNumberInRotateArray4(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int low = 0;
        int high = array.length -1;
        int mid = 0;
        while (low < high){
            mid = (low+high)/2;
            if (array[low] < array[high]){
                return array[low];
            }
            if (array[low] < array[mid]){
                low = mid +1;
            }else if (array[high] > array[mid]){
                high = mid;
            }else{
                low++;
            }
        }
        return array[low];
    }
}
