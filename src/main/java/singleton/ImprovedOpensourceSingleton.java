/**
 * ImprovedOpensourceSingleton.java
 *
 *  Implements a basic Singleton. Double-checked locking for thread safety.
 *
 * @author Bryant Son
 * @since 06/26/2019
 */

package singleton;

public class ImprovedOpensourceSingleton {

    private volatile static ImprovedOpensourceSingleton uniqueInstance;

    private ImprovedOpensourceSingleton() {}

    public static ImprovedOpensourceSingleton getInstance() {
        if (uniqueInstance == null) {
            // 加了一个synchronized占有object，保持一致性
            synchronized (ImprovedOpensourceSingleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new ImprovedOpensourceSingleton();
                }
            }
        }
        return uniqueInstance;
    }

}
