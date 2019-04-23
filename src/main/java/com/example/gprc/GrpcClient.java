package com.example.gprc;

import com.test.netty.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcClient {

    private ManagedChannel managedChannel;
    //阻塞的方式，一元的方法和请求为非流式数据都可以采用该方式
    private DemoServiceGrpc.DemoServiceBlockingStub blockingStub;
    //非阻塞方式，所有的方法都可以采用这种方式，对于请求为流式数据，必须使用该方式
    private DemoServiceGrpc.DemoServiceStub demoStub;

    public GrpcClient(ManagedChannel managedChannel){
        this.managedChannel = managedChannel;
        this.blockingStub = DemoServiceGrpc.newBlockingStub(managedChannel);
        this.demoStub = DemoServiceGrpc.newStub(managedChannel);

    }
    public GrpcClient( String host,int port){
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
    }

    /**
     * 普通调用
     */
    public void getUserId(){
        MyResponse response = this.blockingStub.getUserById(MyRequest.newBuilder().setId(1999).build());
        System.out.println("服务端返回的数据： " + response.getRealname());

    }
    /**
     * rpc GetInfos(InfoRequest) returns (InfoResponse);
     */
    public void getInfos() {
        InfoResponse resp;
        resp = this.blockingStub.getInfos(InfoRequest.newBuilder().setMsg("信息一").build());
        resp.getInfosList().forEach(info -> {
            System.out.println(info.getAge() + ";;" + info.getName() + ";;" + info.getFlag());
            info.getOthersMap().forEach((k, v) -> {
                System.out.println(k + " == " + v);
            });
            System.out.println("------------------------------------------------");
        });
    }



    public static void main(String[] args) throws InterruptedException {
        GrpcClient client = new GrpcClient("localhost", 8899);
//        client.getUserById();
        //client.getInfos();
        //client.greeting();
        client.getUserId();
        Thread.sleep(10000);
    }
}
