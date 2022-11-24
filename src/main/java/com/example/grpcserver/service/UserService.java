package com.example.grpcserver.service;

import com.example.user.proto.UserProto;
import com.example.user.proto.UserProto.StringRequest;
import com.example.user.proto.UserProto.StringResponse;
import com.example.user.proto.UserServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class UserService extends UserServiceGrpc.UserServiceImplBase {

  @Override
  public void hi(StringRequest request, StreamObserver<StringResponse> responseObserver) {
    String name = request.getName();
    UserProto.StringResponse response = UserProto.StringResponse.newBuilder().setResult("Hi! " + name).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
