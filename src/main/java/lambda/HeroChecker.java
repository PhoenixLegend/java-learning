package lambda;

import charactor.Hero;

public interface HeroChecker {
    public boolean test(Hero h);
    //在匿名类当中会被直接override
}
