package com.example.serviceRegistry;

import com.orbitz.consul.AgentClient;
import com.orbitz.consul.Consul;
import com.orbitz.consul.model.agent.ImmutableRegCheck;
import com.orbitz.consul.model.agent.ImmutableRegistration;

public class ConsulRegistryService extends AbstractConsulService implements  RegistryService {

    @Override
    public void register(RpcUrl url) {
        Consul consul = this.buildConsul(url.getHost(),url.getPort());
        AgentClient agentClient = consul.agentClient();

        ImmutableRegCheck check = ImmutableRegCheck.builder().tcp(url.getHost()+":"+url.getPort()).interval(CONSUL_HEALTH_INTERVAL).build();
        ImmutableRegistration.Builder builder = ImmutableRegistration.builder();
        builder.id(CONSUL_ID).name(CONSUL_NAME).addTags(CONSUL_TAGS).address(url.getHost()).port(url.getPort()).addChecks(check);

        agentClient.register(builder.build());
    }

    @Override
    public void unRegister(RpcUrl url) {

    }
}
