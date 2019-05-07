package com.example.serviceRegistry;

public interface RegistryService {
    void register(RpcUrl url);
    void unRegister(RpcUrl url);
}
