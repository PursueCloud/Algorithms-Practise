package com.yo.string.part2;

/**两串旋转练习题：
   如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。
   给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
   测试样例：
      "cdab",4,"abcd",4
      返回：true
   解题思路：
        判断A+A字符串中是否含有B即可
 * Created by Yo on 2017/3/4.
 */
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        if( A==null || lena<1 || B==null || lenb<1 ) {
            return false;
        }
        StringBuilder builder = new StringBuilder().append(A).append(A);
        if( builder.indexOf(B) != -1 ) {
            return true;
        } else {
            return false;
        }
    }

}
