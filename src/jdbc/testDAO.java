package jdbc;

import charactor.Hero;

public class testDAO {
    public static void main(String[] args) {
        HeroDAO h1 = new HeroDAO();
        Hero h2 = new Hero(1,"ran",100,20);

        h1.add(h2);
        System.out.println(h1.get(1));
    }
}
