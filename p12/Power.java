package offer.p12;

/**
 * @PackageName: offer.p12
 * @ClassName: Power
 * @Description:
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * @author: 呆呆
 * @date: 2019/10/3
 */
public class Power {
    /**
     * 思路：
     * 方法一：
     * 用for循环实现
     * 当exponent > 0 时，返回base*base*...
     * 当exponent < 0 时，返回1/(base*base*...)
     *
     * 方法二：
     * 递归的写法
     */
    public double power(double base, int exponent) {
        if (base == 0.0){
            return 0.0;
        }
        double result = 1.0;
        int e = exponent;
        if (exponent < 0){
            e = -exponent;
        }
        for (int i = 1;i < e;i++){
            result *= base;
        }
        if (exponent < 0){
            return 1/result;
        }
        return result;
    }

    //递归
    public double power2(double base, int exponent) {
        int e = exponent;
        if (exponent < 0){
            e = -exponent;
        }
        double result = getPower(base,e);
        return exponent > 0 ? result : 1/result;
    }

    private double getPower(double base, int e) {
        if (e == 0){
            return 1.0;
        }
        if (e == 1){
            return base;
        }
        double ans = getPower(base,--e);
        ans *= base;
        return ans;
    }
}
