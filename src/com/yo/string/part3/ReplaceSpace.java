package com.yo.string.part3;

/**空格替换练习题：
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
   给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
   测试样例：
       "Mr John Smith”,13
   返回："Mr%20John%20Smith"
       ”Hello  World”,12
   返回：”Hello%20%20World”
   解题思路：
       ①先用一个计算出空格的数量，然后根据空格数量计算出完成替换后字符数组的长度newLen，
       最后从newLen-1开始，如果rLen-1位置的数不为空格，则将rLen-1位置的数赋值给newLen-1，
       然后newLen--，人rLen--;如果rLen-1位置的数为空格，则将0， 2， %分别赋值给newLen，newLen-1，newLen-2，然后newLen-=3，rLen--
       ②将字符串转换为字符数据，然后用一个数spaceCnt计算出空格的数量，接着使用spaceCnt计算出完成替换后字符数据的长度newLen
       最后，遍历原字符数组，遇到非空格，直接将当前字符赋值给新数据相应位置（index），然后index++；遇到
       空格，将%，2,0分别赋值给index，index+1，index+2，最后，index+=3即可
       ③使用StringBuilder构造新替换后的字符串，及遍历原字符串，遇到非空格符时直接append，遇到空格符时append("%20");
 * Created by Yo on 2017/3/4.
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "abc efg f  ";
        char[] charArr = {'a', 'b', 'c', ' ', 'e', 'f', 'g', ' ', 'f', ' ', ' ', ' ', ' '};
        System.out.println(replaceSpaceOnArray(charArr, 9));
    }

    /**
     * 时间复杂度O(n),空间复杂度O(1)
     * @param srcChar 字符数组
     * @param rLen 数组真实长度
     * @return
     */
    public static String replaceSpaceOnArray(char[] srcChar, int rLen) {
        if( srcChar==null || rLen<1) {
            return "";
        }
        int zeroCnt = 0;
        for(int i=0; i<rLen; i++) {
            if( srcChar[i] == ' ' ) {
                zeroCnt++;
            }
        }
        int index = rLen + zeroCnt*2 - 1;
        int i = rLen - 1;
        while( i >= 0 ) {
            if( srcChar[i] != ' ' ) {
                srcChar[index--] = srcChar[i];
            } else {
                srcChar[index] = '0';
                srcChar[index-1] = '2';
                srcChar[index-2] = '%';
                index -= 3;
            }
            i--;
        }
        return String.valueOf(srcChar);
    }
    public static String replaceSpaceUseArray(String iniString, int length) {
        if( iniString==null || "".equals(iniString) || length==0 ) {
            return "";
        }
        char[] chas = iniString.toCharArray();
        int spaceCnt = 0;
        for(char c : chas) {
            if( c == ' ' ) {
                spaceCnt++;
            }
        }
        char[] resChas = new char[length+spaceCnt*2];
        int index = 0;
        for(char c : chas) {
            if( c != ' ' ) {
                resChas[index++] = c;
            } else {
                resChas[index] = '%';
                resChas[index+1] = '2';
                resChas[index+2] = '0';
                index += 3;
            }
        }
        return String.valueOf(resChas);
    }
    public static String replaceSpaceUseStringBuilder(String initString, int n) {
        if( initString==null || n<1 ) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++) {
            char currChar = initString.charAt(i);
            if( currChar != ' ' ) {
                builder.append(currChar);
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }

}