package com.example.gprc;

import com.test.netty.proto.DemoServiceGrpc;
import com.test.netty.proto.MyResponse;
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

    public class DemoService extends DemoServiceGrpc.DemoServiceImplBase{
        @Override
        public void getUserById(com.test.netty.proto.MyRequest request,
                                io.grpc.stub.StreamObserver<com.test.netty.proto.MyResponse> responseObserver) {
            System.out.println("客户端的参数: " + request.getId());

            responseObserver.onNext(MyResponse.newBuilder().setRealname("张三").build());
            responseObserver.onCompleted();

        }

        @Override
        public void getInfos(com.test.netty.proto.InfoRequest request,
                             io.grpc.stub.StreamObserver<com.test.netty.proto.InfoResponse> responseObserver) {

        }

        @Override
        public io.grpc.stub.StreamObserver<com.test.netty.proto.GreetRequest> greeting(
                io.grpc.stub.StreamObserver<com.test.netty.proto.GreetResponse> responseObserver) {
//            return GreetRequest.newBuilder().build();
            return null;

        }

        @Override
        public void getPeoplesByName(com.test.netty.proto.PeopleRequest request,
                                     io.grpc.stub.StreamObserver<com.test.netty.proto.PeopleList> responseObserver) {

        }
    }
    public static void main(String[] args) throws Exception{
        GrpcServer grpcServer = new GrpcServer();
        grpcServer.start();
        grpcServer.blockingUtilShutdown();
    }
}
