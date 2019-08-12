package collection;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TestCollection {
    @Test
    public void TestCollection() {
        HashSet<Integer> numbers = new HashSet<>();

        numbers.add(9);
        numbers.add(5);
        numbers.add(1);

        // Set中的元素排列，不是按照插入顺序//通过hash排列
//        System.out.println(numbers);
//        for (Integer i : numbers) {
//            System.out.print(i);
//
//        }
//        Iterator<Integer> i = numbers.iterator();
//        while(i.hasNext()){
//            System.out.println(i.next());
//
//        }
        hashSetPractice();

    }
    public static void hashSetPractice() {
        // HashSet 元素不能重复 没有顺序 没有get方法获取指定位置的元素 遍历只能用迭代器或foreach
        HashSet<Integer> rand = new HashSet<>();
        boolean flag = false;//会用到的

        for (int i = 0; i < 10; i++) {

            int randint = (int)Math.floor(Math.random() * Math.floor(10));
            flag = rand.add(randint);
            if (!flag)
                System.out.println(randint);
        }
    }
}