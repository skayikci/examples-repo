#!/usr/bin/env ruby

$LOAD_PATH.unshift(File.expand_path(__dir__))

require 'grpc'
require 'hello_services_pb'

def main
  user = ARGV.size > 0 ?  ARGV[0] : 'world'
  hostname = ARGV.size > 1 ?  ARGV[1] : 'localhost:8080'
  stub = Grpcserver::Greeter::Stub.new(hostname, :this_channel_is_insecure)
  begin
    message = stub.say_hello(Grpcserver::HelloRequest.new(name: user)).message
    p "Greeting: #{message}"
  rescue GRPC::BadStatus => e
    abort "ERROR: #{e.message}"
  end
end

main
