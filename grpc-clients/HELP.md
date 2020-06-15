# Overview for gRPC clients
1.  In src/main/java you'll see client for Java. 
* To generate the client, first you need to have your own stub (some say client).
* You'll also need the hello.proto file to generate this.
* Command to generate client: gradle build (this will copy the files to generated-resources)
* Now, you can use the generated files as you like.

2. In src/main/ruby you'll see client for Ruby.
* To generate client, you need to have the gem's
* To install the gems:
```shell script
gem install grpc
```
* To install grpc tools (needed for protoc - the proto compiler):
```shell script
gem install grpc-tools
```
```shell script
grpc_tools_ruby_protoc -I ../protos --ruby_out=lib --grpc_out=lib ../protos/helloworld.proto
```

## Make sure the server application is running before running the clients :)
