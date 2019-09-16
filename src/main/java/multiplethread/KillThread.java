package multiplethread;

import charactor.Hero;
//或者KillThread implements Runnable
//new Thread(KillThread).start();

public class KillThread extends Thread {
    private Hero h1;
    private Hero h2;

    public KillThread(Hero h1, Hero h2){
        this.h1 = h1;
        this.h2 = h2;
    }

    public void run(){
        while(!h2.isDead()){
            h1.attackHero(h2);
        }
    }

}
