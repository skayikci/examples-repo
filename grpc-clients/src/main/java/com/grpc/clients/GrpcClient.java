package com.grpc.clients;

import com.example.grpcserver.GreeterGrpc;
import com.example.grpcserver.Hello;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);

        Hello.HelloReply helloResponse = stub.sayHello(Hello.HelloRequest.newBuilder()
                .setName("Serhat")
                .build());

        log.info("GreeterClient received response: " + helloResponse.getMessage());
        channel.shutdown();
    }
}
