package factory;

/**
 * OpensourceFactory.java
 *
 *  Implements a simple factory.
 *
 * @author Bryant Son
 * @since 06/26/2019
 */

public class OpensourceFactory {
    //Vendor 供应商
    //这里接口OpensourceJVMServers用作返回类型
    public OpensourceJVMServers getServerByVendor(String name) {
        if(name.equals("Apache")) {
            return new Tomcat();//返回接口或者返回接口的一个实现
        }
        else if(name.equals("Eclipse")) {
            return new Jetty();
        }
        else if (name.equals("RedHat")) {
            return new WildFly();
        }
        else {
            return null;
        }
    }

}
