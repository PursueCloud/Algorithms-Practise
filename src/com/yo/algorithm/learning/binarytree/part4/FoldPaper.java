package com.yo.algorithm.learning.binarytree.part4;

import java.util.ArrayList;
import java.util.List;

/**折纸练习题：
   请把纸条竖着放在桌⼦上，然后从纸条的下边向上⽅对折，压出折痕后再展 开。此时有1条折痕，突起的⽅向指向纸条的背⾯，这条折痕叫做“下”折痕 ；突起的⽅向指向纸条正⾯的折痕叫做“上”折痕。如果每次都从下边向上⽅ 对折，对折N次。请从上到下计算出所有折痕的⽅向。
   给定折的次数n,请返回从上到下的折痕的数组，若为下折痕则对应元素为"down",若为上折痕则为"up".
   测试样例：
       1
   返回：["down"]
 * Created by Yo on 2017/3/9.
 */
public class FoldPaper {
    public static String[] foldPaper(int n) {
        int nodeCount = (1<<n) - 1;
        ArrayList<String> res = new ArrayList<String>();
        foldHelper(1, n, true, res);
        String[] result = (String[])res.toArray(new String[nodeCount]);
        return result;
    }
    private static void foldHelper(int i,int n,boolean isDown,List res){
        if( i > n ) {
            return;
        }
        foldHelper(i+1, n, true, res);
        res.add(isDown ? "down" : "up");
        foldHelper(i+1, n, false, res);
    }

    public static String[] foldPaperTest(int n) {
        if( n <= 0 ) {
            return null;
        }
        int nodeCnt = (1<<n) - 1;
        List<String> resList = new ArrayList<String>();
        foldHelperTest(1, n, true, resList);
        String[] resArr = (String[])resList.toArray(new String[nodeCnt]);
        return resArr;
    }
    private static void foldHelperTest(int i, int n, boolean isDown, List<String> resList){
        if( i > n ) {
            return;
        }
        foldHelperTest(i+1, n, true, resList);
        resList.add(isDown ? "down" : "up");
        foldHelperTest(i+1, n, false, resList);
    }
}
