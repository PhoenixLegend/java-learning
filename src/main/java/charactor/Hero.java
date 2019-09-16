package charactor;

public class Hero implements Comparable<Hero>{

    public String name;
    public int length;
    public float hp;
    public int damage;
    public int id;
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }



    //静态初始化块里进行初始化
//    static String copyright;
//    static {
//        System.out.println("初始化 copyright");
//        copyright = "版权由Riot Games公司所有";
//    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public boolean isDead (){
        return 0>=hp? true:false;
    }

    public void attackHero(Hero h) {
        try {
            //为了表示攻击需要时间，每次攻击暂停1000毫秒
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }//使用优先级时，需要取消sleep才能竞争
        h.hp-=damage;
        System.out.format("%s 正在攻击 %s, %s的血变成了 %.0f%n",name,h.name,h.name,h.hp);

        if(h.isDead())
            System.out.println(h.name +"死了！");
    }

    public Hero(){

    }

    public Hero(String name) {
        this.name =name;

    }
    public Hero(String name,float hp, int damage) {

        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }

    //初始化name,hp,damage的构造方法
    public Hero(int id,String name,float hp, int damage) {
        this.id = id;
        this.name =name;
        this.hp = hp;
        this.damage = damage;
    }

    @Override
    public int compareTo(Hero anotherHero) {
        if(damage<anotherHero.damage)
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return "Hero [name=" + name + ", hp=" + hp + ", damage=" + damage + "]\r\n";
    }

}
