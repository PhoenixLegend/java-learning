package jdbc;

import charactor.Hero;
import org.junit.Test;


public class testDAO {
    @Test
    public  void testDAO() {
        HeroDAO h1 = new HeroDAO();
        Hero h2 = new Hero(1,"ran",100,20);
        h1.getTotal();
//        h1.add(h2);
//        System.out.println(h1.get(1));

    }
}
