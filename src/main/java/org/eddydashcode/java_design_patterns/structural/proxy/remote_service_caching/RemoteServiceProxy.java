package org.eddydashcode.java_design_patterns.structural.proxy.remote_service_caching;

import java.util.HashMap;
import java.util.Map;

public class RemoteServiceProxy implements RemoteService{

    private final RemoteService realService;
    private final Map<String, String> cache = new HashMap<>();

    public RemoteServiceProxy(RemoteService realService) {
        this.realService = realService;
    }

    @Override
    public String fetchData(String query) {
        if (cache.containsKey(query)) {
            System.out.println("Returning cached result for: " + query);
            return cache.get(query);
        }

        String result = realService.fetchData(query);
        cache.put(query, result);
        return result;
    }
}
