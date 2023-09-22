package fi.donhut.grpcserver;

import fi.donhut.grpc.HelloRequest;
import fi.donhut.grpc.HelloResponse;
import fi.donhut.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("Request received from client:\n" + request);

        final String greeting = "Hello, " + request.getFirstName() + " " + request.getLastName() + "!";

        responseObserver.onNext(HelloResponse.newBuilder()
                .setGreeting(greeting)
                .setFirstName(request.getFirstName())
                .build());
        responseObserver.onCompleted();
    }
}
