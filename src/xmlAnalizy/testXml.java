package xmlAnalizy;

import org.junit.jupiter.api.Test;

public class testXml {
    @Test
    public void testXml() {
        DomDemo test = new DomDemo();
        test.parserXml("E:\\java-learning\\src\\xmlAnalizy\\xmlDemo.xml");
    }
}
