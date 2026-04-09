package org.eddydashcode.java_design_patterns.structural.proxy.remote_service_caching;

public class ClientApplication {

    public static void main(String[] args) {
        RemoteService realService = new RealRemoteService();
        RemoteService proxy = new RemoteServiceProxy(realService);

        System.out.println(proxy.fetchData("weather")); // first call (remote)
        System.out.println(proxy.fetchData("weather")); // second call (cached)
        System.out.println(proxy.fetchData("news"));    // new call (remote)
    }
}
