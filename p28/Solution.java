package offer.p28;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @PackageName: offer.p28
 * @ClassName: Solution
 * @Description:
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * @author: 呆呆
 * @date: 2020/3/16
 */
public class Solution {
    /**
     * 思路：
     * 方法一：排序后，中间的元素是否满足出现的次数超过数组长度的一半
     *
     * 方法二：用hashMap
     *         key为数字，value为出现次数，存储完成后遍历map，看有无符合条件的数。
     *
     * 方法三：打擂台
     *         第一个数字作为士兵，count=1，
     *         遇到一个相等的数字即友军则count++，遇到不同的数字即敌军则count--，
     *         当count==0的时候，选用下一个数字作为友军count=1。
     *         直到最后若count >1，那么只有这个数字才有可能是超过一半的数字，
     *         因为若一个数字他超过数组一半，那么它必定能活到最后。
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        Arrays.sort(array);
        int i = array[array.length/2];
        int count = 0;
        for (int j = 0;j < array.length;j++){
            if (array[j] == i) count++;
        }
        if (count > array.length/2) return i;
        else return 0;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if (array.length == 0) return 0;
        int length = array.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < length;i++){
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                map.put(array[i],map.get(array[i])+1);
            }
        }
        for (Integer key : map.keySet()){
            if (map.get(key) > length/2){
                return key;
            }
        }
        return 0;
    }

    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) return 0;
        int length = array.length;
        int res = array[0];
        int count = 1;
        for (int i = 1;i < length;i++){
            if (count == 0){
                res = array[i];
                count = 1;
            }else {
                if (array[i] == res){
                    count++;
                }else {
                    count--;
                }
            }
        }
        // 判断当前的res是不是满足条件（因为此时res有两种结果：一种我们要找的，另一种不满足条件它是最后一个数）
        int t = 0;
        for (int i = 0;i < length;i++){
            if (array[i] == res){
                t++;
            }
        }
        if (t > length/2){
            return res;
        }
        return 0;
    }
}
