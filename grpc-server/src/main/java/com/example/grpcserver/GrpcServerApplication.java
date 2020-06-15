package com.example.grpcserver;

import com.example.grpcserver.services.GreeterServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class GrpcServerApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		//SpringApplication.run(GrpcServerApplication.class, args);
		Server server = ServerBuilder
				.forPort(8080)
				.addService(new GreeterServiceImpl()).build();

		server.start();
		server.awaitTermination();
	}

}
