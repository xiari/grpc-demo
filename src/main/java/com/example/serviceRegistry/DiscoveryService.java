package com.example.serviceRegistry;

import java.util.List;

public interface DiscoveryService {
    List<RpcUrl> getUrls(String registryHost, int registryPort);
}
