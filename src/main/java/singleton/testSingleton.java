package singleton;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertTrue;

public class testSingleton {
    @Test
    public void testSingleton_ReturnsSameInstance() {
        System.out.println("\n==== Running Singleton Pattern Test Case: ==== \n");

        OpensourceSingleton firstObject = OpensourceSingleton.getInstance();
        OpensourceSingleton secondObject = OpensourceSingleton.getInstance();

        assertTrue(firstObject.equals(secondObject));
    }

    @Test
    public void testImprovedSingleton_ReturnsSameInstance() {
        System.out.println("\n==== Running Improved Singleton Pattern Test Case: ==== \n");

        ImprovedOpensourceSingleton firstObject = ImprovedOpensourceSingleton.getInstance();
        ImprovedOpensourceSingleton secondObject = ImprovedOpensourceSingleton.getInstance();

        assertTrue(firstObject.equals(secondObject));
    }
}
