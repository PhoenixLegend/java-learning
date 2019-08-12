package factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testFactory {
    @Test
    public void test_opensourceFactory(){
        OpensourceFactory fac = new OpensourceFactory();
        //OpensourceJVMServers server = fac.getServerByVendor("Eclipse");
        assertEquals(fac.getServerByVendor("Eclipse").getName(),"Jetty");
    }
}
