package offer.p1;

import java.util.Arrays;

/**
 * @PackageName: offer.p1
 * @ClassName: FindWithArray
 * @Description: 一个二维数组中（每个一维数组的长度相同），
 *  * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 *  * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author: 呆呆
 * @date: 2019/9/26
 */
public class FindWithArray {
    //方法1
    //满足这种数组的从第一个元素到最后一个元素都是递增，即整个数组有序
    //因为是二位数组，所以查找为双重循环

    public boolean Find(int target, int [][] array) {
        for (int i = 0;i < array.length;i++){
            for (int j = 0;j < array[i].length;j++){
                if (array[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
    //方法2
    //满足这种数组的从任意一个元素出发，向右向下递增，向左向上递减
    //若选左下角的元素作为第一次比较的值，大于它向右，小于向上，一直找
    //len向上走，一直减，要大于0；i向右走，一直加，要小于这一行的列数 array[i].length

    public boolean Find2(int target, int [][] array) {
        int i = 0;
        int len = array.length - 1;
        while ((len >= 0) && (i < array[0].length)){
            if (array[len][i] == target){
                return true;
            }else if (array[len][i] > target){
                len--;
            }else if (array[len][i] < target){
                i++;
            }
        }
        return false;
    }
}
