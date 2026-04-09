package org.eddydashcode.java_design_patterns.structural.proxy.remote_service_caching;

public class RealRemoteService implements RemoteService {

    @Override
    public String fetchData(String query) {
        simulateNetworkLatency();
        return "Data for: " + query + " [from remote]";
    }

    private void simulateNetworkLatency() {
        try {
            System.out.println("Simulating network call...");
            Thread.sleep(2000); // 2 seconds to simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
