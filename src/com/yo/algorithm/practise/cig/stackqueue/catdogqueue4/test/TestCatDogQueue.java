package com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.test;

import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Cat;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.structure.CatDogQueueAnother;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Dog;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.entity.Pet;
import com.yo.algorithm.practise.cig.stackqueue.catdogqueue4.impl.structure.CatDogQueueStandard;

/**
 * 测试 -- 猫狗队列
 */
public class TestCatDogQueue {

    /**
    <pre>
        测试结果
             实现类型：CatDogQueueAnother
                 init catDogQueue complete
                 pollDog : [dog@1163157884, dog@1956725890, dog@356573597, dog@1735600054]
                 pollCat : [cat@21685669, cat@2133927002, cat@1836019240, cat@325040804]
                 isEmpty : true
                 totalSize : 0
                 isDogEmpty : true
                 dogSize : 0
                 isCatEmpty : true
                 catSize : 0
                 init catDogQueue complete
                 pollCat : [cat@1173230247, cat@856419764, cat@621009875, cat@1265094477]
                 isEmpty : false
                 totalSize : 4
                 isDogEmpty : false
                 dogSize : 4
                 isCatEmpty : true
                 catSize : 0
                 pollAll : [dog@2125039532, dog@312714112, dog@692404036, dog@1554874502]
                 init catDogQueue complete
                 pollAll : [cat@1846274136, dog@1639705018, dog@1627674070, cat@1360875712, dog@1625635731, cat@1580066828, cat@491044090, dog@644117698]
             实现类型：CatDogQueueStandard
                 init catDogQueue complete
                 pollDog : dog@1163157884
                 pollCat : cat@1956725890
                 isEmpty : false
                 totalSize : 6
                 isDogEmpty : false
                 dogSize : 3
                 isCatEmpty : false
                 catSize : 3
                 init catDogQueue complete
                 pollCat : cat@356573597
                 isEmpty : false
                 totalSize : 13
                 isDogEmpty : false
                 dogSize : 7
                 isCatEmpty : false
                 catSize : 6
                 pollAll : dog@1735600054
                 init catDogQueue complete
                 pollAll : dog@21685669
        总结：
            实现原理：1、包装Pet类，并提供一个计数器/时间戳属性来保存当前元素入队顺序；2、猫和狗元素各维护一个队列（容器元素类型为包装类）；
                    3、用一个计数器/时间戳保存元素的入队顺序；4、添加元素时判断当前元素属于哪种类型，将对应元素用包装类包装起来且保存入队顺序然后入到对应队列（猫队列或狗队列），并递增当前入队计数器/时间戳的值
                    5、pollAll时对比当前猫队列和狗队列队头元素的入队顺序(计数器/时间戳），如果猫元素入队顺序比狗元素的小，则猫队列出队，否则狗队列出队（注意判断两个队列为空的情况，4种：全不为空，猫队列不为空，狗队列不为空，全为空）
                    6、pollCat和pollDog各自出队即可
    </pre>
     * @param args
     */
    public static void main(String[] args) {
//        CatDogQueueAnother catDogQueue = new CatDogQueueAnother();
        CatDogQueueStandard catDogQueue = new CatDogQueueStandard();
        System.out.println("实现类型：" + catDogQueue.getClass().getSimpleName());
        initCatDogQueue(catDogQueue);
        System.out.println("    pollDog : " + catDogQueue.pollDog());
        System.out.println("    pollCat : " + catDogQueue.pollCat());
        System.out.println("    isEmpty : " + catDogQueue.isEmpty());
        System.out.println("    totalSize : " + catDogQueue.totalSize());
        System.out.println("    isDogEmpty : " + catDogQueue.isDogEmpty());
        System.out.println("    dogSize : " + catDogQueue.dogSize());
        System.out.println("    isCatEmpty : " + catDogQueue.isCatEmpty());
        System.out.println("    catSize : " + catDogQueue.catSize());
        initCatDogQueue(catDogQueue);
        System.out.println("    pollCat : " + catDogQueue.pollCat());
        System.out.println("    isEmpty : " + catDogQueue.isEmpty());
        System.out.println("    totalSize : " + catDogQueue.totalSize());
        System.out.println("    isDogEmpty : " + catDogQueue.isDogEmpty());
        System.out.println("    dogSize : " + catDogQueue.dogSize());
        System.out.println("    isCatEmpty : " + catDogQueue.isCatEmpty());
        System.out.println("    catSize : " + catDogQueue.catSize());
        System.out.println("    pollAll : " + catDogQueue.pollAll());
        initCatDogQueue(catDogQueue);
        System.out.println("    pollAll : " + catDogQueue.pollAll());
    }

    public static void initCatDogQueue(CatDogQueueAnother catDogQueue) {
        Pet[] petArr = {new Cat(), new Dog(), new Dog(), new Cat(), new Dog(), new Cat(), new Cat(), new Dog()};
        for (Pet pet : petArr) {
            catDogQueue.add(pet);
        }
        System.out.println("    init catDogQueue complete");
    }
    public static void initCatDogQueue(CatDogQueueStandard catDogQueue) {
        Pet[] petArr = {new Cat(), new Dog(), new Dog(), new Cat(), new Dog(), new Cat(), new Cat(), new Dog()};
        for (Pet pet : petArr) {
            catDogQueue.add(pet);
        }
        System.out.println("    init catDogQueue complete");
    }
}
