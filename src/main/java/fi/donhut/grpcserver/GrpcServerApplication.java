package fi.donhut.grpcserver;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcServerApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        int GRPC_PORT = 8888;
        final Server server = ServerBuilder.forPort(GRPC_PORT)
                .addService(new HelloServiceImpl())
                .build();

        System.out.println("Starting server... Port: " + GRPC_PORT);
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }

}
