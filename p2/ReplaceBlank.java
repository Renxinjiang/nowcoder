package offer.p2;

/**
 * @PackageName: offer.p2
 * @ClassName: ReplaceBlank
 * @Description: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author: 呆呆
 * @date: 2019/10/28
 */
public class ReplaceBlank {
    // 方法一：
    // 直接调用自带函数
    public String replaceSpace1(StringBuffer str) {
        return str.toString().replaceAll(" ","%20");
    }

    // 方法二：
    // 不开辟新数组，在原字符串上直接修改
    //  1.先计算替换后的字符串需要多大的空间，并对原字符串空间进行扩容；
    //  2.从后往前替换字符串的话，每个字符串只需要移动一次；
    //  3.如果从前往后，每个字符串需要多次移动，效率较低。
    public String replaceSpace2(StringBuffer str) {
        int spacenum = 0;
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                spacenum++;
            }
        }
        int oldLength = str.length();
        int oldIndex = oldLength - 1;
        int newLength = oldLength + spacenum*2;
        int newIndex = newLength - 1;
        str.setLength(newLength);
        for (;oldIndex >= 0;oldIndex--){
            if (str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else {
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    // 方法三
    //  开辟新数组
    //  遇到空格追加%20
    //  否则遇到什么加什么
    public String replaceSpace3(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
