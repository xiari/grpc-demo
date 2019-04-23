package com.example.gprc.grpcservice;

import com.test.netty.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
        System.out.println("客户端请求数据: " + request.getMsg());

        Map<Long, String> m1;
        m1 = new HashMap<>();
        m1.put(1L, "AAAA");
        m1.put(2L, "BBBB");
        Info i1 = Info.newBuilder().setAge(10).setName("张三").setFlag(false).putAllOthers(m1).build();

        Map<Long, String> m2 = new HashMap<>();
        m2.put(3L, "XXXX");
        m2.put(4L, "YYYY");
        Info i2 = Info.newBuilder().setAge(20).setName("李四").setFlag(true).putAllOthers(m2).build();
        responseObserver.onNext(InfoResponse.newBuilder().addAllInfos(Arrays.asList(i1, i2)).build());
        responseObserver.onCompleted();
    }

    @Override
    public io.grpc.stub.StreamObserver<com.test.netty.proto.GreetRequest> greeting(
            io.grpc.stub.StreamObserver<com.test.netty.proto.GreetResponse> responseObserver) {
        return new StreamObserver<GreetRequest>() {
            //该方法会一直监听客户端的 onNext()方法，如果客户端调用了onNext()方法，那么该方法就会被触发
            @Override
            public void onNext(GreetRequest greetRequest) {
                System.out.println("客户端端的数据： " +greetRequest.getName());
            }

            @Override
            public void onError(Throwable throwable) {

            }
            //该方法会等待着客户端的onCompleted()方法被调用，如果客户端调用了onCompleted()方法，那么该方法会被调用
            @Override
            public void onCompleted() {
                responseObserver.onNext(GreetResponse.newBuilder().setDate(new Date() + "")
                        .setMsg("data1 ")
                        .build());
                responseObserver.onCompleted();
            }
        };

    }

    @Override
    public void getPeoplesByName(com.test.netty.proto.PeopleRequest request,
                                 io.grpc.stub.StreamObserver<com.test.netty.proto.PeopleList> responseObserver) {
        System.out.println("客户端请求的数据: " + request.getName());

        People p1 = People.newBuilder().setAge(10).setHeight(166.67f).setName("张三").setMoney(45).setIsMarried(true).build();
        People p2 = People.newBuilder().setAge(20).setHeight(176.67f).setName("李四").setMoney(4500).setIsMarried(true).build();
        People p3 = People.newBuilder().setAge(30).setHeight(186.67f).setName("王五").setMoney(45.90).setIsMarried(false).build();

        PeopleList list = PeopleList.newBuilder().addAllPeoples(Arrays.asList(p1, p2, p3)).build();

        responseObserver.onNext(list);
        responseObserver.onCompleted();
    }
}