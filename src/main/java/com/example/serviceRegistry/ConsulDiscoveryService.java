package com.example.serviceRegistry;

import com.google.common.collect.Lists;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.health.ImmutableServiceHealth;

import java.util.List;

public class ConsulDiscoveryService extends AbstractConsulService implements  DiscoveryService {

    @Override
    public List<RpcUrl> getUrls(String registryHost, int registryPort) {

        List<RpcUrl> urls= Lists.newArrayList();
        HealthClient client = this.buildConsul(registryHost, registryPort).healthClient();
        ConsulResponse object = client.getAllServiceInstances("web");
        List<ImmutableServiceHealth> serviceHealths=(List<ImmutableServiceHealth>)object.getResponse();
        for(ImmutableServiceHealth serviceHealth:serviceHealths){
            RpcUrl url=new RpcUrl();
            url.setHost(serviceHealth.getService().getAddress());
            url.setPort(serviceHealth.getService().getPort());
            urls.add(url);
        }
        return urls;
    }
}
