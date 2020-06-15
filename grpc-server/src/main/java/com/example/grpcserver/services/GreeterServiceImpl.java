package com.example.grpcserver.services;

import com.example.grpcserver.GreeterGrpc;
import com.example.grpcserver.Hello;
import io.grpc.stub.StreamObserver;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(
            Hello.HelloRequest request, StreamObserver<Hello.HelloReply> responseObserver) {

        String greeting = "Hello, " + request.getName();

        Hello.HelloReply response = Hello.HelloReply.newBuilder()
                .setMessage(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
