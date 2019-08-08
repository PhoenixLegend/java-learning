package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import charactor.Hero;;

public class FindHero {

    public static void main(String[] args) {
        List<Hero> heros = new ArrayList<Hero>();
        Random random = new Random();
        int heroSize = 3000000;
        for (int i = 0; i < heroSize; i++) {
            heros.add(new Hero("hero-" + random.nextInt(10000)));
        }
        HashMap<String, List<Hero>> heroMap = new HashMap<String, List<Hero>>();
        for (Hero hero : heros) {
            List<Hero> list = heroMap.get(hero.name); // 获取给定键的值
            if (list == null) {
                list = new ArrayList<Hero>();
                heroMap.put(hero.name, list);
            }
            list.add(hero);
        }
        FindHero testFindHero = new FindHero();
        testFindHero.testFor(heros);
        testFindHero.testHashMap(heroMap);
    }

    public void testFor(List<Hero> heros) {
        long startTime = System.currentTimeMillis();
        List<Hero> result = new ArrayList<Hero>();
        for (Hero hero : heros) {
            if (hero.name.equals("hero-5555")) {
                System.out.println(hero);
                result.add(hero);
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("no hashmap find method: " + result.size() + (endTime - startTime));
    }

    public void testHashMap(HashMap<String, List<Hero>> m) {
        long startTime = System.currentTimeMillis();
        List<Hero> result = m.get("hero-5555");
        Long endTime = System.currentTimeMillis();
        System.out.println("hashmap find method: " + result.size() + (endTime - startTime));
    }
}
