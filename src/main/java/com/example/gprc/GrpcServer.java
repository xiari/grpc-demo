package com.example.gprc;

import com.example.gprc.grpcservice.DemoService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    private Server server;

    public void start() throws IOException{
        int port = 8899;
        server = ServerBuilder.forPort(port)
        .addService(new DemoService())
        .build()
        .start();
    }
    public void stop() throws  IOException{
        if(null != server){
            server.shutdown();
        }
    }
    public void blockingUtilShutdown() throws InterruptedException {
        if(null != server) {
            server.awaitTermination();
        }
    }


    public static void main(String[] args) throws Exception{
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.blockingUtilShutdown();
    }
}
